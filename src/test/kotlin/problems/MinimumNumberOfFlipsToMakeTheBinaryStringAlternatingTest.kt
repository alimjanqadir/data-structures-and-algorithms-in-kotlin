package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumNumberOfFlipsToMakeTheBinaryStringAlternatingTest {

  @Test
  fun `test example 1`() {
    // Example from LeetCode: s = "001"
    // We can rotate to "010" which is already alternating, so 0 flips needed
    assertEquals(0, minFlips("001"))
  }

  @Test
  fun `test example 2`() {
    // Example from LeetCode: s = "010110"
    // Need 2 flips to make it alternating
    assertEquals(2, minFlips("010110"))
  }

  @Test
  fun `test example 3`() {
    // Example from LeetCode: s = "111000"
    // Need 2 flips to make it alternating
    assertEquals(2, minFlips("111000"))
  }

  @Test
  fun `test single character`() {
    // Single character is always alternating
    assertEquals(0, minFlips("0"))
    assertEquals(0, minFlips("1"))
  }

  @Test
  fun `test already alternating strings`() {
    // Already alternating strings should need 0 flips
    assertEquals(0, minFlips("01"))
    assertEquals(0, minFlips("10"))
    assertEquals(0, minFlips("010"))
    assertEquals(0, minFlips("101"))
    assertEquals(0, minFlips("0101"))
    assertEquals(0, minFlips("1010"))
  }

  @Test
  fun `test all same characters`() {
    // All zeros or all ones need multiple flips
    assertEquals(1, minFlips("00")) // Can rotate to "00", flip one to "01" or "10"
    assertEquals(1, minFlips("11")) // Can rotate to "11", flip one to "10" or "01"
    assertEquals(1, minFlips("000")) // Need 1 flip to make alternating (rotate to "000", flip middle to "010")
    assertEquals(1, minFlips("111")) // Need 1 flip to make alternating (rotate to "111", flip middle to "101")
  }

  @Test
  fun `test longer strings`() {
    assertEquals(2, minFlips("0011")) // Can rotate to "0100" or "0011", need 2 flips
    assertEquals(2, minFlips("000111")) // Need 2 flips
    assertEquals(4, minFlips("00001111")) // Need 4 flips
  }

  @Test
  fun `test complex cases`() {
    assertEquals(1, minFlips("10011"))
    assertEquals(2, minFlips("110100"))
    assertEquals(4, minFlips("11110000"))
  }

  @Test
  fun `test edge cases`() {
    // Empty string edge case (though problem likely assumes non-empty)
    assertEquals(0, minFlips(""))
    
    // Very short strings
    assertEquals(0, minFlips("0"))
    assertEquals(0, minFlips("1"))
    assertEquals(0, minFlips("01"))
    assertEquals(0, minFlips("10"))
  }

  @Test
  fun `test alternating patterns with rotation`() {
    // Test cases where rotation helps achieve alternating pattern
    assertEquals(0, minFlips("100")) // Can rotate to "001" then flip one to "010"
    assertEquals(0, minFlips("110")) // Can rotate to "101" which is alternating
    assertEquals(1, minFlips("1110")) // Can rotate to "0111" or "1110", need 1 flip
  }
}
