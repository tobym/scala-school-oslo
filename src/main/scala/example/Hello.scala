package example

import scala.util._

object ForComprehension extends App {
  val names = List("Alice", "Bob", "Eve")

  val messages = for {
    n    <- 1 to 3 // a Range
    name <- names  // a List
  } yield s"$n: $name"

  println(messages)


  // Desugared:
  val range = 1 to 3
  val messages2 = range.flatMap { n =>
    names.map { name =>
      s"$n: $name"
    }
  }
  println(messages2)
}
