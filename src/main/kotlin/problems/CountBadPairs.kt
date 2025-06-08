package problems

/**
 * LeetCode 2364. Count Number of Bad Pairs
 * https://leetcode.com/problems/count-number-of-bad-pairs/
 */
fun countBadPairs(nums: IntArray): Long {
  val n = nums.size.toLong()
  // Total possible pairs
  val totalPairs = n * (n - 1) / 2

  // Count how many indices share the same (value - index)
  val freq = mutableMapOf<Long, Long>()
  for ((index, value) in nums.withIndex()) {
    val diff = value.toLong() - index
    freq[diff] = freq.getOrDefault(diff, 0L) + 1
  }

  // Sum up good pairs within each group: C(count, 2)
  var goodPairs = 0L
  for (count in freq.values) {
    goodPairs += count * (count - 1) / 2
  }

  // Bad pairs = total pairs − good pairs
  return totalPairs - goodPairs
}
