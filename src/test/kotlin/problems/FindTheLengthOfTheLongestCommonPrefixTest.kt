package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindTheLengthOfTheLongestCommonPrefixTest {
  @Test
  fun `returns three for sample style case`() {
    val result = longestCommonPrefix(intArrayOf(1, 10, 100), intArrayOf(1000))
    assertEquals(3, result)
  }

  @Test
  fun `returns zero when there is no shared prefix`() {
    val result = longestCommonPrefix(intArrayOf(123, 456), intArrayOf(789, 890))
    assertEquals(0, result)
  }

  @Test
  fun `finds best match across multiple values`() {
    val result = longestCommonPrefix(intArrayOf(12, 9876, 42), intArrayOf(981, 12999, 777))
    assertEquals(2, result)
  }
}
