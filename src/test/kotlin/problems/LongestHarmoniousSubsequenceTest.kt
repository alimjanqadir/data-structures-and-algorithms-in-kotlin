package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestHarmoniousSubsequenceTest {
  @Test
  fun example1() {
    val nums = intArrayOf(1, 3, 2, 2, 5, 2, 3, 7)
    assertEquals(5, findLHS(nums))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(1, 2, 3, 4)
    assertEquals(2, findLHS(nums))
  }

  @Test
  fun example3() {
    val nums = intArrayOf(1, 1, 1, 1)
    assertEquals(0, findLHS(nums))
  }
}
