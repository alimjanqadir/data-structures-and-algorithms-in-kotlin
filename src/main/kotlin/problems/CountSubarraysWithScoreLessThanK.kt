package problems

/**
 * LeetCode: Count Subarrays With Score Less Than K
 * Returns the number of subarrays where sum * length < k.
 * https://leetcode.com/problems/count-subarrays-where-score-is-less-than-k/
 *
 * @param nums The input array
 * @param k The score threshold
 * @return The number of valid subarrays
 */
fun countSubarraysWithScoreLessThanK(nums: IntArray, k: Long): Long {
  var left = 0
  var windowSum = 0L    // long to avoid overflow
  var total = 0L
  for (right in nums.indices) {
    windowSum += nums[right]
    // Keep shrinking until the window score is valid
    while (windowSum * (right - left + 1) >= k && left <= right) {
      windowSum -= nums[left]
      left += 1
    }
    // All prefixes of the current window are valid
    total += (right - left + 1).toLong()
  }
  return total
}
