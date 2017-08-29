package example

object Syntax extends App {
  println("""
    |
    |## Multiple classes in single file
    |
    |This is nice when prototyping and when you have many simple related classes
    |that simply don't take up enough lines of code to warrant an entire file.
    |
    """.stripMargin)

  val dataSet = new DataSet[String, String](
    new ConsoleReader,
    new ConsoleWriter,
    str => s"$str (${str.length})"
  )
  dataSet.run()
}

trait Reader[+T] {
  def read(): Seq[T]
}
trait Writer[-T] {
  def write(t: T): Unit
}
class ConsoleReader extends Reader[String] {
  def read(): Seq[String] = {
    print("Enter some words: ")
    io.StdIn.readLine.split(" ")
  }
}
class ConsoleWriter extends Writer[Any] {
  def write(t: Any): Unit = { println(t) }
}
class DataSet[T, U](
  reader: Reader[T],
  writer: Writer[U],
  transformer: T => U
) {
  def run(): Unit = {
    reader.read().map(transformer).foreach(t => writer.write(t))
  }
}
