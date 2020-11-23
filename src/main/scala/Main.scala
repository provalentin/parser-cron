object Main extends App {
  //val notParsedString = "*/15 0 1,5 * 1-5 /usr/bin/find"
  //val notParsedString = args(0)
  //println(s"Initial cron string: $notParsedString")
  println("args: "+ args.toList)
  val notParsedString = if (args.length > 0) args(0) else "*/15 0 1,5 * 1-5 /usr/bin/find"
  //split into segments
  val segments = notParsedString.split(" ").toList

  //parse mins
  println(s"minute        ${parseMin(segments(0))}")

  //parse hours
  println(s"hour          ${parseHour(segments(1))}")

  //parse days of month
  println(s"day of month  ${parseDOM(segments(2))}")

  //parse month
  println(s"month         ${parseMonth(segments(3))}")

  //parse days of week
  println(s"day of week   ${parseDOW(segments(4))}")

  //print command
  println(s"command       ${segments(5)}")


  def parseMin(s: String): String = {
    s match {
      case "*" =>
        (0 to 59).mkString(" ")
      case str if str.startsWith("*/") =>
        Range(0, 60, str.substring(str.indexOf("/") + 1, str.length).toInt).mkString(" ")
      case str if str.contains("-") =>
        Range.inclusive(str.substring(0, str.indexOf("-")).toInt, str.substring(str.indexOf("-") + 1, str.length).toInt).mkString(" ")
      case str if str.contains(",") =>
        str.split(",").mkString(" ")
      case str if (str >= "0" && str <= "59") =>
        str
      case _ => "wrong string"
    }
  }

  def parseHour(s: String): String = {
    s match {
      case "*" =>
        (0 to 23).mkString(" ")
      case str if str.startsWith("*/") =>
        Range(0, 24, str.substring(str.indexOf("/") + 1, str.length).toInt).mkString(" ")
      case str if str.contains("-") =>
        Range.inclusive(str.substring(0, str.indexOf("-")).toInt, str.substring(str.indexOf("-") + 1, str.length).toInt).mkString(" ")
      case str if str.contains(",") =>
        str.split(",").mkString(" ")
      case str if (str >= "0" && str <= "23") =>
        str
      case _ => "wrong string"
    }

  }

  def parseDOM(s: String): String = {
    s match {
      case "*" =>
        (1 to 31).mkString(" ")
      case str if str.startsWith("*/") =>
        Range(1, 31, str.substring(str.indexOf("/") + 1, str.length).toInt).mkString(" ")
      case str if str.contains("-") =>
        Range.inclusive(str.substring(0, str.indexOf("-")).toInt, str.substring(str.indexOf("-") + 1, str.length).toInt).mkString(" ")
      case str if str.contains(",") =>
        str.split(",").mkString(" ")
      case str if (str >= "1" && str <= "31") =>
        str
      case _ => "wrong string"
    }
  }

  def parseMonth(s: String): String = {
    s match {
      case "*" =>
        (1 to 12).mkString(" ")
      case str if str.startsWith("*/") =>
        Range(1, 12, str.substring(str.indexOf("/") + 1, str.length).toInt).mkString(" ")
      case str if str.contains("-") =>
        Range.inclusive(str.substring(0, str.indexOf("-")).toInt, str.substring(str.indexOf("-") + 1, str.length).toInt).mkString(" ")
      case str if str.contains(",") =>
        str.split(",").mkString(" ")
      case str if (str >= "1" && str <= "12") =>
        str
      case _ => "wrong string"
    }
  }

  def parseDOW(s: String): String = {
    s match {
      case "*" =>
        (1 to 7).mkString(" ")
      case str if str.startsWith("*/") =>
        Range(1, 7, str.substring(str.indexOf("/") + 1, str.length).toInt).mkString(" ")
      case str if str.contains("-") =>
        Range.inclusive(str.substring(0, str.indexOf("-")).toInt, str.substring(str.indexOf("-") + 1, str.length).toInt).mkString(" ")
      case str if str.contains(",") =>
        str.split(",").mkString(" ")
      case str if (str >= "1" && str <= "7") =>
        str
      case _ => "wrong string"
    }
  }

}