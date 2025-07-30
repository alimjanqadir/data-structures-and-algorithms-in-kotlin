package problems

/**
 * LeetCode: Longest Subarray With Maximum Value
 * Returns the length of the longest contiguous run of the
 * maximum value in the array.
 */
fun longestSubarray(nums: IntArray): Int {
  val maximumValue = nums.maxOrNull() ?: return 0

  var longestRunLength = 0
  var currentRunLength = 0

  for (element in nums) {
    if (element == maximumValue) {
      currentRunLength += 1
      if (currentRunLength > longestRunLength) {
        longestRunLength = currentRunLength
      }
    } else {
      currentRunLength = 0
    }
  }
  return longestRunLength
}
