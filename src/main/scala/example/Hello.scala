package example

import scala.util._

object ForComprehensionWithTry extends App {
  // for comprehension with "Try" (short-circuits on Failure)
  val results = List("DMX", "Bob").map { name =>
    for {
      accountId <- Try(DB.getAccountId(name))
      score     <- Try(WebService.getGameScore(accountId))
    } yield s"$name ($accountId) has score: $score"
  }
  results.foreach(println)

}

object DB {
  def getAccountId(name: String): Int =
    if (name.contains("X"))
      throw new Exception(s"DB lookup failed for '$name'")
    else
      name.hashCode
}

object WebService {
  def getGameScore(accountId: Int): Int = accountId % 42
}
