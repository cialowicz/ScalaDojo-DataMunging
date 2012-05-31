package org.timgroup.dojo

case class WeatherMunging(lines: List[String]) extends Munging {
  def dayWithTheSmallestTemperatureSpread = {
    mungeDifference(lines, parseLine(0, 1, 2)).toInt
  }
}
