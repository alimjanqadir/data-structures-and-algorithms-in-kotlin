package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class NumberOfStepsToReduceANumberInBinaryRepresentationToOneTest {

  @Test
  fun `test numSteps with example cases`() {
    assertEquals(6, numSteps("1101")) // 13 -> 14 -> 7 -> 8 -> 4 -> 2 -> 1
    assertEquals(1, numSteps("10"))   // 2 -> 1
    assertEquals(0, numSteps("1"))     // 1 (already 1)
  }

  @Test
  fun `test numSteps with single bit`() {
    assertEquals(0, numSteps("1"))     // Already 1
  }

  @Test
  fun `test numSteps with even numbers`() {
    assertEquals(1, numSteps("10"))    // 2 -> 1
    assertEquals(2, numSteps("100"))   // 4 -> 2 -> 1
    assertEquals(3, numSteps("1000"))  // 8 -> 4 -> 2 -> 1
  }

  @Test
  fun `test numSteps with odd numbers`() {
    assertEquals(6, numSteps("1101"))  // 13 -> 14 -> 7 -> 8 -> 4 -> 2 -> 1
    assertEquals(4, numSteps("111"))   // 7 -> 8 -> 4 -> 2 -> 1
    assertEquals(6, numSteps("1011"))  // 11 -> 12 -> 6 -> 3 -> 4 -> 2 -> 1
  }

  @Test
  fun `test numSteps with larger numbers`() {
    assertEquals(7, numSteps("11101"))  // 29 -> 30 -> 15 -> 16 -> 8 -> 4 -> 2 -> 1
  }

  @Test
  fun `test numSteps with all ones`() {
    assertEquals(5, numSteps("1111"))   // 15 -> 16 -> 8 -> 4 -> 2 -> 1
    assertEquals(6, numSteps("11111"))  // 31 -> 32 -> 16 -> 8 -> 4 -> 2 -> 1
  }
}
