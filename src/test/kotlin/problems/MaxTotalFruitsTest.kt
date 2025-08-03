package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaxTotalFruitsTest {
  @Test
  fun testMaxTotalFruits() {
    val fruits1 = arrayOf(
      intArrayOf(2, 8),
      intArrayOf(6, 3),
      intArrayOf(8, 6)
    )
    assertEquals(9, maxTotalFruits(fruits1, 5, 4))

    val fruits2 = arrayOf(
      intArrayOf(0, 9),
      intArrayOf(4, 1),
      intArrayOf(5, 7),
      intArrayOf(6, 2),
      intArrayOf(7, 4),
      intArrayOf(10, 9)
    )
    assertEquals(14, maxTotalFruits(fruits2, 5, 4))
  }
}

