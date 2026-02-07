package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IntersectionSizeTwoTest {
  @Test
  fun example1() {
    val intervals = arrayOf(
      intArrayOf(1, 3),
      intArrayOf(1, 4),
      intArrayOf(2, 5),
      intArrayOf(3, 5),
    )
    assertEquals(3, intersectionSizeTwo(intervals))
  }

  @Test
  fun example2() {
    val intervals = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(2, 3),
      intArrayOf(2, 4),
      intArrayOf(4, 5),
    )
    assertEquals(5, intersectionSizeTwo(intervals))
  }
}

