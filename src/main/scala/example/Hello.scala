package example

object Infix extends App {
  println("""
    |
    |## Infix notation
    |
    |Any method with one parameter can be used as an infix operator.  Operators
    |are just methods; you can use symbols to name methods (use wisely).
    |
    |## Examples of named and default parameters
    |Not unique to case classes, this is just a good example.
    |
    """.stripMargin)

  val scalaIsGreat = MyBool(true)
  val lannistersPayTheirDebts = MyBool(true)
  val twoPlusTwoIsFive = MyBool(false)

  println("scala     : " + scalaIsGreat)
  println("lannisters: " + lannistersPayTheirDebts)
  println("2+2=5     : " + twoPlusTwoIsFive)

  // Observe the infix placement of the `and` method.
  println("scala and lannisters: " + (scalaIsGreat and lannistersPayTheirDebts))
  println("scala and 2+2=5     : " + (scalaIsGreat and twoPlusTwoIsFive))


  // These two invocations are the same, just the latter reads better.
  println(1.+(1))
  println(1 + 1)
}

case class MyBool(x: Boolean) {
  def and(that: MyBool): MyBool = if (x) that else this
  def or(that: MyBool): MyBool = if (x) this else that
  def negate: MyBool = MyBool(!x)
}
