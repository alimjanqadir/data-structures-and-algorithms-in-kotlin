package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountDaysWithoutMeetingsTest {
  @Test
  fun example1() {
    val meetings = arrayOf(intArrayOf(5, 7), intArrayOf(1, 3), intArrayOf(9, 10))
    assertEquals(2, countDays(10, meetings))
  }

  @Test
  fun example2() {
    val meetings = arrayOf(intArrayOf(2, 4), intArrayOf(1, 3))
    assertEquals(1, countDays(5, meetings))
  }

  @Test
  fun example3() {
    val meetings = arrayOf(intArrayOf(1, 6))
    assertEquals(0, countDays(6, meetings))
  }

  @Test
  fun noMeetings() {
    val meetings = emptyArray<IntArray>()
    assertEquals(7, countDays(7, meetings))
  }
}
