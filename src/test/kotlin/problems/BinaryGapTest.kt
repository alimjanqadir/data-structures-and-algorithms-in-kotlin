package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class BinaryGapTest {

  @Test
  fun `test binary gap with example cases`() {
    assertEquals(2, binaryGap(22)) // 10110 - gap of 2 between first and third 1
    assertEquals(0, binaryGap(8)) // 1000 - only one 1, no gap
    assertEquals(2, binaryGap(5)) // 101 - gap of 2 between two 1s
  }

  @Test
  fun `test binary gap with no gap`() {
    assertEquals(1, binaryGap(15)) // 1111 - gaps of 1 between consecutive 1s
    assertEquals(1, binaryGap(7)) // 111 - gaps of 1 between consecutive 1s
    assertEquals(0, binaryGap(1)) // 1 - only one 1, no gap
  }

  @Test
  fun `test binary gap with single zero gap`() {
    assertEquals(2, binaryGap(5)) // 101 - gap of 2 between positions 0-2
    assertEquals(2, binaryGap(10)) // 1010 - gap of 2 between positions 0-2
  }

  @Test
  fun `test binary gap with multiple gaps`() {
    assertEquals(2, binaryGap(22)) // 10110 - gaps: 2 and 1, max is 2
    assertEquals(2, binaryGap(45)) // 101101 - gaps: 2 and 1, max is 2
  }

  @Test
  fun `test binary gap with large numbers`() {
    assertEquals(0, binaryGap(32)) // 100000 - only one 1, no gap
    assertEquals(2, binaryGap(27)) // 11011 - gaps: 1 and 2, max is 2
  }

  @Test
  fun `test binary gap with zero`() {
    assertEquals(0, binaryGap(0))
  }

  @Test
  fun `test binary gap with power of two`() {
    assertEquals(0, binaryGap(1)) // 1
    assertEquals(0, binaryGap(2)) // 10 - only one 1, no gap
    assertEquals(0, binaryGap(4)) // 100 - only one 1, no gap
    assertEquals(0, binaryGap(8)) // 1000 - only one 1, no gap
  }
}
