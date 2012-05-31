package org.timgroup.dojo

case class WeatherMunging(lines: List[String]) extends Munging {
  def dayWithTheSmallestTemperatureSpread: Int = {
    mungeDifference(lines, 0, 1, 2).toInt
  }
}
