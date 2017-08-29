package example

// Java code in the comments is from from https://docs.oracle.com/javase/tutorial/collections/streams/examples/ReductionExamples.java

/*
// 7. Group names by gender

        System.out.println("Names by gender:");
        Map<Person.Sex, List<String>> namesByGender =
                roster
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getGender,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toList())));

        List<Map.Entry<Person.Sex, List<String>>>
                namesByGenderList =
                new ArrayList<>(namesByGender.entrySet());

        namesByGenderList
                .stream()
                .forEach(e -> {
                    System.out.println("Gender: " + e.getKey());
                    e.getValue()
                            .stream()
                            .forEach(f -> System.out.println(f));
                });
 */

object GroupNamesByGender extends App {
  val namesByGender: Map[Person.Sex, List[String]] =
    Data.roster
      .groupBy(_.gender)
      .map { case (gender, people) =>
        gender -> people.map(_.name) // no need for specialized "groupingBy" with collector
      }
  namesByGender.foreach { case (gender, names) => // well-named local variables
    println(s"Gender: $gender")
    names.foreach(println(_))
  }
}
