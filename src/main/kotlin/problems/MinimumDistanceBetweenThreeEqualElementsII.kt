package problems

/**
 * 3741. Minimum Distance Between Three Equal Elements II
 *
 * For any triple of indices (i, j, k), sort them so i < j < k.
 * The distance becomes: |i - j| + |j - k| + |k - i| = (j - i) + (k - j) + (k - i) = 2 * (k - i)
 *
 * So the problem reduces to: For every value, pick 3 occurrences that minimize (max index - min index).
 *
 * Time Complexity: O(n) where n is the length of nums
 * Space Complexity: O(n) for storing indices by value
 *
 * @param nums The input array of integers
 * @return The minimum distance between three equal elements, or -1 if none exists
 */
fun minimumDistanceBetweenThreeEqualElementsII(nums: IntArray): Int {
  val positionsByValue = HashMap<Int, MutableList<Int>>()

  for (index in nums.indices) {
    val value = nums[index]
    positionsByValue.computeIfAbsent(value) { mutableListOf() }.add(index)
  }

  var minimumSpan = Int.MAX_VALUE

  for (indices in positionsByValue.values) {
    if (indices.size < 3) continue

    for (startIndex in 0 until indices.size - 2) {
      val span = indices[startIndex + 2] - indices[startIndex]
      minimumSpan = minOf(minimumSpan, span)
    }
  }

  return if (minimumSpan == Int.MAX_VALUE) -1 else 2 * minimumSpan
}
