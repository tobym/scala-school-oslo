package example

object Infix extends App {
  println("""
    |
    |## Call-by-name parameters
    |
    |Method parameters can be lazily called-by-name.
    |
    """.stripMargin)

  val scalaIsGreat = MyBool(true)

  // Triple-? is a symbolically-name method that just throws
  // NotImplementedError.  Great for stubbing out methods during development.
  // Since scalaIsGreat==true, no need to eagerly evaluate the ??? part; in fact
  // we prefer to be lazy here.
  println("scala or ???: " + (scalaIsGreat or ???))

}

case class MyBool(x: Boolean) {
  def and(that: MyBool): MyBool = if (x) that else this
  def or(that: MyBool): MyBool = if (x) this else that
  def negate: MyBool = MyBool(!x)
}
