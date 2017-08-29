package example

import scala.annotation.tailrec

object TailRec extends App {
  /*
   * Uncomment the annotation to observe how the compiler helps you check that
   * the method is truly tail recursive.
   */
  // @tailrec
  def sumNotTailRecursive(xs: List[Int]): Int = xs match {
    case Nil => 0
    case head :: tail => head + sumNotTailRecursive(tail)
  }
  val xs = List(1, 2, 3)
  println(s"Sum of $xs is ${sumNotTailRecursive(xs)}")
}
