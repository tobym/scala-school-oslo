package example

object PatternMatching extends App {

  /*
   * Case classes provide destructuring in pattern matches!
   * _ means to ignore the value (match any).
   */
  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceMail(name, link) =>
        s"$name left you a message! Click the link to hear it: $link"
    }
  }

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceMail("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))
  println(showNotification(someVoiceRecording))
}

sealed trait Notification

case class Email(from: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceMail(contactName: String, link: String) extends Notification
