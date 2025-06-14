package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumDifferenceByRemappingDigitTest {
  @Test
  fun providedExamples() {
    assertEquals(99009, minMaxDifference(11891))
    assertEquals(99, minMaxDifference(90))
  }

  @Test
  fun additionalCases() {
    assertEquals(9, minMaxDifference(0))
    assertEquals(90000, minMaxDifference(10000))
  }
}
