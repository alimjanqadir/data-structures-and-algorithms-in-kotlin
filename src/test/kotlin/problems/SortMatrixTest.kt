package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals

class SortMatrixTest {
  @Test
  fun `test sort matrix`() {
    val grid = arrayOf(
      intArrayOf(3, 1, 4),
      intArrayOf(1, 5, 9),
      intArrayOf(2, 6, 5)
    )
    val expected = arrayOf(
      intArrayOf(5, 1, 4),
      intArrayOf(6, 5, 9),
      intArrayOf(2, 1, 3)
    )

    val result = sortMatrix(grid)

    assertContentEquals(
      expected.map(IntArray::toList),
      result.map(IntArray::toList)
    )
  }
}

