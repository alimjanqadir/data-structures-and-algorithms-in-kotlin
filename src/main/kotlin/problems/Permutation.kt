package problems

fun permute(nums: IntArray): List<List<Int>> {
  val result = mutableListOf<List<Int>>()

  // Optimization 1: Use boolean array instead of removing/adding elements
  val used = BooleanArray(nums.size)
  val current = IntArray(nums.size)

  fun backtrack(position: Int) {
    // Base case: we've filled all positions
    if (position == nums.size) {
      result.add(current.toList())
      return
    }

    // Try each number in the current position
    for (i in nums.indices) {
      if (!used[i]) {
        used[i] = true
        current[position] = nums[i]
        backtrack(position + 1)
        used[i] = false
      }
    }
  }

  backtrack(0)
  return result
}

/**
 * Test cases
 */
fun main() {
  // Test Case 1: [1,2,3]
  println(permute(intArrayOf(1, 2, 3)))
  // Expected: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

  // Test Case 2: [0,1]
  println(permute(intArrayOf(0, 1)))
  // Expected: [[0,1],[1,0]]

  // Test Case 3: [1]
  println(permute(intArrayOf(1)))
  // Expected: [[1]]
}

/**
 * Optimizations applied:
 * 1. Used boolean array for tracking used elements instead of list modifications
 * 2. Used IntArray instead of MutableList for current permutation
 * 3. Position-based recursion instead of remaining elements
 * 4. Minimized object creation during recursion
 *
 * Time Complexity: Still O(n * n!) but with better constant factors
 * Space Complexity: O(n) - more efficient than the previous version
 * - used: O(n) for boolean array
 * - current: O(n) for current permutation
 * - recursion stack: O(n)
 *
 * Note: While the asymptotic complexity remains the same, this version:
 * - Reduces memory allocations
 * - Eliminates list modifications during backtracking
 * - Has better cache locality due to array usage
 * - Minimizes object creation in the recursion
 */