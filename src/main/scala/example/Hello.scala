package example

// Java code in the comments is from from https://docs.oracle.com/javase/tutorial/collections/streams/examples/ReductionExamples.java

/*
 // 6. Group members by gender

        System.out.println("Members by gender:");
        Map<Person.Sex, List<Person>> byGender =
                roster
                        .stream()
                        .collect(
                                Collectors.groupingBy(Person::getGender));

        List<Map.Entry<Person.Sex, List<Person>>>
                byGenderList =
                new ArrayList<>(byGender.entrySet());

        byGenderList
                .stream()
                .forEach(e -> {
                    System.out.println("Gender: " + e.getKey());
                    e.getValue()
                            .stream()
                            .map(Person::getName)
                            .forEach(f -> System.out.println(f));
                });
 */

object GroupMembersByGender extends App {
  val byGenderList: List[(Person.Sex, List[Person])] =
    Data.roster
      .groupBy(_.gender)
      .toList

  byGenderList
    .foreach { case (key, values) =>
      println(s"Gender: $key")
      values
        .map(_.name)
        .foreach(f => println(f))
    }
}
