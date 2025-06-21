package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumDeletionsToMakeStringKSpecialTest {
  @Test
  fun testMinimumDeletions() {
    // Already k-special
    assertEquals(0, minimumDeletions("aabbc", 1))

    // Need to trim one character to make frequencies equal
    assertEquals(1, minimumDeletions("aaaabbbbb", 0))

    // Removing the single low frequency character is optimal
    assertEquals(1, minimumDeletions("aaaaaab", 0))

    // Mixed deletions required
    assertEquals(1, minimumDeletions("abccc", 1))
  }
}
