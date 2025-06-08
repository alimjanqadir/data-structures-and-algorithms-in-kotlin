package problems

/**
 * LeetCode 2537: Count the Number of Good Subarrays
 * https://leetcode.com/problems/count-the-number-of-good-subarrays/
 *
 * Returns the number of good subarrays with at least k pairs (i, j) with i < j and nums[i] == nums[j].
 *
 * @param nums the input array
 * @param k the minimum number of good pairs
 * @return the number of good subarrays
 */
fun countGood(nums: IntArray, k: Int): Long {
  var left = 0
  var totalPairs = 0L
  var result = 0L
  val freq = mutableMapOf<Int, Int>()

  for (right in nums.indices) {
    val num = nums[right]
    val count = freq.getOrDefault(num, 0)
    totalPairs += count
    freq[num] = count + 1

    // Shrink window from the left until pairs < k
    while (totalPairs >= k) {
      result += (nums.size - right)
      val leftNum = nums[left]
      val leftCount = freq[leftNum]!!
      totalPairs -= (leftCount - 1)
      freq[leftNum] = leftCount - 1
      left += 1
    }
  }

  return result
}
