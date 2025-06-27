package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestSubsequenceRepeatedKTimesTest {
  @Test
  fun `basic examples`() {
    assertEquals("bba", longestSubsequenceRepeatedK("bababcba", 2))
    assertEquals("aa", longestSubsequenceRepeatedK("aaaaaa", 3))
    assertEquals("", longestSubsequenceRepeatedK("abcdef", 2))
  }
}

