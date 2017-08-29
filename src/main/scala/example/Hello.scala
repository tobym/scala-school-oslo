package example

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object ForComprehensionWithFutures extends App {
  // for comprehension with "Future"
  // These future are launched in _parallel_ because no dependencies are present
  // Both requests incur their own 4-second delay, but the total runtime is
  // still just 4 seconds because they run in parallel.
  val osloF = WebService.getWeather(City("Oslo"))
  val nycF = WebService.getWeather(City("New York"))
  val resultF = for {
    osloTemp <- osloF
    nycTemp <- nycF
  } yield s"Oslo is ${osloTemp.prettyCompare(nycTemp)} than NYC"

  val restult = Await.result(resultF, 10 seconds)
  println(restult)
}


object WebService {
  def getWeather(city: City): Future[Weather] = Future {
    Thread.sleep(4000)  // Simulate 4-second delay
    city match {
      case City("Oslo") => Weather(17)
      case City("New York") => Weather(19)
      case _ => Weather(util.Random.nextInt(25))
    }
  }
}

case class City(name: String)
case class Weather(temperatureCelcius: Int) {
  def prettyCompare(other: Weather): String = {
    val term = if (temperatureCelcius < other.temperatureCelcius) {
      "cooler"
    } else {
      "warmer"
    }
    val diff = math.abs(other.temperatureCelcius - temperatureCelcius)
    s"$diff°C $term"
  }
}
