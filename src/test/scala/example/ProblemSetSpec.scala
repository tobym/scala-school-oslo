package example

import org.scalatest._

import org.scalatest._
import org.scalatest.Matchers._

class ProblemSetSpec extends FlatSpec {

  import ProblemSet._
  import ProblemSetSpec._

  "Lst apply" should "create a full list" in {
    Lst(1, 2, 3) shouldBe Elem(1, Elem(2, Elem(3, EmptyList)))
  }

  it should "create an empty list" in {
    Lst() shouldBe EmptyList
  }

  "Sum recursive" should "be correct" in {
    sumRecursive(Lst(1, 2, 3)) shouldBe 6
    sumRecursive(Lst.empty[Int]) shouldBe 0
  }

  "Reduce" should "be correct" in {
    reduce(Lst(1, 2, 3, 2), Math.max _) shouldBe 3
    reduce(Lst(1, 2, 3, 2), add) shouldBe 8
  }

  "Reduce generic" should "be correct" in {
    reduceGeneric[String](Lst("a", "b"), _ + _) shouldBe "ab"
  }

  "addN" should "be correct" in {
    List(1, 2, 3).map(addN(1)) shouldBe List(2, 3, 4)
  }

  "prepend" should "add element to front of list" in {
    prepend(1, EmptyList) shouldBe Lst(1)
    prepend(1, Lst(2, 3)) shouldBe Lst(1, 2, 3)
  }

  "append" should "add elemend to end of list" in {
    append(1, EmptyList) shouldBe Lst(1)
    append(1, Lst(2, 3)) shouldBe Lst(2, 3, 1)
  }

  "reverse" should "reverse a list" in {
    reverse(EmptyList) shouldBe EmptyList
    reverse(Lst(1)) shouldBe Lst(1)
    reverse(Lst(1, 2, 3)) shouldBe Lst(3, 2, 1)
  }

  "foldLeft" should "be correct" in {
    val list = Lst(1, 2, 3, 4)
    val addResult = 10
    val stringResult = "1234"
    foldLeft(list, 0, add) shouldEqual addResult
    foldLeft(list, "", strCatInt) shouldEqual stringResult
  }

  "map" should "be correct" in {
    map(Lst(1, 2, 3), intToString) shouldBe Lst("1", "2", "3")
  }

}

object ProblemSetSpec {
  def add(a: Int, b: Int) = a + b
  def strCatInt(s: String, i: Int): String = s + i.toString
  def intToString(i: Int) = i.toString
}
