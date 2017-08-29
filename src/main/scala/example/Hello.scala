package example

import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object IdiomaticOptionStyle extends App {

  // Use Option rather than null.  NPEs are very rare in Scala appliations.
  def divide(numerator: Double, denominator: Double): Option[Double] =
    if (denominator == 0)
      None
    else
      Some(numerator / denominator)

  println("divide(15, 5) = " + divide(15, 5))
  println("divide(15, 0) = " + divide(15, 0))

  // Chain over Option with map and flatMap and filter
  val total = 15
  val count = 3
  divide(total, count)
    .filter(_ > 2)
    .map(avg => s"Average ($avg) > 2")
    .foreach(println)

}
