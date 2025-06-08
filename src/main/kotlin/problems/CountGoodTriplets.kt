package problems

/**
 * Efficient O(n log n) solution for LeetCode 2179: Count Good Triplets in an Array.
 * Given two permutations nums1 and nums2, counts the number of triplets (x, y, z)
 * such that their positions in both arrays are strictly increasing.
 *
 * @param nums1 The first permutation array
 * @param nums2 The second permutation array
 * @return The number of good triplets (as Long)
 */
fun countGoodTriplets(nums1: IntArray, nums2: IntArray): Long {
  val n = nums1.size
  // Map value to its index in nums2
  val posInNums2 = IntArray(n)
  for (i in 0 until n) {
    posInNums2[nums2[i]] = i
  }
  // Fenwick Tree (BIT) implementation
  class FenwickTree(size: Int) {
    private val tree = LongArray(size + 2)
    fun update(i: Int, delta: Long) {
      var idx = i + 1
      while (idx < tree.size) {
        tree[idx] += delta
        idx += idx and -idx
      }
    }
    fun query(i: Int): Long {
      var idx = i + 1
      var res = 0L
      while (idx > 0) {
        res += tree[idx]
        idx -= idx and -idx
      }
      return res
    }
  }
  // Count left: for each value, how many values with smaller posInNums2 have appeared
  val leftBIT = FenwickTree(n)
  val leftCount = LongArray(n)
  for (i in 0 until n) {
    val idx = posInNums2[nums1[i]]
    leftCount[i] = if (idx > 0) leftBIT.query(idx - 1) else 0L
    leftBIT.update(idx, 1)
  }
  // Count right: for each value, how many values with larger posInNums2 will appear
  val rightBIT = FenwickTree(n)
  val rightCount = LongArray(n)
  for (i in n - 1 downTo 0) {
    val idx = posInNums2[nums1[i]]
    rightCount[i] = rightBIT.query(n - 1) - rightBIT.query(idx)
    rightBIT.update(idx, 1)
  }
  // For each value as the middle, total triplets is leftCount[i] * rightCount[i]
  var result = 0L
  for (i in 0 until n) {
    result += leftCount[i] * rightCount[i]
  }
  return result
}