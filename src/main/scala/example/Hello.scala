package example

import scala.annotation.tailrec

object Destructuring extends App {
  // Tuple syntax is handy for quick, simple cases.
  def getPerson = ("Toby", "Oslo")
  val (name, city) = getPerson
  println(s"$name is in $city")


  // Case classes have the power!
  // Throwing away unneeded data with _ helps focus on data that is important.
  val Person(_, cities, interests) = Person.loadDefault()
  println(s"Here are default cities   : $cities")
  println(s"Here are default interests: $interests")


  // Regular expressions have it too
  val time = raw"(\d{2}):(\d{2})".r
  "18:30" match {
    case time(hour, _) => println(s"Parsed hour $hour and discarded minute")
  }


  // "Parsing" :)
  "18:30".split(":") match {
    case Array(hour, minute) => println(s"Parsed hour $hour and minute $minute")
  }
}

case class Person(name: String, cities: List[String], interests: List[String])
object Person {
  def loadDefault() = Person("Toby", List("NYC", "Oslo"), List("Scala"))
}
