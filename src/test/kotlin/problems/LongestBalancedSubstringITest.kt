package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestBalancedSubstringITest {
    
  @Test
  fun testLongestBalancedSubstringI() {
    // Test case 1: Simple balanced substring
    // "aaabbb" - all characters have same frequency (3)
    assertEquals(
      6,
      longestBalancedSubstringI("aaabbb")
    )

    // Test case 2: Single character repeated
    assertEquals(
      5,
      longestBalancedSubstringI("aaaaa")
    )

    // Test case 3: Different frequencies
    // "aabbb" - longest balanced substring is "aabb" (length 4)
    assertEquals(
      4,
      longestBalancedSubstringI("aabbb")
    )

    // Test case 4: Empty string
    assertEquals(
      0,
      longestBalancedSubstringI("")
    )

    // Test case 5: Single character
    assertEquals(
      1,
      longestBalancedSubstringI("a")
    )

    // Test case 6: Mixed characters with balanced frequencies
    // "aabbcc" - all frequencies are 2
    assertEquals(
      6,
      longestBalancedSubstringI("aabbcc")
    )

    // Test case 7: No balanced substring longer than 1
    // "abc" - each character appears once, so all have same frequency (1)
    assertEquals(
      3,
      longestBalancedSubstringI("abc")
    )

    // Test case 8: Longer balanced substring
    // "aaabbbcccddd" - all frequencies are 3
    assertEquals(
      12,
      longestBalancedSubstringI("aaabbbcccddd")
    )
  }
}
