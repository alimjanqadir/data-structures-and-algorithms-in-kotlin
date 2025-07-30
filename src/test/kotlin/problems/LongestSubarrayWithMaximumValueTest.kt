package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSubarrayWithMaximumValueTest {
  @Test
  fun example1() {
    val nums = intArrayOf(1, 2, 3, 3, 2, 1)
    assertEquals(2, longestSubarray(nums))
  }

  @Test
  fun allSame() {
    val nums = intArrayOf(2, 2, 2)
    assertEquals(3, longestSubarray(nums))
  }

  @Test
  fun mixedValues() {
    val nums = intArrayOf(1, 1, 0, 1, 1, 1, 0, 1)
    assertEquals(3, longestSubarray(nums))
  }

  @Test
  fun singleElement() {
    val nums = intArrayOf(3)
    assertEquals(1, longestSubarray(nums))
  }
}
