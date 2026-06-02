package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class EarliestFinishTimeForLandAndWaterRidesITest {
  @Test
  fun landFirstCanBeOptimal() {
    val landStartTime = intArrayOf(2, 8)
    val landDuration = intArrayOf(4, 1)
    val waterStartTime = intArrayOf(6)
    val waterDuration = intArrayOf(3)

    assertEquals(9, earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration))
  }

  @Test
  fun waterFirstCanBeOptimal() {
    val landStartTime = intArrayOf(10)
    val landDuration = intArrayOf(3)
    val waterStartTime = intArrayOf(1, 5)
    val waterDuration = intArrayOf(4, 2)

    assertEquals(13, earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration))
  }

  @Test
  fun waitsForSecondRideOpeningTime() {
    val landStartTime = intArrayOf(1)
    val landDuration = intArrayOf(2)
    val waterStartTime = intArrayOf(10)
    val waterDuration = intArrayOf(1)

    assertEquals(11, earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration))
  }
}
