class Agenda (val meetings: List[Meeting]) {

  def filterMeetingsByTimeOfDay(meetingsForTheDay: List[Meeting], timeOfDay: String): List[Meeting] = {
    val meetingsByTimeOfDay = meetingsForTheDay.filter(_.time.contains(timeOfDay))
    meetingsByTimeOfDay
  }

  def printMeetings(meetings: List[Meeting]) = {
    for (meeting <- meetings) println(s"  ${meeting.time}: ${meeting.name}")
  }

  def printMeetingsByTimeOfDay(meetingsForTheDay: List[Meeting], day: String, timeOfDay: String) = {
    val meetingsByTimeOfDay = filterMeetingsByTimeOfDay(meetingsForTheDay, timeOfDay)
    if (meetingsByTimeOfDay.nonEmpty) {
      timeOfDay match {
        case "am" => println(s"$day morning:")
        case "pm" => println(s"$day afternoon:")
      }
      printMeetings(meetingsByTimeOfDay)
    }
  }

  def printDaySchedule(day: String): Unit = {
    val meetingsForTheDay = meetings.filter(_.day == day)
    if (meetingsForTheDay.isEmpty) println(s"There are no meetings on $day")
    else {
      printMeetingsByTimeOfDay(meetingsForTheDay, day, "am")
      printMeetingsByTimeOfDay(meetingsForTheDay, day, "pm")
    }
  }
}

class Meeting (val name: String, val day: String, val time: String)

object Main extends App {
  val m1 = new Meeting("Retro", "Friday", "5pm")
  val m2 = new Meeting("Yoga", "Tuesday", "10am")
  val m3 = new Meeting("Team Meeting", "Tuesday", "3pm")
  val agenda = new Agenda(List(m1, m2, m3))
  agenda.printDaySchedule("Monday")
  agenda.printDaySchedule("Tuesday")
  agenda.printDaySchedule("Friday")
}