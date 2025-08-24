package problems.longestsubarrayafterdeletingoneelement

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSubarrayAfterDeletingOneElementTest {
  private val solution = Solution()

  @Test
  fun example1() {
    val nums = intArrayOf(1, 1, 0, 1)
    assertEquals(3, solution.longestSubarray(nums))
  }

  @Test
  fun allOnes() {
    val nums = intArrayOf(1, 1, 1)
    assertEquals(2, solution.longestSubarray(nums))
  }

  @Test
  fun allZeros() {
    val nums = intArrayOf(0, 0, 0)
    assertEquals(0, solution.longestSubarray(nums))
  }
}
