package problems

fun judgePoint24(cards: IntArray): Boolean {
  val numbers = cards.map { it.toDouble() }.toMutableList()
  return canReachTwentyFour(numbers)
}

private fun canReachTwentyFour(values: MutableList<Double>): Boolean {
  val tolerance = 1e-6

  if (values.size == 1) {
    return kotlin.math.abs(values[0] - 24.0) < tolerance
  }

  // Try picking every ordered pair (i, j), i != j
  for (firstIndex in values.indices) {
    for (secondIndex in values.indices) {
      if (firstIndex == secondIndex) continue

      val a = values[firstIndex]
      val b = values[secondIndex]

      // Build the next list after removing indices firstIndex and secondIndex
      val remaining = mutableListOf<Double>()
      for (scanIndex in values.indices) {
        if (scanIndex != firstIndex && scanIndex != secondIndex) {
          remaining.add(values[scanIndex])
        }
      }

      // Candidate results of combining a and b
      val candidateResults = mutableListOf<Double>()

      // For commutative operations (+, *), only consider one ordering: enforce firstIndex < secondIndex
      if (firstIndex < secondIndex) {
        candidateResults.add(a + b)
        candidateResults.add(a * b)
      }

      // Non-commutative operations: both orders matter
      candidateResults.add(a - b)
      candidateResults.add(b - a)

      if (kotlin.math.abs(b) > 1e-9) candidateResults.add(a / b)
      if (kotlin.math.abs(a) > 1e-9) candidateResults.add(b / a)

      for (resultValue in candidateResults) {
        remaining.add(resultValue)
        if (canReachTwentyFour(remaining)) return true
        remaining.removeAt(remaining.lastIndex)
      }
    }
  }
  return false
}

