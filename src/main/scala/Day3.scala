import util.Resource

object Day3 extends App {
  def bags = Resource.forDay(3).getLines()

  def priority(char: Char): Int =
    char.toInt match {
      case l if l >= 97 => l - 96
      case u @ _        => u - 38
    }

  def part1 = {
    def toPrioritized(bag: String): Seq[Int] = {
      val (first, second) = bag.splitAt(bag.length / 2)
      assert(first.length == second.length)
      first.intersect(second).distinct.map(priority)
    }

    val matchingTotals = bags
      .flatMap(toPrioritized)
    println(matchingTotals.toList.sum)
  }

  def part2: Unit = {
    def groupAndRate(b: List[String]) =
      b.grouped(3)
        .flatMap(group => {
          group.reduce(_.intersect(_).distinct).map(priority)
        })

    val rated = groupAndRate(Resource.forDay(3).getLines().toList)
    println(rated.toList.sum)
  }

  part1
  part2

}
