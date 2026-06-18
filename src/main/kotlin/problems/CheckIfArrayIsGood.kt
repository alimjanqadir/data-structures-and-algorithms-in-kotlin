package problems

/**
 * 2784. Check if Array is Good
 * LeetCode problem: Easy
 *
 * Returns true when nums is a permutation of [1, 2, ..., n - 1, n, n].
 * The maximum value n must appear twice, every value from 1 to n - 1 must appear once,
 * and the array length must be n + 1.
 *
 * Time Complexity: O(n log n) where n is the length of nums
 * Space Complexity: O(1), ignoring sorting internals
 *
 * @param nums Integer array to verify
 * @return true if nums is good, false otherwise
 */
fun isGood(nums: IntArray): Boolean {
  nums.sort()

  val maximumValue = nums[nums.lastIndex]

  if (nums.size != maximumValue + 1) {
    return false
  }

  for (index in 0 until maximumValue - 1) {
    if (nums[index] != index + 1) {
      return false
    }
  }

  return nums[nums.lastIndex - 1] == maximumValue
}
