package problems

/**
 * Solution for Minimum Operations to Make Array Values Equal to K
 * Time Complexity: O(n log n) due to sortedSet operations
 * Space Complexity: O(n) for storing elements greater than k
 */
fun minOperations(nums: IntArray, k: Int): Int {
  val greaterSet = sortedSetOf<Int>()
  for (num in nums) {
    if (num < k) return -1
    if (num > k) greaterSet.add(num)
  }
  return greaterSet.size
}
