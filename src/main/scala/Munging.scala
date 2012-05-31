package org.timgroup.dojo

trait Munging {
  def parseLine(line: Seq[String], labelCol: Int, col1: Int, col2: Int) = {
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
