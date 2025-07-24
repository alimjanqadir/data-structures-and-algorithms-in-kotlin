package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumScoreAfterRemovalsOnATreeTest {
  @Test
  fun example1() {
    val nums = intArrayOf(1, 5, 5, 4, 11)
    val edges = arrayOf(
      intArrayOf(0, 1),
      intArrayOf(1, 2),
      intArrayOf(1, 3),
      intArrayOf(3, 4)
    )
    assertEquals(9, minimumScore(nums, edges))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(5, 5, 2, 4, 4, 2)
    val edges = arrayOf(
      intArrayOf(0, 1),
      intArrayOf(1, 2),
      intArrayOf(5, 2),
      intArrayOf(4, 3),
      intArrayOf(1, 3)
    )
    assertEquals(0, minimumScore(nums, edges))
  }
}
