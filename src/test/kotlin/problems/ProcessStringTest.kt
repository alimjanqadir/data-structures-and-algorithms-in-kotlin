package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class ProcessStringTest {
    
  @Test
  fun testProcessStr() {
    // Test case 1: Only lowercase letters
    assertEquals(
      "abc",
      processStr("abc"),
      "Should append lowercase letters"
    )

    // Test case 2: Delete operation with *
    assertEquals(
      "ab",
      processStr("abc*"),
      "Should delete last character with *"
    )

    // Test case 3: Duplicate operation with #
    assertEquals(
      "abcabc",
      processStr("abc#"),
      "Should duplicate current text with #"
    )

    // Test case 4: Reverse operation with %
    assertEquals(
      "cba",
      processStr("abc%"),
      "Should reverse the string with %"
    )

    // Test case 5: Multiple operations
    assertEquals(
      "ab",
      processStr("abc*"),
      "Should handle delete operation"
    )

    // Test case 6: Delete when empty
    assertEquals(
      "",
      processStr("*"),
      "Should handle delete when result is empty"
    )

    // Test case 7: Complex sequence
    assertEquals(
      "cba",
      processStr("abc%"),
      "Should reverse the string"
    )

    // Test case 8: Duplicate after delete
    assertEquals(
      "abab",
      processStr("abc*#"),
      "Should duplicate after delete"
    )

    // Test case 9: Reverse after duplicate
    assertEquals(
      "cbacba",
      processStr("abc#%"),
      "Should reverse after duplicate"
    )

    // Test case 10: Empty string
    assertEquals(
      "",
      processStr(""),
      "Should handle empty string"
    )
  }
}
