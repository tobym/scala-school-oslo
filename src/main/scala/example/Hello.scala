package example

import scala.util._

object PatternMatching extends App {

  /*
   * The match is now non-exhaustive, and the compiler will warn.  I enabled
   * scalacOptions += "-Xfatal-warnings" to make the build actually fail.
   */
  def showNotification(notification: Notification): String = {
    notification match {
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
    }
  }

  val sms = SMS("98765", "Hello")
  val email = Email("test@test.com", "foo", "bar")

  println(showNotification(sms))
  println(showNotification(email))
}

sealed trait Notification

case class Email(from: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceMail(contactName: String, link: String) extends Notification

case class SpamNotificationException(message: String) extends Exception(message)
