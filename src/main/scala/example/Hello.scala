package example

object Generics extends App {
  val stack = new Stack[Fruit]
  val apple = new Apple
  val banana = new Banana

  stack.push(apple)
  stack.push(banana)
  printFruitStack(stack)
  // printFruitStack(new Stack[Apple]) // Woah, this doesn't compile!!!

  def printFruitStack(fruitStack: Stack[Fruit]) {
    println(fruitStack)
  }
}

class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) { elements = x :: elements }
  def peek: A = elements.head
  def pop(): A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }
  override def toString = s"Stack($elements)"
}

class Fruit { override def toString = "Fruit" }
class Apple extends Fruit { override def toString = "Apple" }
class Banana extends Fruit { override def toString = "Banana" }
