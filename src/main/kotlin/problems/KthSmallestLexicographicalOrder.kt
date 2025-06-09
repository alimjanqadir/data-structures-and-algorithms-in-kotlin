package problems

/**
 * 440. K-th Smallest in Lexicographical Order
 *
 * Time Complexity: O(log_n^2) where n is the limit – each level of the tree is
 * traversed at most once.
 * Space Complexity: O(1)
 */
fun findKthNumber(limit: Int, k: Int): Int {
  var remainingMoves = k - 1  // start at "1"
  var prefix = 1L

  val bound = limit.toLong()
  while (remainingMoves > 0) {
    val steps = countSteps(bound, prefix, prefix + 1)
    if (steps <= remainingMoves) {
      remainingMoves -= steps
      prefix += 1
    } else {
      remainingMoves -= 1
      prefix *= 10
    }
  }
  return prefix.toInt()
}

/** Number of integers ≤ limit that start with any prefix in [firstPrefixStart, nextPrefixStart). */
private fun countSteps(limit: Long, firstPrefixStart: Long, nextPrefixStart: Long): Int {
  var lower = firstPrefixStart
  var upper = nextPrefixStart
  var total = 0L

  while (lower <= limit) {
    total += (minOf(limit + 1, upper) - lower)
    lower *= 10
    upper *= 10
  }
  return total.toInt()
}
