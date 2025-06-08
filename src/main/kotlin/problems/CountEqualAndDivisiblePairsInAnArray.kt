package problems

/**
 * LeetCode 2176. Count Equal and Divisible Pairs in an Array
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array/
 */
fun countPairs(nums: IntArray, k: Int): Int {
  // 1) Group indices by value
  val positionsByValue = nums
    .withIndex()
    .groupBy({ it.value }, { it.index })
    
  var count = 0
  // 2) For each value‑group, test only its own indices
  for (indices in positionsByValue.values) {
    for (a in 0 until indices.size) {
      for (b in a + 1 until indices.size) {
        val i = indices[a]
        val j = indices[b]
        if ((i.toLong() * j) % k == 0L) count++
      }
    }
  }
  return count
}
