package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LenOfVDiagonalTest {
  @Test
  fun testSingleCell() {
    val grid = arrayOf(intArrayOf(1))
    assertEquals(1, lenOfVDiagonal(grid))
  }

  @Test
  fun testSample() {
    val grid = arrayOf(
      intArrayOf(0, 1, 0, 0),
      intArrayOf(0, 0, 2, 0),
      intArrayOf(0, 0, 0, 0),
      intArrayOf(0, 0, 2, 0),
      intArrayOf(0, 0, 0, 0)
    )
    assertEquals(5, lenOfVDiagonal(grid))
  }
}

