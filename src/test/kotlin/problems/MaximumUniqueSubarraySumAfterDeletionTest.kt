package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumUniqueSubarraySumAfterDeletionTest {
  @Test
  fun example1() {
    val nums = intArrayOf(1, 2, 3, 4, 5)
    assertEquals(15L, maxSum(nums))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(1, 1, 0, 1, 1)
    assertEquals(1L, maxSum(nums))
  }

  @Test
  fun example3() {
    val nums = intArrayOf(1, 2, -1, -2, 1, 0, -1)
    assertEquals(3L, maxSum(nums))
  }
}
