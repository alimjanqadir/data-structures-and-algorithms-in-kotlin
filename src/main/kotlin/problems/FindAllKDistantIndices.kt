package problems

/**
 * Return all indices i such that there exists j with |i - j| <= k and nums[j] == key.
 * This implementation uses a difference array to mark coverage intervals around
 * every occurrence of the key, resulting in O(n) time complexity.
 */
fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
  val n = nums.size
  // diff[x] represents the change in coverage count at position x
  val diff = IntArray(n + 1)

  // Mark coverage for each key occurrence
  for (index in nums.indices) {
    if (nums[index] == key) {
      val start = maxOf(0, index - k)
      val end = minOf(n - 1, index + k)
      diff[start] += 1
      diff[end + 1] -= 1
    }
  }

  // Prefix sum to accumulate coverage and collect valid indices
  val result = ArrayList<Int>()
  var coverage = 0
  for (i in 0 until n) {
    coverage += diff[i]
    if (coverage > 0) {
      result.add(i)
    }
  }
  return result
}
