package org.timgroup.dojo

case class FootballMunging(val lines: List[String]) extends Munging {
  def teamWithTheSmallestDifferenceBetweenForAndAgainst = {
    val lineMatchRegex = """^\s+\d.*""".r
    lines.filter(lineMatchRegex.findFirstMatchIn(_).isDefined).map(_.trim.split("""\s+"""))
      .map(parseLine(_, 1, 6, 8))
      .map(cleanTuple(_))
      .map(calculateDiff(_))
      .sortWith(orderTuple(_, _))
      .head._1
  }
}
