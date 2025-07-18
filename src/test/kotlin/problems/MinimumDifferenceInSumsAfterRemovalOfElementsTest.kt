package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumDifferenceInSumsAfterRemovalOfElementsTest {
  @Test
  fun testExamples() {
    assertEquals(-1L, minimumDifference(intArrayOf(3, 1, 2)))
    assertEquals(1L, minimumDifference(intArrayOf(7, 9, 5, 8, 1, 3)))
  }
}
