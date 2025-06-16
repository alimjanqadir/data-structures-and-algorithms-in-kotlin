package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumDifferenceBetweenIncreasingElementsTest {
  @Test
  fun testExamples() {
    assertEquals(4, maximumDifference(intArrayOf(7, 1, 5, 4)))
    assertEquals(-1, maximumDifference(intArrayOf(9, 4, 3, 2)))
    assertEquals(9, maximumDifference(intArrayOf(1, 5, 2, 10)))
  }
}
