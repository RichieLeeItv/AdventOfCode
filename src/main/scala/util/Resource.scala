package util

import scala.io.Source

object Resource {
  def forDay(day: Int) = {
    Source.fromResource(s"day1/day$day.txt")
  }
}
