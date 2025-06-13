package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimizeTheMaximumDifferenceOfPairsTest {
  @Test
  fun example1() {
    val nums = intArrayOf(10, 1, 2, 7, 1, 3)
    assertEquals(1, minimizeMax(nums, 2))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(4, 2, 1, 2)
    assertEquals(0, minimizeMax(nums, 1))
  }

  @Test
  fun zeroPairs() {
    val nums = intArrayOf(5, 3, 10, 1, 6)
    assertEquals(0, minimizeMax(nums, 0))
  }

  @Test
  fun pairAllElements() {
    val nums = intArrayOf(1, 5, 6, 10)
    assertEquals(4, minimizeMax(nums, 2))
  }
}
