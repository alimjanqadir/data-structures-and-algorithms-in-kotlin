package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class CountBinarySubstringsTest {

  @Test
  fun testCountBinarySubstrings() {
    // Test case 1: Example from LeetCode - "00110011"
    // Valid substrings: "0011", "01", "1100", "10", "0011", "01"
    assertEquals(6, countBinarySubstrings("00110011"))

    // Test case 2: Example from LeetCode - "10101"
    // Valid substrings: "10", "01", "10", "01"
    assertEquals(4, countBinarySubstrings("10101"))

    // Test case 3: Single character - no valid substrings
    assertEquals(0, countBinarySubstrings("0"))
    assertEquals(0, countBinarySubstrings("1"))

    // Test case 4: All same characters - no valid substrings
    assertEquals(0, countBinarySubstrings("0000"))
    assertEquals(0, countBinarySubstrings("1111"))

    // Test case 5: Alternating pattern - "010101"
    // Valid substrings: "01", "10", "01", "10", "01"
    assertEquals(5, countBinarySubstrings("010101"))

    // Test case 6: Groups of different sizes - "000110011"
    // Groups: 000(3), 11(2), 00(2), 11(2)
    // Valid substrings: min(3,2) + min(2,2) + min(2,2) = 2 + 2 + 2 = 6
    assertEquals(6, countBinarySubstrings("000110011"))

    // Test case 7: Empty string
    assertEquals(0, countBinarySubstrings(""))

    // Test case 8: Two characters - "01" and "10"
    assertEquals(1, countBinarySubstrings("01"))
    assertEquals(1, countBinarySubstrings("10"))

    // Test case 9: Two same characters - "00" and "11"
    assertEquals(0, countBinarySubstrings("00"))
    assertEquals(0, countBinarySubstrings("11"))

    // Test case 10: Long string with pattern - "001100110011"
    // Groups: 00(2), 11(2), 00(2), 11(2), 00(2), 11(2)
    // Valid substrings: 2+2+2+2+2 = 10
    assertEquals(10, countBinarySubstrings("001100110011"))

    // Test case 11: Unequal group sizes - "000111000"
    // Groups: 000(3), 111(3), 000(3)
    // Valid substrings: min(3,3) + min(3,3) = 3 + 3 = 6
    assertEquals(6, countBinarySubstrings("000111000"))

    // Test case 12: Single transition - "00001111"
    // Groups: 0000(4), 1111(4)
    // Valid substrings: min(4,4) = 4
    assertEquals(4, countBinarySubstrings("00001111"))
  }
}
