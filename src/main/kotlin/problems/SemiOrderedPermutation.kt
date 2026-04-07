package problems

/**
 * 2717. Semi-Ordered Permutation
 * LeetCode problem: Easy
 *
 * Returns the minimum number of operations to make the permutation semi-ordered.
 * A semi-ordered permutation has first element = 1 and last element = n.
 * Operation: swap any two adjacent elements.
 *
 * Time Complexity: O(n) where n is the length of the array
 * Space Complexity: O(1)
 *
 * @param nums Integer array representing a permutation of integers from 1 to n
 * @return Minimum number of adjacent swaps to make it semi-ordered
 */
fun semiOrderedPermutation(nums: IntArray): Int {
  val n = nums.size

  // Find positions of 1 and n
  var indexOfOne = 0
  var indexOfN = 0

  for (i in nums.indices) {
    when (nums[i]) {
      1 -> indexOfOne = i
      n -> indexOfN = i
    }
  }

  // Swaps needed to move 1 to the front
  val swapsForOne = indexOfOne

  // Swaps needed to move n to the end
  // If 1 was originally before n, moving 1 doesn't affect n's position
  // If 1 was originally after n, moving 1 creates one extra space for n
  val swapsForN = if (indexOfOne < indexOfN) {
    (n - 1) - indexOfN
  } else {
    (n - 1) - indexOfN - 1
  }

  return swapsForOne + swapsForN
}
