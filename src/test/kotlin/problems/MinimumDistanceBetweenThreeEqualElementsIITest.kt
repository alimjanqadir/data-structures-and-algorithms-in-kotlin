package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumDistanceBetweenThreeEqualElementsIITest {

  @Test
  fun testBasicCase() {
    // Example: [1, 2, 1, 2, 1, 3] -> value 1 at indices [0, 2, 4]
    // span = 4 - 0 = 4, distance = 2 * 4 = 8
    assertEquals(8, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 2, 1, 2, 1, 3)))
  }

  @Test
  fun testMultipleOccurrences() {
    // Example: [1, 1, 1, 1] -> multiple triples, minimum span is 2 (indices [0, 1, 2] or [1, 2, 3])
    // distance = 2 * 2 = 4
    assertEquals(4, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 1, 1, 1)))
  }

  @Test
  fun testNoThreeEqualElements() {
    // Example: [1, 2, 3, 4] -> no value appears 3 times
    assertEquals(-1, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 2, 3, 4)))
  }

  @Test
  fun testOnlyTwoOccurrences() {
    // Example: [1, 2, 1] -> value 1 appears only twice
    assertEquals(-1, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 2, 1)))
  }

  @Test
  fun testLargeSpan() {
    // Example: [1, 2, 3, 4, 1, 5, 6, 7, 1]
    // value 1 at indices [0, 4, 8], span = 8 - 0 = 8, distance = 2 * 8 = 16
    assertEquals(16, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 2, 3, 4, 1, 5, 6, 7, 1)))
  }

  @Test
  fun testMultipleValuesWithTriple() {
    // Example: [1, 2, 1, 2, 1, 2]
    // value 1 at indices [0, 2, 4], span = 4, distance = 8
    // value 2 at indices [1, 3, 5], span = 4, distance = 8
    assertEquals(8, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 2, 1, 2, 1, 2)))
  }

  @Test
  fun testMinimumArraySize() {
    // Array with less than 3 elements
    assertEquals(-1, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 1)))
    assertEquals(-1, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1)))
    assertEquals(-1, minimumDistanceBetweenThreeEqualElementsII(intArrayOf()))
  }

  @Test
  fun testConsecutiveIndices() {
    // Example: [5, 5, 5] -> value 5 at indices [0, 1, 2], span = 2, distance = 4
    assertEquals(4, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(5, 5, 5)))
  }

  @Test
  fun testAlternatingPattern() {
    // Example: [1, 1, 2, 1] -> value 1 at indices [0, 1, 3]
    // span = 3 - 0 = 3, distance = 6
    assertEquals(6, minimumDistanceBetweenThreeEqualElementsII(intArrayOf(1, 1, 2, 1)))
  }
}
