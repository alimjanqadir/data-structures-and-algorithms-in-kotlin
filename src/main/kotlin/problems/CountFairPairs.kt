package problems

import java.util.Arrays

/**
 * Counts the number of pairs (i, j) such that i < j and nums[i] + nums[j] <= threshold.
 * Assumes the input array `nums` is sorted.
 *
 * @param nums Sorted array of integers.
 * @param threshold The upper bound for the sum of the pair.
 * @return The count of pairs satisfying the condition.
 */
private fun countPairsLessThanOrEqual(nums: IntArray, threshold: Long): Long {
  var count = 0L
  var left = 0
  var right = nums.size - 1

  while (left < right) {
    val currentSum = nums[left].toLong() + nums[right].toLong()

    if (currentSum <= threshold) {
      count += (right - left)
      left++
    } else {
      right--
    }
  }
  return count
}

/**
 * Counts the number of fair pairs (i, j) where 0 <= i < j < n and
 * lower <= nums[i] + nums[j] <= upper.
 *
 * @param nums The input array of integers.
 * @param lower The lower bound of the fair pair sum (inclusive).
 * @param upper The upper bound of the fair pair sum (inclusive).
 * @return The total number of fair pairs.
 */
fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
  Arrays.sort(nums)
  val countUpper = countPairsLessThanOrEqual(nums, upper.toLong())
  val countLowerMinus1 = countPairsLessThanOrEqual(nums, lower.toLong() - 1)
  return countUpper - countLowerMinus1
}
