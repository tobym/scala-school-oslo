package example

// Java code in the comments is from from https://docs.oracle.com/javase/tutorial/collections/streams/examples/ReductionExamples.java

/*
 // 9. Average age by gender

        System.out.println("Average age by gender:");
        Map<Person.Sex, Double> averageAgeByGender =
                roster
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getGender,
                                        Collectors.averagingInt(Person::getAge)));

        for (Map.Entry<Person.Sex, Double> e : averageAgeByGender.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
 */

object AverageAgeByGender extends App {
  Data.roster
    .groupBy(_.gender)
    .mapValues(people => people.map(_.age).sum.toDouble / people.size)
    .foreach { case (gender, averageAge) =>
      println(s"$gender: $averageAge")
    }
}

