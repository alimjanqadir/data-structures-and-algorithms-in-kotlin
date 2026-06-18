package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class FindMinimumInRotatedSortedArrayIITest {
  @Test
  fun findsMinimumInRotatedArrayWithDuplicates() {
    assertEquals(0, findMin(intArrayOf(2, 2, 2, 0, 1)))
  }

  @Test
  fun findsMinimumWhenRotationPointIsHiddenByDuplicates() {
    assertEquals(1, findMin(intArrayOf(3, 3, 1, 3)))
  }

  @Test
  fun findsMinimumInAlreadySortedArray() {
    assertEquals(1, findMin(intArrayOf(1, 1, 2, 3, 4)))
  }

  @Test
  fun findsMinimumWhenAllValuesAreEqual() {
    assertEquals(7, findMin(intArrayOf(7, 7, 7, 7)))
  }

  @Test
  fun findsMinimumInSingleElementArray() {
    assertEquals(5, findMin(intArrayOf(5)))
  }
}
