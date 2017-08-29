package example

object PatternMatching extends App {
  /*
   * :: is the "cons" operator for a List, you can destructure parts of the list
   */
  def sum(sumSoFar: Int, xs: List[Int]): Int = xs match {
    case Nil => sumSoFar
    case head :: tail => sum(head + sumSoFar, tail)
  }
  val xs = List(1, 2, 3)
  println(s"Sum of $xs is ${sum(0, xs)}")
}
