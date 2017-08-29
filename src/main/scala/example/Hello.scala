package example

object Overview extends App {
  println("""
    |
    |## Compiler performance
    |
    |No-longer-relevant XKCD: https://xkcd.com/303/
    |
    |javac is still faster, but scalac does a lot more.  With sbt's incremental
    |compilation and sane organization of code, this is no longer a problem.
    |The incremental compiler is designed as a platform; it can run stand-alone
    |so other tools (IDEs) can use it.
    |
    |Scala 2.11.8 compilation is 15% faster than Scala 2.10.6.
    |Scala 2.12.3 compilation is 15-33% faster  than 2.11.8 (requires Java 8).
    |
  """.stripMargin)
}
