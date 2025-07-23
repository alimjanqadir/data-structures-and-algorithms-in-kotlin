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
