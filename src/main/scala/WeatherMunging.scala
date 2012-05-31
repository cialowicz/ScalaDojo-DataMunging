package org.timgroup.dojo

case class WeatherMunging(val lines: List[String]) extends Munging {
  def dayWithTheSmallestTemperatureSpread = {
    val lineMatchRegex = """^\s+\d.*""".r
    lines.filter(lineMatchRegex.findFirstMatchIn(_).isDefined).map(_.trim.split("""\s+"""))
      .map(parseLine(_, 0, 1, 2))
      .map(cleanTuple(_))
      .map(calculateDiff(_))
      .sortWith(orderTuple(_, _))
      .head._1.toInt
  }
}
