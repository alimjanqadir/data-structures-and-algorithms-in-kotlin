package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class DivideArrayIntoArraysWithMaxDifferenceTest {
  @Test
  fun example1() {
    val nums = intArrayOf(1, 3, 4, 8, 7, 9, 3, 5, 1)
    val expected = arrayOf(
      intArrayOf(1, 1, 3),
      intArrayOf(3, 4, 5),
      intArrayOf(7, 8, 9)
    )
    val result = divideArray(nums, 2)
    assertTrue(result.contentDeepEquals(expected))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(2, 4, 2, 2, 5, 2)
    val result = divideArray(nums, 2)
    assertEquals(0, result.size)
  }

  @Test
  fun example3() {
    val nums = intArrayOf(4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11)
    val expected = arrayOf(
      intArrayOf(2, 2, 2),
      intArrayOf(4, 5, 5),
      intArrayOf(5, 5, 7),
      intArrayOf(7, 8, 8),
      intArrayOf(9, 9, 10),
      intArrayOf(11, 12, 12)
    )
    val result = divideArray(nums, 14)
    assertTrue(result.contentDeepEquals(expected))
  }
}
