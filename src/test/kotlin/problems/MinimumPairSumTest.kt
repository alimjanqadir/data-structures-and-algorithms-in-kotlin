package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumPairSumTest {
  @Test
  fun singleElementKIsOne() {
    assertEquals(0, minimumDifference(intArrayOf(90), 1))
  }

  @Test
  fun exampleFromLeetCode() {
    assertEquals(2, minimumDifference(intArrayOf(9, 4, 1, 7), 2))
  }

  @Test
  fun anotherExample() {
    assertEquals(1, minimumDifference(intArrayOf(2, 5, 3, 1, 6, 3), 3))
  }
}

