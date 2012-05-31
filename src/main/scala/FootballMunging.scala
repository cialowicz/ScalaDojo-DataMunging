package org.timgroup.dojo

case class FootballMunging(lines: List[String]) extends Munging {
  def teamWithTheSmallestDifferenceBetweenForAndAgainst = {
    mungeDifference(lines, parseLine(1, 6, 8))
  }
}
