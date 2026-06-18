package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumTotalSubarrayValueIITest {

  @Test
  fun testProcessStr() {
    val solution = Solution()

    // Test case 1: Basic string with letters
    assertEquals('a', solution.processStr("abc", 0L))
    assertEquals('b', solution.processStr("abc", 1L))
    assertEquals('c', solution.processStr("abc", 2L))
    assertEquals('.', solution.processStr("abc", 3L))

    // Test case 2: String with backspace (*)
    assertEquals('b', solution.processStr("ab*c", 0L))
    assertEquals('c', solution.processStr("ab*c", 1L))
    assertEquals('.', solution.processStr("ab*c", 2L))

    // Test case 3: String with double (#)
    assertEquals('a', solution.processStr("a#", 0L))
    assertEquals('a', solution.processStr("a#", 1L))
    assertEquals('.', solution.processStr("a#", 2L))

    // Test case 4: String with reverse (%)
    assertEquals('c', solution.processStr("abc%", 0L))
    assertEquals('b', solution.processStr("abc%", 1L))
    assertEquals('a', solution.processStr("abc%", 2L))
    assertEquals('.', solution.processStr("abc%", 3L))

    // Test case 5: Complex string with multiple operations
    assertEquals('b', solution.processStr("ab*c#", 0L))
    assertEquals('b', solution.processStr("ab*c#", 1L))
    assertEquals('.', solution.processStr("ab*c#", 2L))

    // Test case 6: Empty string
    assertEquals('.', solution.processStr("", 0L))

    // Test case 7: String with only special characters
    assertEquals('.', solution.processStr("*#%", 0L))
  }
}
