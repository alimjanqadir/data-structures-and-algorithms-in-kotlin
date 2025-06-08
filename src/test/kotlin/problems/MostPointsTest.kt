package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MostPointsTest {
  @Test
  fun testMostPoints() {
    val testCases = listOf(
      Triple(arrayOf(intArrayOf(3, 2), intArrayOf(4, 3), intArrayOf(4, 4), intArrayOf(2, 5)), 5L, "Example 1"),
      Triple(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(5, 5)), 7L, "Example 2"),
      Triple(arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3)), 4L, "Simple case"),
      Triple(arrayOf(intArrayOf(10, 1), intArrayOf(1, 10)), 10L, "Edge case"),
      Triple(arrayOf(intArrayOf(1, 1)), 1L, "Single question")
    )

    for ((questions, expected, description) in testCases) {
      val result = mostPoints(questions)
      assertEquals(expected, result, "Failed $description: Expected $expected but got $result")
    }
  }
}
