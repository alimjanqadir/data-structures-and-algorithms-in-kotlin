package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class TotalWavinessTest {
  @Test
  fun countsNoWavinessForNumbersWithFewerThanThreeDigits() {
    assertEquals(0, totalWaviness(1, 99))
  }

  @Test
  fun countsSinglePeakAndValleyNumbers() {
    assertEquals(2, totalWaviness(120, 121))
  }

  @Test
  fun sumsWavinessAcrossTheWholeRange() {
    assertEquals(11, totalWaviness(101, 121))
  }

  @Test
  fun countsMultipleMiddleDigitsInOneNumber() {
    assertEquals(4, totalWaviness(121212, 121212))
  }
}
