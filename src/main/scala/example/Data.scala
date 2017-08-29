package example

case class Person(gender: Person.Sex, age: Int, name: String)
object Person {
  sealed trait Sex
  object Sex {
    case object MALE extends Sex
    case object FEMALE extends Sex
  }
}

object Data {
  val roster = List(
    Person(Person.Sex.MALE, 20, "Bob"),
    Person(Person.Sex.MALE, 30, "Joe"),
    Person(Person.Sex.FEMALE, 40, "Alice"),
    Person(Person.Sex.FEMALE, 20, "Sue")
  )
}
