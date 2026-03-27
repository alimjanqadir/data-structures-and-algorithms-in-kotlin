package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MatrixSimilarityAfterCyclicShiftsTest {

  @Test
  fun testAreSimilar() {
    // Test case 1: Example where matrix returns to original after shifts
    // mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
    // After 2 shifts, even rows shifted left by 2, odd rows shifted right by 2
    // Row 0: [1,2,1,2] -> left shift by 2 -> [1,2,1,2] (same, period is 2)
    // Row 1: [5,5,5,5] -> right shift by 2 -> [5,5,5,5] (all same)
    // Row 2: [6,3,6,3] -> left shift by 2 -> [6,3,6,3] (same, period is 2)
    val mat1 = arrayOf(
      intArrayOf(1, 2, 1, 2),
      intArrayOf(5, 5, 5, 5),
      intArrayOf(6, 3, 6, 3)
    )
    assertTrue(areSimilar(mat1, 2))

    // Test case 2: Example where matrix does NOT return to original
    // mat = [[2,2],[2,2]], k = 3
    // All elements are same, so any shift returns same matrix
    val mat2 = arrayOf(
      intArrayOf(2, 2),
      intArrayOf(2, 2)
    )
    assertTrue(areSimilar(mat2, 3))

    // Test case 3: Different values, k = 1
    // mat = [[1,2],[3,4]], k = 1
    // Row 0: [1,2] left shift by 1 -> [2,1] != [1,2]
    val mat3 = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(3, 4)
    )
    assertFalse(areSimilar(mat3, 1))

    // Test case 4: Single column, any k should return true
    val mat4 = arrayOf(
      intArrayOf(1),
      intArrayOf(2),
      intArrayOf(3)
    )
    assertTrue(areSimilar(mat4, 5))

    // Test case 5: k is multiple of n
    val mat5 = arrayOf(
      intArrayOf(1, 2, 3),
      intArrayOf(4, 5, 6)
    )
    assertTrue(areSimilar(mat5, 6)) // k % 3 == 0

    // Test case 6: Periodicity check - shift by 2 on [1,2,3,1,2,3] doesn't match
    val mat6 = arrayOf(
      intArrayOf(1, 2, 3, 1, 2, 3),
      intArrayOf(4, 4, 4, 4, 4, 4)
    )
    assertFalse(areSimilar(mat6, 2)) // Row 0: [1,2,3,1,2,3] vs [3,1,2,3,1,2] - not equal
  }

  @Test
  fun testAreSimilarWithPeriodicRow() {
    // Row with period 2: [1,2,1,2], n=4, shift=2 -> same
    val mat1 = arrayOf(
      intArrayOf(1, 2, 1, 2)
    )
    assertTrue(areSimilar(mat1, 2))

    // Row with period 3: [1,2,3,1,2,3], n=6, shift=3 -> same
    val mat2 = arrayOf(
      intArrayOf(1, 2, 3, 1, 2, 3)
    )
    assertTrue(areSimilar(mat2, 3))

    // Row with period 3: [1,2,3,1,2,3], n=6, shift=2 -> different
    val mat3 = arrayOf(
      intArrayOf(1, 2, 3, 1, 2, 3)
    )
    assertFalse(areSimilar(mat3, 2))
  }
}
