package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class SemiOrderedPermutationTest {

  @Test
  fun testSemiOrderedPermutationExample1() {
    // Example 1: [2,1,4,3], n=4
    // 1 is at index 1, 4 is at index 2
    // Move 1 to front: 1 swap
    // Move 4 to end: 4-1-2=1 swap (1 was before 4, so no adjustment needed)
    // Actually: (n-1) - indexOfN = 3 - 2 = 1
    // Total: 1 + 1 = 2
    assertEquals(2, semiOrderedPermutation(intArrayOf(2, 1, 4, 3)))
  }

  @Test
  fun testSemiOrderedPermutationExample2() {
    // Example 2: [2,4,1,3], n=4
    // 1 is at index 2, 4 is at index 1
    // Move 1 to front: 2 swaps
    // Move 4 to end: 4 is already at index 1, needs to go to index 3
    // But 1 moves before 4, so when calculating 4's moves, we subtract 1
    // (n-1) - indexOfN - 1 = 3 - 1 - 1 = 1
    // Total: 2 + 1 = 3
    assertEquals(3, semiOrderedPermutation(intArrayOf(2, 4, 1, 3)))
  }

  @Test
  fun testSemiOrderedPermutationExample3() {
    // Example 3: [1,3,4,2,5], n=5
    // 1 is at index 0, 5 is at index 4
    // Already semi-ordered, 0 swaps
    assertEquals(0, semiOrderedPermutation(intArrayOf(1, 3, 4, 2, 5)))
  }

  @Test
  fun testSemiOrderedPermutationAlreadyOrdered() {
    // [1,2,3,4,5], already perfect
    assertEquals(0, semiOrderedPermutation(intArrayOf(1, 2, 3, 4, 5)))
  }

  @Test
  fun testSemiOrderedPermutationReversed() {
    // [5,4,3,2,1], n=5
    // 1 is at index 4, 5 is at index 0
    // Move 1 to front: 4 swaps
    // Move 5 to end: (n-1) - indexOfN - 1 = 4 - 0 - 1 = 3 swaps
    // Total: 4 + 3 = 7
    assertEquals(7, semiOrderedPermutation(intArrayOf(5, 4, 3, 2, 1)))
  }

  @Test
  fun testSemiOrderedPermutationSize2() {
    // [2,1], n=2
    // 1 at index 1, 2 at index 0
    // Move 1 to front: 1 swap
    // Move 2 to end: (n-1) - indexOfN - 1 = 1 - 0 - 1 = 0
    // Total: 1 + 0 = 1 (or just swap once)
    assertEquals(1, semiOrderedPermutation(intArrayOf(2, 1)))
  }

  @Test
  fun testSemiOrderedPermutationOneAtEnd() {
    // [2,3,4,5,1], n=5
    // 1 at index 4, 5 at index 3
    // Move 1 to front: 4 swaps
    // Move 5 to end: (n-1) - indexOfN - 1 = 4 - 3 - 1 = 0
    // Total: 4
    assertEquals(4, semiOrderedPermutation(intArrayOf(2, 3, 4, 5, 1)))
  }

  @Test
  fun testSemiOrderedPermutationNAtStart() {
    // [5,1,2,3,4], n=5
    // 1 at index 1, 5 at index 0
    // Move 1 to front: 1 swap
    // Move 5 to end: (n-1) - indexOfN - 1 = 4 - 0 - 1 = 3
    // Total: 1 + 3 = 4
    assertEquals(4, semiOrderedPermutation(intArrayOf(5, 1, 2, 3, 4)))
  }
}
