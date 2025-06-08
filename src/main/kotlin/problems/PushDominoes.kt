class Solution {
  /**
   * Simulates the tipping of dominoes given initial pushes.
   * Uses two passes to calculate, for each position,
   * the time (distance) until a rightward or leftward force arrives,
   * then compares to determine the final orientation.
   */
  fun pushDominoes(dominoes: String): String {
    val lengthOfDominoes = dominoes.length
    // Arrays to record distance from nearest 'R' (from the left)
    val rightForceDistances = IntArray(lengthOfDominoes) { Int.MAX_VALUE }
    // Arrays to record distance from nearest 'L' (from the right)
    val leftForceDistances = IntArray(lengthOfDominoes) { Int.MAX_VALUE }

    // Pass 1: left-to-right to compute rightward forces
    var distanceSinceRightPush = Int.MAX_VALUE
    for (index in 0 until lengthOfDominoes) {
      when (dominoes[index]) {
        'R' -> distanceSinceRightPush = 0
        'L' -> distanceSinceRightPush = Int.MAX_VALUE
        else -> if (distanceSinceRightPush != Int.MAX_VALUE) {
          distanceSinceRightPush += 1
        }
      }
      rightForceDistances[index] = distanceSinceRightPush
    }

    // Pass 2: right-to-left to compute leftward forces
    var distanceSinceLeftPush = Int.MAX_VALUE
    for (index in lengthOfDominoes - 1 downTo 0) {
      when (dominoes[index]) {
        'L' -> distanceSinceLeftPush = 0
        'R' -> distanceSinceLeftPush = Int.MAX_VALUE
        else -> if (distanceSinceLeftPush != Int.MAX_VALUE) {
          distanceSinceLeftPush += 1
        }
      }
      leftForceDistances[index] = distanceSinceLeftPush
    }

    // Build the resulting state by comparing distances
    val resultBuilder = StringBuilder(lengthOfDominoes)
    for (index in 0 until lengthOfDominoes) {
      val rDistance = rightForceDistances[index]
      val lDistance = leftForceDistances[index]

      resultBuilder.append(
        when {
          rDistance < lDistance -> 'R'
          lDistance < rDistance -> 'L'
          else -> '.'
        }
      )
    }

    return resultBuilder.toString()
  }
}
