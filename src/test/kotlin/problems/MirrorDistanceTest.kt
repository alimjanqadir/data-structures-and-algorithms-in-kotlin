package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class MirrorDistanceTest {

  @Test
  fun `test mirror distance with two digit number`() {
    assertEquals(9, mirrorDistance(10)) // reverse: 1, |10 - 1| = 9
    assertEquals(9, mirrorDistance(12)) // reverse: 21, |12 - 21| = 9
    assertEquals(0, mirrorDistance(11)) // reverse: 11, |11 - 11| = 0
  }

  @Test
  fun `test mirror distance with single digit`() {
    assertEquals(0, mirrorDistance(7)) // reverse: 7, |7 - 7| = 0
    assertEquals(0, mirrorDistance(0)) // reverse: 0, |0 - 0| = 0
    assertEquals(0, mirrorDistance(9)) // reverse: 9, |9 - 9| = 0
  }

  @Test
  fun `test mirror distance with larger numbers`() {
    assertEquals(693, mirrorDistance(219)) // reverse: 912, |219 - 912| = 693
    assertEquals(0, mirrorDistance(1221)) // reverse: 1221, |1221 - 1221| = 0 (palindrome)
    assertEquals(198, mirrorDistance(123)) // reverse: 321, |123 - 321| = 198
  }

  @Test
  fun `test mirror distance with palindromes`() {
    assertEquals(0, mirrorDistance(121))
    assertEquals(0, mirrorDistance(12321))
    assertEquals(0, mirrorDistance(1))
  }

  @Test
  fun `test mirror distance with trailing zeros`() {
    assertEquals(9, mirrorDistance(10))
    assertEquals(99, mirrorDistance(100)) // reverse: 1, |100 - 1| = 99
    assertEquals(999, mirrorDistance(1000)) // reverse: 1, |1000 - 1| = 999
  }
}
