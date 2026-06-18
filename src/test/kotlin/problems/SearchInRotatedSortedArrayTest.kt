package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class SearchInRotatedSortedArrayTest {

  @Test
  fun providedExampleFound() {
    assertEquals(4, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
  }

  @Test
  fun providedExampleNotFound() {
    assertEquals(-1, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
  }

  @Test
  fun singleElement() {
    assertEquals(-1, search(intArrayOf(1), 0))
    assertEquals(0, search(intArrayOf(1), 1))
  }

  @Test
  fun notRotated() {
    assertEquals(3, search(intArrayOf(1, 2, 3, 4, 5), 4))
  }
}
