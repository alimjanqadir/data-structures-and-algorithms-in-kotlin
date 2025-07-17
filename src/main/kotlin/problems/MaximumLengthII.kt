package problems

/**
 * LeetCode 3202 - Find the Maximum Length of Valid Subsequence II
 */
fun maximumLength(nums: IntArray, k: Int): Int {
  val modulus = k
  val dp = Array(modulus) { IntArray(modulus) }
  val residueSeen = BooleanArray(modulus)

  var longestSoFar = 1
  for (value in nums) {
    val currentResidue = value % modulus
    val updatedRow = IntArray(modulus)
    for (targetRemainder in 0 until modulus) {
      val neededResidue = (targetRemainder - currentResidue + modulus) % modulus
      val extend =
        when {
          dp[neededResidue][targetRemainder] > 0 ->
            dp[neededResidue][targetRemainder] + 1
          residueSeen[neededResidue] -> 2
          else -> 0
        }
      updatedRow[targetRemainder] =
        maxOf(dp[currentResidue][targetRemainder], extend)
      if (updatedRow[targetRemainder] > longestSoFar) {
        longestSoFar = updatedRow[targetRemainder]
      }
    }
    dp[currentResidue] = updatedRow
    residueSeen[currentResidue] = true
  }
  return longestSoFar
}
