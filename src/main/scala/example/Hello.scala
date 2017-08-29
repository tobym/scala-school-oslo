package example

object Syntax extends App {
  println("""
    |
    |## Expressions
    |
    |Nearly everything is an expression, which allows for easy assignment.
    |
    """.stripMargin)

  val condition = true
  val x = if (condition) {
            "hello world"
          } else {
            "goodnight moon"
          }
  println(x)


  // Even "try/catch" is an expression (note this is different from the Try utility class).
  val y: String = try {
                    throw new Exception("fail")
                  } catch {
                    case e: Exception => "here is some default value"
                  }
  println(y)

}
