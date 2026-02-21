package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class SpecialBinaryStringTest {

  @Test
  fun testBasicCase() {
    // Test case 1: Example from LeetCode - "11011000"
    // Expected: "11100100"
    assertEquals("11100100", makeLargestSpecial("11011000"))
  }

  @Test
  fun testAdditionalCases() {
    // Test case 2: Single special block - no change
    assertEquals("10", makeLargestSpecial("10"))

    // Test case 3: Empty string
    assertEquals("", makeLargestSpecial(""))

    // Test case 4: Single character - not special, returns empty
    assertEquals("", makeLargestSpecial("1"))
    assertEquals("", makeLargestSpecial("0"))
  }
}
