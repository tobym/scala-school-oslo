package example

// Java code in the comments is from from https://docs.oracle.com/javase/tutorial/collections/streams/examples/ReductionExamples.java

/*
        // 8. Total age by gender

        System.out.println("Total age by gender:");
        Map<Person.Sex, Integer> totalAgeByGender =
                roster
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getGender,
                                        Collectors.reducing(
                                                0,
                                                Person::getAge,
                                                Integer::sum)));

        List<Map.Entry<Person.Sex, Integer>>
                totalAgeByGenderList =
                new ArrayList<>(totalAgeByGender.entrySet());

        totalAgeByGenderList
                .stream()
                .forEach(e ->
                        System.out.println("Gender: " + e.getKey() +
                                ", Total Age: " + e.getValue()));
 */

object TotalAgeByGender extends App {
  val totalAgeByGender: Map[Person.Sex, Int] =
    Data.roster
      .groupBy(_.gender)
      .mapValues(people => people.foldLeft(0)((sum, person) => sum + person.age))
  // Prefer "fold" to "reduce"; forces you to deal with the empty list case
  totalAgeByGender.foreach { case (gender, totalAge) =>
    println(s"Gender: $gender, Total Age: $totalAge")
  }
}
