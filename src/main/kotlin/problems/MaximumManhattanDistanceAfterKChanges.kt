package problems

import kotlin.math.abs

/**
 * Maximum Manhattan Distance After K Changes
 *
 * @param path movement string over {'N','S','E','W'}
 * @param maxEdits maximum number of moves we may replace
 * @return largest |x|+|y| obtainable at any time step
 */
fun maxDistance(path: String, maxEdits: Int): Int {
  var bestDistance = 0

  // running sums
  var prefixP = 0          // x + y
  var prefixQ = 0          // x - y

  // counts of +/-1 contributions seen so far
  var positiveP = 0
  var negativeP = 0
  var positiveQ = 0
  var negativeQ = 0

  for (move in path) {
    // update sums and counts ------------------------------------------------
    when (move) {
      'N' -> { prefixP += 1; prefixQ -= 1; positiveP++; negativeQ++ }
      'S' -> { prefixP -= 1; prefixQ += 1; negativeP++; positiveQ++ }
      'E' -> { prefixP += 1; prefixQ += 1; positiveP++; positiveQ++ }
      'W' -> { prefixP -= 1; prefixQ -= 1; negativeP++; negativeQ++ }
    }

    // best |p| using <=k edits in this prefix --------------------------------
    val maxPositiveP = prefixP + 2 * minOf(maxEdits, negativeP)
    val maxNegativeP = prefixP - 2 * minOf(maxEdits, positiveP)

    // best |q| using <=k edits in this prefix --------------------------------
    val maxPositiveQ = prefixQ + 2 * minOf(maxEdits, negativeQ)
    val maxNegativeQ = prefixQ - 2 * minOf(maxEdits, positiveQ)

    // record Manhattan distance at this step
    val currentBest = maxOf(
      abs(maxPositiveP), abs(maxNegativeP),
      abs(maxPositiveQ), abs(maxNegativeQ)
    )
    bestDistance = maxOf(bestDistance, currentBest)
  }

  return bestDistance
}
