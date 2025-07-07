package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumNumberOfEventsThatCanBeAttendedTest {
  @Test
  fun example1() {
    val events = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4))
    assertEquals(3, maxEvents(events))
  }

  @Test
  fun example2() {
    val events = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(2, 3),
      intArrayOf(3, 4),
      intArrayOf(1, 2)
    )
    assertEquals(4, maxEvents(events))
  }
}

