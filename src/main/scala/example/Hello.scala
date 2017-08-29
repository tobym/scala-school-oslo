package example

import scala.util.Random

object PatternMatching extends App {

  val x: Int = Random.nextInt(10)

  // Hey, look!  `match` is an expression as well!
  val amount = x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  println(s"$x is $amount")

}
