package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class EarliestFinishTimeForLandAndWaterRidesIITest {
  @Test
  fun landThenWaterCanBeOptimal() {
    assertEquals(
      7,
      earliestFinishTime(
        landStartTime = intArrayOf(1, 5),
        landDuration = intArrayOf(3, 2),
        waterStartTime = intArrayOf(6, 7),
        waterDuration = intArrayOf(1, 1)
      )
    )
  }

  @Test
  fun waterThenLandCanBeOptimal() {
    assertEquals(
      9,
      earliestFinishTime(
        landStartTime = intArrayOf(8, 10),
        landDuration = intArrayOf(1, 3),
        waterStartTime = intArrayOf(1, 4),
        waterDuration = intArrayOf(3, 4)
      )
    )
  }

  @Test
  fun waitsForSecondRideStartWhenFirstRideFinishesEarly() {
    assertEquals(
      12,
      earliestFinishTime(
        landStartTime = intArrayOf(1),
        landDuration = intArrayOf(1),
        waterStartTime = intArrayOf(10),
        waterDuration = intArrayOf(2)
      )
    )
  }
}
