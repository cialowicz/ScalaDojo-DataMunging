package org.timgroup.dojo

trait Munging {
  def mungeDifference(lines: List[String], parseLine: (Array[String]) => (String, String, String)) = {
    val lineMatchRegex = """^\s+\d.*""".r
    lines.filter(lineMatchRegex.findFirstMatchIn(_).isDefined)
      .map(_.trim.split("""\*?\s+""")) // split on spaces, optionally starting with * (asterisk)
      .map(parseLine)
      .map(calculateDiff)
      .sortWith(orderTuple)
      .head._1
  }

  def parseLine(labelCol: Int, col1: Int, col2: Int)(line: Array[String]) = {
    (line(labelCol), line(col1), line(col2))
  }

  private def calculateDiff(tuple: (String, String, String)) = {
    (tuple._1, scala.math.abs(tuple._2.toInt - tuple._3.toInt))
  }

  private def orderTuple(first: (String, Int), second: (String, Int)) = {
    first._2 < second._2
  }
}
