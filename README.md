# Scala School for Java Developers developers

A friendly and pragmatic introduction to Scala's benefits.

For a list of topics, look at the git log.  There is one topic per commit.

Ask me questions on Twitter: @tobym

## How to navigate

This project uses [groll](https://github.com/sbt/sbt-groll) to navigate through
the git history.  In sbt, use `groll initial` to start at the beginning, then
`groll next` and `groll prev` to move forwards and backwards, and `run` to run
the example's main class for a demo.

## Installing sbt and running the project

From https://github.com/paulp/sbt-extras:

    curl -Ls https://git.io/sbt > ~/bin/sbt && chmod 0755 ~/bin/sbt

Then launch sbt interactive shell from this project's base directory: `sbt`

This assumes you have ~/bin in your PATH, and you have Java 8 installed.

## Running code

From within sbt, issue `run`.

## Resting code

From within sbt, issue `test`.

## ProblemSet

At the end of the presentation is a problem set.  The tests are implemented
already, just run `sbt test`.  Put implementations in ProblemSet.scala.
