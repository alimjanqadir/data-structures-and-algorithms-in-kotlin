package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class CheckIfBinaryStringHasAtMostOneSegmentOfOnesTest {

  @Test
  fun `test single segment of ones`() {
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("11"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("111"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("10"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("110"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1110"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("100"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1100"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("11100"))
  }

  @Test
  fun `test multiple segments of ones`() {
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("101"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("11011"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("10101"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1001"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1101011"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("10001"))
  }

  @Test
  fun `test edge cases`() {
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("111111"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("100000"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1100000"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("111000000"))
  }

  @Test
  fun `test alternating patterns`() {
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("101"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1010"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("10101"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("11011"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("11011011"))
  }

  @Test
  fun `test complex patterns`() {
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("111000000"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("110000000"))
    assertTrue(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("100000000"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("111000111"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1100011"))
    assertFalse(CheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1001001"))
  }
}
