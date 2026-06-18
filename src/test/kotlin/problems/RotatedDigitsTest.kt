package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RotatedDigitsTest {
  @Test
  fun testRotatedDigitsExamples() {
    assertEquals(4, rotatedDigits(10))
    assertEquals(0, rotatedDigits(1))
    assertEquals(1, rotatedDigits(2))
  }

  @Test
  fun testRotatedDigitsAdditionalCases() {
    assertEquals(9, rotatedDigits(20))
    assertEquals(15, rotatedDigits(30))
  }
}
