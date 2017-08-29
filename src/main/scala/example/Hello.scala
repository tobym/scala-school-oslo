package example

import scala.util._

object PatternMatching extends App {

  val spamNumbers = Set("12345", "11111")

  def showNotification(notification: Notification): Try[String] = {
    notification match {
      case Email(email, title, _) =>
        Success(s"You got an email from $email with title: $title")
      case SMS(number, message) if spamNumbers.contains(number) =>
        Failure(SpamNotificationException(s"Spam from $number: $message"))
      case SMS(number, message) =>
        Success(s"You got an SMS from $number! Message: $message")
      case VoiceMail(name, link) =>
        Success(s"$name left you a message! Click the link to hear it: $link")
    }
  }

  val spamSms = SMS("12345", "Refinance your home while earning $$$$")
  val goodSms = SMS("98765", "Hello")

  println(showNotification(spamSms))
  println(showNotification(goodSms))
}

sealed trait Notification

case class Email(from: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceMail(contactName: String, link: String) extends Notification

case class SpamNotificationException(message: String) extends Exception(message)
