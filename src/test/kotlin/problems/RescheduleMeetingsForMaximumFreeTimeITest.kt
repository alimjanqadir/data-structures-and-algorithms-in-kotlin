package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RescheduleMeetingsForMaximumFreeTimeITest {

  @Test
  fun example1() {
    val startTime = intArrayOf(1, 3)
    val endTime = intArrayOf(2, 5)
    val result = maxFreeTime(5, 1, startTime, endTime)
    assertEquals(2, result)
  }

  @Test
  fun example2() {
    val startTime = intArrayOf(0, 2, 9)
    val endTime = intArrayOf(1, 4, 10)
    val result = maxFreeTime(10, 1, startTime, endTime)
    assertEquals(6, result)
  }

  @Test
  fun example3() {
    val startTime = intArrayOf(0, 1, 2, 3, 4)
    val endTime = intArrayOf(1, 2, 3, 4, 5)
    val result = maxFreeTime(5, 2, startTime, endTime)
    assertEquals(0, result)
  }
}
