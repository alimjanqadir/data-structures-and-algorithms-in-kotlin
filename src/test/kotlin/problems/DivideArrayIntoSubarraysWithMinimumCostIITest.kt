package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DivideArrayIntoSubarraysWithMinimumCostIITest {
  @Test
  fun leetCodeExamples() {
    assertEquals(5, minimumCost(intArrayOf(1, 3, 2, 6, 4, 2), 3, 3))
    assertEquals(15, minimumCost(intArrayOf(10, 1, 2, 2, 2, 1), 4, 3))
    assertEquals(36, minimumCost(intArrayOf(10, 8, 18, 9), 3, 1))
  }
}

