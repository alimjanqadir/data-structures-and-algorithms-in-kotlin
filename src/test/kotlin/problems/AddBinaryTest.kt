package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class AddBinaryTest {

  @Test
  fun testAddBinary() {
    // Test case 1: Basic addition (1 + 1 = 10)
    assertEquals("10", addBinary("1", "1"))

    // Test case 2: Different lengths (1010 + 1011 = 10101)
    assertEquals("10101", addBinary("1010", "1011"))

    // Test case 3: One string is empty (0 + 101 = 101)
    assertEquals("101", addBinary("0", "101"))

    // Test case 4: Both strings are "0" (0 + 0 = 0)
    assertEquals("0", addBinary("0", "0"))

    // Test case 5: Long strings with carry
    assertEquals("100000", addBinary("11111", "1"))

    // Test case 6: No carry (100 + 10 = 110)
    assertEquals("110", addBinary("100", "10"))

    // Test case 7: Multiple carries (1111 + 1111 = 11110)
    assertEquals("11110", addBinary("1111", "1111"))
  }
}
