import util.Resource

object Day4 extends App {

  def defineRange(assignment: String) = {
    val bounds = assignment.split("-")
    bounds(0).toInt to bounds(1).toInt
  }

  def part1(): Unit = {
    val assignments = Resource.forDay(4).getLines()
    val overlapCount = assignments
      .map(ass => {
        val elves = ass.split(",")
        val range1 = defineRange(elves(0))
        val range2 = defineRange(elves(1))
        range1.containsSlice(range2) || range2.containsSlice(range1)
      })
      .count(e => e)

    println(overlapCount)
  }

  def part2(): Unit = {
    val assignments = Resource.forDay(4).getLines()
    val overlapCount = assignments
      .map(ass => {
        val elves = ass.split(",")
        val range1 = defineRange(elves(0))
        val range2 = defineRange(elves(1))
        range1.intersect(range2).nonEmpty
      })
      .count(e => e)
    println(overlapCount)
  }

  part1()
  part2()
}
