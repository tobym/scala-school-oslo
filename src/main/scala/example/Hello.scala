package example

object Overview extends App {
  println("""
    |
    |## Runtime performance
    |
    |Scala 2.12 (current stable version, released in 2016) targets Java 8
    |- traits can compile into interfaces with default methods.
    |- Scala FunctionN classes are now Java8's Single Abstract Method types
    |  (formerly these were their own classes).
    |- use `invokedynamic` for lambdas, no classfiles are generated
    |
    |The Scala library was too big; in 2.11 it dropped 20% of bytecode (xml,
    |parsing, swing, continuations) are all moved out to their own artifacts.
    |
    |More inlining, dead code elimination, and elimination of boxing/unboxing
    |results in smaller, faster generated bytecode.
    |
  """.stripMargin)
}
