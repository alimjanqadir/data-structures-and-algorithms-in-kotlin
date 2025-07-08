package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumNumberOfEventsThatCanBeAttendedIITest {
  @Test
  fun example1() {
    val events = arrayOf(
      intArrayOf(1, 2, 4),
      intArrayOf(3, 4, 3),
      intArrayOf(2, 3, 1)
    )
    assertEquals(7, maxValue(events, 2))
  }

  @Test
  fun example2() {
    val events = arrayOf(
      intArrayOf(1, 2, 4),
      intArrayOf(3, 4, 3),
      intArrayOf(2, 3, 10)
    )
    assertEquals(10, maxValue(events, 2))
  }

  @Test
  fun example3() {
    val events = arrayOf(
      intArrayOf(1, 1, 1),
      intArrayOf(2, 2, 2),
      intArrayOf(3, 3, 3),
      intArrayOf(4, 4, 4)
    )
    assertEquals(9, maxValue(events, 3))
  }
}
