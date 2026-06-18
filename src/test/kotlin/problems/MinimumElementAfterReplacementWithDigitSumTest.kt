package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumElementAfterReplacementWithDigitSumTest {

  @Test
  fun testExamples() {
    assertEquals(1, minElement(intArrayOf(10, 12, 13, 14)))
    assertEquals(1, minElement(intArrayOf(1, 2, 3, 4)))
    assertEquals(10, minElement(intArrayOf(999, 19, 199)))
  }

  @Test
  fun testSingleElement() {
    assertEquals(6, minElement(intArrayOf(123)))
  }
}
