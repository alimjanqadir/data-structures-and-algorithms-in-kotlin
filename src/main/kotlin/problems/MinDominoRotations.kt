package problems

fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
  fun rotationsNeeded(targetValue: Int): Int {
    var flipsToMakeTopRow   = 0
    var flipsToMakeBottomRow = 0

    for (dominoIndex in tops.indices) {
      val topValue    = tops[dominoIndex]
      val bottomValue = bottoms[dominoIndex]

      // Candidate fails if targetValue absent in this domino
      if (topValue != targetValue && bottomValue != targetValue) {
        return Int.MAX_VALUE   // impossible
      }

      if (topValue != targetValue)   flipsToMakeTopRow   += 1
      if (bottomValue != targetValue) flipsToMakeBottomRow += 1
    }
    return minOf(flipsToMakeTopRow, flipsToMakeBottomRow)
  }

  val firstTop    = tops[0]
  val firstBottom = bottoms[0]

  val answer = minOf(
    rotationsNeeded(firstTop),
    rotationsNeeded(firstBottom)
  )

  return if (answer == Int.MAX_VALUE) -1 else answer
}
