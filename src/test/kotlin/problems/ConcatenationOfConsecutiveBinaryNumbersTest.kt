package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConcatenationOfConsecutiveBinaryNumbersTest {

  @Test
  fun `test concatenatedBinary with n = 1`() {
    // Binary: "1" -> Decimal: 1
    assertEquals(1, concatenatedBinary(1))
  }

  @Test
  fun `test concatenatedBinary with n = 2`() {
    // Binary: "1" + "10" = "110" -> Decimal: 6
    assertEquals(6, concatenatedBinary(2))
  }

  @Test
  fun `test concatenatedBinary with n = 3`() {
    // Binary: "1" + "10" + "11" = "11011" -> Decimal: 27
    assertEquals(27, concatenatedBinary(3))
  }

  @Test
  fun `test concatenatedBinary with n = 12`() {
    // Expected result from LeetCode example
    assertEquals(505379714, concatenatedBinary(12))
  }

  @Test
  fun `test concatenatedBinary with n = 5`() {
    // Binary: "1" + "10" + "11" + "100" + "101" = "110111100101" -> Decimal: 1765
    assertEquals(1765, concatenatedBinary(5))
  }

  @Test
  fun `test concatenatedBinary with n = 10`() {
    // Manual verification for smaller n
    val result = concatenatedBinary(10)
    assertEquals(462911642, result)
  }

  @Test
  fun `test concatenatedBinary with power of 2`() {
    // Test with n = 4 (power of 2)
    // Binary: "1" + "10" + "11" + "100" = "11011100" -> Decimal: 220
    assertEquals(220, concatenatedBinary(4))
  }

  @Test
  fun `test concatenatedBinary modulo operation`() {
    // Test with larger n to ensure modulo is working correctly
    val result = concatenatedBinary(100)
    // Result should be less than MOD
    assert(result < 1_000_000_007)
  }
}
