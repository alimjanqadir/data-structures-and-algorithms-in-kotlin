package problems

import kotlin.test.Test
import kotlin.test.assertTrue

class CyclicallyRotatingAGridTest {

  @Test
  fun rotateGridRotatesAllLayersCounterClockwise() {
    val grid = arrayOf(
      intArrayOf(1, 2, 3, 4),
      intArrayOf(5, 6, 7, 8),
      intArrayOf(9, 10, 11, 12),
      intArrayOf(13, 14, 15, 16),
    )

    val expected = arrayOf(
      intArrayOf(3, 4, 8, 12),
      intArrayOf(2, 11, 10, 16),
      intArrayOf(1, 7, 6, 15),
      intArrayOf(5, 9, 13, 14),
    )

    assertGridEquals(expected, rotateGrid(grid, 2))
  }

  @Test
  fun rotateGridHandlesLargeRotationCounts() {
    val grid = arrayOf(
      intArrayOf(40, 10),
      intArrayOf(30, 20),
    )

    val expected = arrayOf(
      intArrayOf(10, 20),
      intArrayOf(40, 30),
    )

    assertGridEquals(expected, rotateGrid(grid, 5))
  }

  @Test
  fun rotateGridHandlesRectangularGrids() {
    val grid = arrayOf(
      intArrayOf(1, 2, 3, 4),
      intArrayOf(5, 6, 7, 8),
      intArrayOf(9, 10, 11, 12),
      intArrayOf(13, 14, 15, 16),
      intArrayOf(17, 18, 19, 20),
      intArrayOf(21, 22, 23, 24),
    )

    val expected = arrayOf(
      intArrayOf(3, 4, 8, 12),
      intArrayOf(2, 11, 15, 16),
      intArrayOf(1, 7, 19, 20),
      intArrayOf(5, 6, 18, 24),
      intArrayOf(9, 10, 14, 23),
      intArrayOf(13, 17, 21, 22),
    )

    assertGridEquals(expected, rotateGrid(grid, 2))
  }

  private fun assertGridEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertTrue(
      expected.contentDeepEquals(actual),
      "Expected ${expected.contentDeepToString()}, but was ${actual.contentDeepToString()}",
    )
  }
}
