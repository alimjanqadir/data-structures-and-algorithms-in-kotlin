package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class HasAllCodesTest {

  @Test
  fun `test hasAllCodes with example cases`() {
    assertTrue(hasAllCodes("00110110", 2))
    assertTrue(hasAllCodes("0110", 1))
    assertFalse(hasAllCodes("0110", 2))
  }

  @Test
  fun `test hasAllCodes with basic cases`() {
    assertTrue(hasAllCodes("00110", 2))
    assertFalse(hasAllCodes("00110", 3))
    assertTrue(hasAllCodes("0001011100", 3))
  }

  @Test
  fun `test hasAllCodes with edge cases`() {
    assertFalse(hasAllCodes("", 1))
    assertFalse(hasAllCodes("0", 1))
    assertTrue(hasAllCodes("01", 1))
    assertFalse(hasAllCodes("01", 2))
  }

  @Test
  fun `test hasAllCodes with k=1`() {
    assertTrue(hasAllCodes("01", 1))
    assertTrue(hasAllCodes("10", 1))
    assertTrue(hasAllCodes("010101", 1))
    assertFalse(hasAllCodes("0", 1))
    assertFalse(hasAllCodes("1", 1))
  }
}
