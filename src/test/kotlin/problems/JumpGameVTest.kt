package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JumpGameVTest {
  @Test
  fun testExample1() {
    assertEquals(4, maxJumps(intArrayOf(6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12), 2))
  }

  @Test
  fun testExample2() {
    assertEquals(1, maxJumps(intArrayOf(3, 3, 3, 3, 3), 3))
  }

  @Test
  fun testExample3() {
    assertEquals(7, maxJumps(intArrayOf(7, 6, 5, 4, 3, 2, 1), 1))
  }

  @Test
  fun testBlockedByHigherValue() {
    assertEquals(2, maxJumps(intArrayOf(7, 1, 7, 1, 7, 1), 2))
  }
}
