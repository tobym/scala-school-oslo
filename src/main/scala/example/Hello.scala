package example

object Syntax extends App {
  println("""
    |
    |## Nested methods
    |
    |This is nice when working with helper methods whose scope should be
    |constrained.
    |
    """.stripMargin)

  def factorial(x: Int): Int = {
    // This becomes a method named `fact$1` (see with :javap example.Syntax)
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x, 1)
  }

  println("Factorial of 4: " + factorial(4))

}

object Nested {

  def doSomething(n: Int): Int = {
    def stepOne = DB.read(n)
    def stepTwo = n * 2
    stepOne + stepTwo
  }

}

object DB { def read(n: Int): Int = n * n /* whatever :) */ }
