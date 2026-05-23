package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckIfArrayIsSortedAndRotatedTest {

  @Test
  fun `returns true for sorted array`() {
    assertTrue(checkIfArrayIsSortedAndRotated(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun `returns true for sorted and rotated array`() {
    assertTrue(checkIfArrayIsSortedAndRotated(intArrayOf(3, 4, 5, 1, 2)))
    assertTrue(checkIfArrayIsSortedAndRotated(intArrayOf(2, 3, 4, 5, 1)))
  }

  @Test
  fun `returns false when more than one decreasing point exists`() {
    assertFalse(checkIfArrayIsSortedAndRotated(intArrayOf(2, 1, 3, 4)))
    assertFalse(checkIfArrayIsSortedAndRotated(intArrayOf(1, 3, 2, 4)))
  }

  @Test
  fun `handles duplicates correctly`() {
    assertTrue(checkIfArrayIsSortedAndRotated(intArrayOf(1, 1, 1)))
    assertTrue(checkIfArrayIsSortedAndRotated(intArrayOf(2, 1, 1)))
    assertFalse(checkIfArrayIsSortedAndRotated(intArrayOf(1, 1, 2, 1)))
  }
}
