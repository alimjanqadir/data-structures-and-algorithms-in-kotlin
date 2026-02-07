package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AreaOfMaxDiagonalTest {

  @Test
  fun `example case`() {
    val dimensions = arrayOf(
      intArrayOf(9, 3),
      intArrayOf(8, 6)
    )
    assertEquals(48, areaOfMaxDiagonal(dimensions))
  }

  @Test
  fun `tie on diagonal chooses larger area`() {
    val dimensions = arrayOf(
      intArrayOf(3, 4),
      intArrayOf(4, 3)
    )
    assertEquals(12, areaOfMaxDiagonal(dimensions))
  }
}
