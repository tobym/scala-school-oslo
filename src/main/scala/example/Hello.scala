package example

object Extractors extends App {

  for {
    n <- 1 to 20
  } {
    val person = new Person(util.Random.nextInt(80))
    val personClass = person match {
      case Child(_) => "child"
      case Teen(_) => "teen"
      case Adult(_) => "adult"
    }
    println(s"$person is $personClass")
  }

}

class Person(val age: Int) {
  override def toString = s"Person($age)"
}
object Adult {
  def unapply(person: Person): Option[Int] = if (person.age > 19) Some(person.age) else None
}
object Teen {
  def unapply(person: Person): Option[Int] = if (13 <= person.age && person.age <= 19) Some(person.age) else None
}
object Child {
  def unapply(person: Person): Option[Int] = if (person.age < 13) Some(person.age) else None
}
