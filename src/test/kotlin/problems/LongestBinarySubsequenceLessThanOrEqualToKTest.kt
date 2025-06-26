package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestBinarySubsequenceLessThanOrEqualToKTest {
  @Test
  fun `basic examples`() {
    assertEquals(5, longestSubsequence("1001010", 5))
    assertEquals(6, longestSubsequence("00101001", 1))
  }
}
