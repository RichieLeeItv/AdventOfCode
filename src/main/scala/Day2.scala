import util.Resource

object Day2 extends App {
  val input = Resource.forDay(2).getLines().toList
  //1 rock
  //2 paper
  //3 scissors

  def part1 = {
    def gameOutCome(theirs: Int, yours: Int): Int = {
      def win = yours + 6
      def draw = yours + 3
      def loss = yours

      (theirs, yours) match {
        case (3, 1)                 => win
        case (1, 3)                 => loss
        case _ if (yours > theirs)  => win
        case _ if (theirs > yours)  => loss
        case _ if (theirs == yours) => draw
      }
    }

    val lookupMap = Map(
      'A' -> 1,
      'B' -> 2,
      'C' -> 3,
      'X' -> 1,
      'Y' -> 2,
      'Z' -> 3
    )

    val total = input.map { game =>
      val theirs = lookupMap(game(0))
      val yours = lookupMap(game(2))
      gameOutCome(theirs, yours)
    }.sum

    println(total)
  }

  def part2 = {
    val theirChoice = Map(
      'A' -> 1,
      'B' -> 2,
      'C' -> 3
    )

    def gameScore(theirs: Int, outcome: Char): Int = {
      // x lose, y draw, z win
      outcome match {
        case 'X' => ((theirs + 4) % 3) + 1 // big brain plays!
        case 'Y' => theirs + 3
        case 'Z' => (theirs % 3) + 1 + 6
      }
    }

    val scores = input.map { game =>
      val theirs = theirChoice(game(0))
      val requiredResult = game(2)
      gameScore(theirs, requiredResult)
    }

    println(scores.sum)
  }

  part1
  part2
}
