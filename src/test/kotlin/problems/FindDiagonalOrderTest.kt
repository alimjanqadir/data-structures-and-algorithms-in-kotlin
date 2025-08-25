package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class FindDiagonalOrderTest {
  @Test
  fun example1() {
    val input = arrayOf(
      intArrayOf(1, 2, 3),
      intArrayOf(4, 5, 6),
      intArrayOf(7, 8, 9)
    )
    val expected = intArrayOf(1, 2, 4, 7, 5, 3, 6, 8, 9)

    assertContentEquals(expected, findDiagonalOrder(input))
  }

  @Test
  fun example2() {
    val input = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(3, 4)
    )
    val expected = intArrayOf(1, 2, 3, 4)

    assertContentEquals(expected, findDiagonalOrder(input))
  }
}
