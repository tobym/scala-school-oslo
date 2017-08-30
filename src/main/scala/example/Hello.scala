package example

object InfixGenericTypes extends App {

  type ErrorMessage = String

  // Higher-kinded type that has two type parameters can be used in infix style
  // which reads well.
  def divide(numerator: Double, denominator: Double): Double Or ErrorMessage = {
    if (denominator == 0)
      Bad("denominator was zero!")
    else
      Good(numerator / denominator)
  }

  // This type signature is the same, just unsugared.
  def divide2(numerator: Double, denominator: Double): Or[Double, ErrorMessage] = {
    if (denominator == 0)
      Bad("denominator was zero!")
    else
      Good(numerator / denominator)
  }

  println(divide(3, 0))
  println(divide2(3, 0))
  println(divide(3, 2))
  println(divide2(3, 2))
}

sealed trait Or[+A, +B]
final case class Good[+A](a: A) extends Or[A, Nothing]
final case class Bad[+B](b: B) extends Or[Nothing, B]
