package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class TotalWavinessOfNumbersInRangeIITest {
  @Test
  fun returnsZeroWhenNumbersAreTooShort() {
    assertEquals(0L, totalWaviness(0L, 99L))
  }

  @Test
  fun countsSingleThreeDigitPeaksAndValleys() {
    assertEquals(1L, totalWaviness(120L, 120L))
    assertEquals(1L, totalWaviness(101L, 101L))
    assertEquals(0L, totalWaviness(111L, 111L))
  }

  @Test
  fun countsAllCompletionsInARange() {
    assertEquals(10L, totalWaviness(100L, 120L))
    assertEquals(525L, totalWaviness(0L, 999L))
  }
}
