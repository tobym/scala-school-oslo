package example

// Java code in the comments is from from https://docs.oracle.com/javase/tutorial/collections/streams/examples/ReductionExamples.java

/*
import java.util.function.IntConsumer;

class Averager implements IntConsumer
{
    private int total = 0;
    private int count = 0;

    public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }

    public void accept(int i) { total += i; count++; }
    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}

Averager averageCollect = roster.stream()
  .filter(p -> p.getGender() == Person.Sex.MALE)
  .map(Person::getAge)
  .collect(Averager::new, Averager::accept, Averager::combine);
 */
object Average extends App {

  class ScaryMutableAverager(private var total: Int = 0, private var count: Int = 0) {
    def add(element: Int): ScaryMutableAverager = {
      total += element
      count += 1
      this
    }
    def combine(other: ScaryMutableAverager): ScaryMutableAverager = {
      total += other.total
      count += other.count
      this
    }
    def average: Double = if (total == 0) 0 else total.toDouble / count
  }

  // Idiomatic style
  case class Averager(total: Int = 0, count: Int = 0) {

    def add(element: Int): Averager =
      Averager(total + element, count + 1)

    def combine(other: Averager): Averager =
      Averager(total + other.total, count + other.count)

    def average: Double = if (total == 0) 0 else total.toDouble / count

  }

  val avg = Data.roster
    .filter(_.gender == Person.Sex.MALE)
    .map(_.age)
    .foldLeft(new Averager)( (averager, age) => averager.add(age) )
  println(avg.average)

  val (total, count) = Data.roster
    .filter(_.gender == Person.Sex.MALE)
    .map(_.age)
    .foldLeft((0, 0)) { case ((total, count), age) => (total + age, count + 1) }
  println(total.toDouble / count)

  val agg = Data.roster
    .filter(_.gender == Person.Sex.MALE)
    .map(_.age)
    .aggregate(new Averager)(_ add _, _ combine _) // Anonymous positional variables!
                                                   // Combine function only used in parallel
                                                   // collections; not needed here at all.
  println(agg.average)

}
