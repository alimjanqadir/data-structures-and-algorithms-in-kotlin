package problems

/**
 * Finds the length of the longest harmonious subsequence in the array.
 * A harmonious subsequence is one where the max and min differ by exactly 1.
 */
fun findLHS(nums: IntArray): Int {
  val frequencyByValue = mutableMapOf<Int, Int>()

  for (value in nums) {
    frequencyByValue[value] = frequencyByValue.getOrDefault(value, 0) + 1
  }

  var longestLength = 0
  for ((value, count) in frequencyByValue) {
    val nextCount = frequencyByValue[value + 1]
    if (nextCount != null) {
      val currentLength = count + nextCount
      if (currentLength > longestLength) {
        longestLength = currentLength
      }
    }
  }

  return longestLength
}
