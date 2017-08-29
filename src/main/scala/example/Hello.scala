package example

object Covariance extends App {
  val apple = new Apple
  val banana = new Banana

  val fruitStack: Stack[Fruit] =
    new Stack[Apple]
      .push(apple)
      .push(banana) // Woah!!! This "ups" the type from Apple to Fruit

  // Of course, Stack[Fruit] can be passed to method which takes Stack[Fruit]
  printFruitStack(fruitStack)

  // Now because Stack is covariant, Stack[Apple] can be passed to method which
  // requires Stack[Fruit].  (Remove the + variance annotation in the Stack
  // definition below to see how compilation fails when the type is invariant).
  printFruitStack(new Stack[Apple])

  def printFruitStack(fruitStack: Stack[Fruit]) {
    println(fruitStack)
  }
}

/* Immutable data structure allows "modification" via copies.
 * The +A type annotation means that Stack[Fruit] is a supertype of
 * Stack[Apple].
 */
case class Stack[+A](elements: List[A] = Nil) {
  // This type annotation means that B is a supertype of A (like Fruit to Apple)
  def push[B >: A](x: B): Stack[B] = {
    Stack(x :: elements)
  }
  def peek: A = elements.head
  def pop(): (A, Stack[A]) = {
    (elements.head, Stack(elements.tail))
  }
  override def toString = s"Stack($elements)"
}

class Fruit { override def toString = "Fruit" }
class Apple extends Fruit { override def toString = "Apple" }
class Banana extends Fruit { override def toString = "Banana" }
