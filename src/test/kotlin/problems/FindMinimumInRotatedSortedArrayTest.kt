package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class FindMinimumInRotatedSortedArrayTest {
  @Test
  fun rotatedArrayReturnsFirstElementOfSecondSortedPart() {
    assertEquals(0, findMin(intArrayOf(4, 5, 6, 7, 0, 1, 2)))
  }

  @Test
  fun twoElementRotatedArrayReturnsMinimum() {
    assertEquals(1, findMin(intArrayOf(2, 1)))
  }

  @Test
  fun alreadySortedArrayReturnsFirstElement() {
    assertEquals(1, findMin(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun singleElementArrayReturnsThatElement() {
    assertEquals(11, findMin(intArrayOf(11)))
  }
}
