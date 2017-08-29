package example

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object ForComprehensionWithFutures extends App {
  // for comprehension with "Future"
  // Future eventually returns a Try
  // These future are launched in _serial_ because of the name dependency
  val resultsFutures: List[Future[String]] =
    List("Alice", "DMX", "Bob").map { name =>
      for {
        accountId <- DB.getAccountId(name)
        score     <- WebService.getGameScore(accountId)
      } yield s"$name ($accountId) has score: $score"
    }

  // "Give me all results if they are all successful, otherwise give me the
  // first encountered exception as a Failure.
  val allGoodOrFailure: Future[List[String]] = Future.sequence(resultsFutures)

  allGoodOrFailure.onComplete { all =>
    println(s"allGoodOrFailure: $all")
    println("All results:")
    resultsFutures.foreach(println)
  }
}

object DB {
  def getAccountId(name: String): Future[Int] = Future {
    if (name.contains("X"))
      throw new Exception(s"DB lookup failed for '$name'")
    else
      name.hashCode
  }
}

object WebService {
  def getGameScore(accountId: Int): Future[Int] =
    Future { accountId % 42 }
}
