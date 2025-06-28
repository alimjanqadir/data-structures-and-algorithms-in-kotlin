package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class FindSubsequenceOfLengthKWithTheLargestSumTest {
  @Test
  fun example1() {
    val nums = intArrayOf(2, 1, 3, 3)
    val result = maxSubsequence(nums, 2)
    assertContentEquals(intArrayOf(3, 3), result)
  }

  @Test
  fun example2() {
    val nums = intArrayOf(-1, -2, 3, 4)
    val result = maxSubsequence(nums, 3)
    assertContentEquals(intArrayOf(-1, 3, 4), result)
  }

  @Test
  fun example3() {
    val nums = intArrayOf(3, 4, 3, 3)
    val result = maxSubsequence(nums, 2)
    assertContentEquals(intArrayOf(3, 4), result)
  }
}
