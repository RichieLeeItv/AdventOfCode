import util.Resource

import scala.util.{Failure, Success, Try}

object Day1 extends App {
  def solveHindSight(): Unit = {
    val elvesByCalories =
      Resource
        .forDay(1)
        .mkString("")
        .split("\n\n")
        .toList
        .map(_.split("\n").map(_.toInt).sum)

    printResults(elvesByCalories)
  }

  def solve(): Unit = {
    val elfData = Resource.forDay(1).getLines()

    val elvesByCalories = elfData
      .foldLeft((0, List(0)))((indexAndList, maybeCalories) => {
        val currentValue = indexAndList._1
        val elfList = indexAndList._2
        Try(maybeCalories.toInt) match {
          case Success(value) => (currentValue + value, elfList)
          case Failure(_)     => (0, elfList ++ List(currentValue))
        }
      })
      ._2

    printResults(elvesByCalories)
  }

  def printResults(elves: List[Int]) = {
    val maxCalories = elves.max
    val top3 = elves.sorted(Ordering.Int.reverse).take(3)
    val top3Total = top3.sum

    println(s"maxCalories: $maxCalories\ntop3: $top3\ntop3Total: $top3Total")
  }
}
