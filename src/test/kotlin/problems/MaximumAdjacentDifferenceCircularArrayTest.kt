package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumAdjacentDifferenceCircularArrayTest {
  @Test
  fun testBasicExamples() {
    assertEquals(3, maxAdjacentDistance(intArrayOf(1, 2, 4)))
    assertEquals(5, maxAdjacentDistance(intArrayOf(-5, -10, -5)))
  }
}
