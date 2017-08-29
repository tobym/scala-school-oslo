package example

object CaseClasses extends App {
  println("""
    |
    |## Case classes
    |
    |A fundamental concept for data classes; think about a superpowered POJO.
    |- named parameters (actually, you get in any function!)
    |- sane hashcode and equals implementation
    |- `copy` method
    |- companion object, useful for "static" methods, constructors
    |
    |Intuition: case classes should contain immutable data!
    |
    |## Examples of named and default parameters
    |Not unique to case classes, this is just a good example.
    |
    """.stripMargin)

  val alice = Person("Alice", 30)
  println(alice)
  val bob = alice.copy(name = "Bob") // usage of named parameter!
  println(bob)
  val aliceTwin = Person("Alice", 30)
  println(aliceTwin)
  println(s"Alice == AliceTwin? (logical equality)  : ${alice == aliceTwin}")
  println(s"Alice eq AliceTwin? (reference equality): ${alice eq aliceTwin}")
}

case class Person(name: String, age: Int)

class UnsugaredPerson(val name: String, val age: Int) {
  // Default implementation is reference equality.
  // More on match syntax later; it is great.
  override def equals(other: Any): Boolean =
    other match {
      case o: UnsugaredPerson => o.name == name && o.age == age
      case _                  => false
    }
  override def hashCode: Int = 42 // something sane
  override def toString: String = s"UnsugaredPerson($name, $age)"
  // Not usage of default parameters
  def copy(name: String = name, age: Int = age): UnsugaredPerson =
    UnsugaredPerson(name, age)
}
object UnsugaredPerson {
  def apply(name: String, age: Int): UnsugaredPerson =
    new UnsugaredPerson(name, age)
  // and more, will explore this later
}
