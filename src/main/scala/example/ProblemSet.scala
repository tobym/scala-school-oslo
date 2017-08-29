package example

object ProblemSet {

  /** Our version of Scala's List[+T] */
  sealed trait Lst[+T]
  /** Our version of Scala's Nil */
  case object EmptyList extends Lst[Nothing]
  /** A cons cell in our Lst */
  case class Elem[T](head: T, tail: Lst[T]) extends Lst[T]

  object Lst {

    /** Varargs constructor of a Lst */
    def apply[T](elems: T*): Lst[T] = ???

    /** An empty list of Ts */
    def empty[T]: Lst[T] = EmptyList

  }

  /** sum a list of integers using recursion */
  def sumRecursive(xs: Lst[Int]): Int = ???

  /** Reduce many Ints from the list into a single Int by applying `f`.
   *  Note: reduce on an empty list is an invalid operation. (See for yourself:
   *  scala>> scala.collection.immutable.List.empty[Int].reduce(_ + _)
   */
  def reduce(xs: Lst[Int], f: (Int, Int) => Int): Int = ???

  /** Same as reduce, but with generice types */
  def reduceGeneric[T](xs: Lst[T], f: (T, T) => T): T = ???

  /** Returns a function that adds N to any given Int */
  def addN(n: Int): Int => Int = ???

  /* Add elem to front of list */
  def prepend[T](elem: T, list: Lst[T]): Lst[T] = ???

  /** Add elem to back of list */
  def append[T](elem: T, list: Lst[T]): Lst[T] = ???

  /** Reverse the order of list */
  def reverse[T](list: Lst[T]): Lst[T] = ???

  /** Implement your own stand-alone foldLeft */
  def foldLeft[T, U](list: Lst[T], acc: U, f: (U, T) => U): U = ???

  /** Implement map using the `foldLeft` you defined above */
  def map[T, U](list: Lst[T], f: T => U): Lst[U] = ???

}
