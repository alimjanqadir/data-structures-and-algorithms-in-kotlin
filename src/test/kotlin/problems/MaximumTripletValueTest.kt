package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTripletValueTest {
  @Test
  fun testMaximumTripletValue() {
    assertEquals(77, maximumTripletValue(intArrayOf(12, 6, 1, 2, 7)))
    assertEquals(133, maximumTripletValue(intArrayOf(1, 10, 3, 4, 19)))
    assertEquals(0, maximumTripletValue(intArrayOf(1, 2, 3)))
  }
}
