package org.timgroup.dojo

trait Munging {
  def mungeDifference(lines: List[String], labelCol: Int, col1: Int, col2: Int) = {
    val lineMatchRegex = """^\s+\d.*""".r
    lines.filter(lineMatchRegex.findFirstMatchIn(_).isDefined)
      .map(_.trim.split("""\s+"""))
      .map(parseLine(labelCol, col1, col2))
      .map(cleanTuple)
      .map(calculateDiff)
      .sortWith(orderTuple)
      .head._1
  }

  def parseLine(labelCol: Int, col1: Int, col2: Int)(line: Array[String]) = {
    (line(labelCol), line(col1), line(col2))
  }

  def cleanTuple(tuple: Tuple3[String, String, String]) = {
    (tuple._1, tuple._2.replace("*", "").toInt, tuple._3.replace("*", "").toInt)
  }

  def calculateDiff(tuple: Tuple3[String, Int, Int]) = {
    (tuple._1, scala.math.abs(tuple._2 - tuple._3))
  }

  def orderTuple(first: Tuple2[String, Int], second: Tuple2[String, Int]) = {
    first._2 < second._2
  }
}
