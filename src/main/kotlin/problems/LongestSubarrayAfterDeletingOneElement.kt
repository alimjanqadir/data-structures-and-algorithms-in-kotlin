package problems.longestsubarrayafterdeletingoneelement

class Solution {
  fun longestSubarray(nums: IntArray): Int {
    var leftIndex = 0
    var zerosInWindow = 0
    var longestWindowLength = 0

    for (rightIndex in nums.indices) {
      if (nums[rightIndex] == 0) {
        zerosInWindow += 1
      }

      while (zerosInWindow > 1) {
        if (nums[leftIndex] == 0) {
          zerosInWindow -= 1
        }
        leftIndex += 1
      }

      val currentWindowLength = rightIndex - leftIndex + 1
      if (currentWindowLength > longestWindowLength) {
        longestWindowLength = currentWindowLength
      }
    }

    // Must delete exactly one element
    return longestWindowLength - 1
  }
}
