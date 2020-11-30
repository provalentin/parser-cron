object Parser extends App {
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

  def parse(s: String, min: Int, max: Int): String = {
    s match {
      case "*" =>
        Range.inclusive(min, max).mkString(" ")
      case str if str.startsWith("*/") =>
        Range(min, max, str.substring(str.indexOf("/") + 1, str.length).toInt).mkString(" ")
      case str if str.contains("-") =>
        Range.inclusive(str.substring(min, str.indexOf("-")).toInt, str.substring(str.indexOf("-") + 1, str.length).toInt).mkString(" ")
      case str if str.contains(",") =>
        str.split(",").mkString(" ")
      case str if (str >= min.toString && str < max.toString) =>
        str
      case _ => "wrong string"
    }
  }

  def parseMin(s: String): String =
    parse(s, 0, 60)

  def parseHour(s: String): String =
    parse(s, 0, 24)

  def parseDOM(s: String): String =
    parse(s, 1, 31)

  def parseMonth(s: String): String =
    parse(s, 1, 12)
  def parseDOW(s: String): String =
    parse(s, 1, 7)
}