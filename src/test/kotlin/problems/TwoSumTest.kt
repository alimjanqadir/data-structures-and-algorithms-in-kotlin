package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertFailsWith

class TwoSumTest {
    
  @Test
  fun testTwoSumBruteForce() {
    // Test case 1: Basic case
    assertContentEquals(intArrayOf(1, 2), twoSumBruteForce(intArrayOf(2, 7, 11, 15), 9))
        
    // Test case 2: Different positions
    assertContentEquals(intArrayOf(1, 4), twoSumBruteForce(intArrayOf(1, 3, 4, 6), 7))
        
    // Test case 3: No solution
    assertContentEquals(intArrayOf(), twoSumBruteForce(intArrayOf(1, 2, 3), 10))
        
    // Test case 4: Single element array (no solution)
    assertContentEquals(intArrayOf(), twoSumBruteForce(intArrayOf(5), 5))
        
    // Test case 5: Negative numbers
    assertContentEquals(intArrayOf(1, 4), twoSumBruteForce(intArrayOf(-3, 1, 2, 4), 1))
  }
    
  @Test
  fun testTwoSumTwoPointers() {
    // Test case 1: Basic case (sorted array)
    assertContentEquals(intArrayOf(1, 2), twoSumTwoPointers(intArrayOf(2, 7, 11, 15), 9))
        
    // Test case 2: Different positions
    assertContentEquals(intArrayOf(1, 4), twoSumTwoPointers(intArrayOf(1, 3, 4, 6), 7))
        
    // Test case 3: No solution
    assertContentEquals(intArrayOf(), twoSumTwoPointers(intArrayOf(1, 2, 3), 10))
        
    // Test case 4: Single element array
    assertContentEquals(intArrayOf(), twoSumTwoPointers(intArrayOf(5), 5))
        
    // Test case 5: Negative numbers
    assertContentEquals(intArrayOf(1, 4), twoSumTwoPointers(intArrayOf(-3, 1, 2, 4), 1))
  }
    
  @Test
  fun testTwoSumFunctional() {
    // Test case 1: Basic case
    assertContentEquals(intArrayOf(1, 2), twoSumFunctional(intArrayOf(2, 7, 11, 15), 9))
        
    // Test case 2: Different positions
    assertContentEquals(intArrayOf(1, 4), twoSumFunctional(intArrayOf(1, 3, 4, 6), 7))
        
    // Test case 3: No solution
    assertContentEquals(intArrayOf(), twoSumFunctional(intArrayOf(1, 2, 3), 10))
        
    // Test case 4: Single element array
    assertContentEquals(intArrayOf(), twoSumFunctional(intArrayOf(5), 5))
        
    // Test case 5: Negative numbers
    assertContentEquals(intArrayOf(1, 4), twoSumFunctional(intArrayOf(-3, 1, 2, 4), 1))
  }
    
  @Test
  fun testTwoSumHashMap() {
    // Test case 1: Basic case
    assertContentEquals(intArrayOf(0, 1), twoSumHashMap(intArrayOf(2, 7, 11, 15), 9))
        
    // Test case 2: Different positions
    assertContentEquals(intArrayOf(1, 2), twoSumHashMap(intArrayOf(1, 3, 4, 6), 7))
        
    // Test case 3: No solution - should throw exception
    assertFailsWith<IllegalArgumentException> {
      twoSumHashMap(intArrayOf(1, 2, 3), 10)
    }
        
    // Test case 4: Negative numbers
    assertContentEquals(intArrayOf(0, 3), twoSumHashMap(intArrayOf(-3, 1, 2, 4), 1))
        
    // Test case 5: Same number used twice
    assertContentEquals(intArrayOf(0, 1), twoSumHashMap(intArrayOf(3, 3, 4, 5), 6))
  }
}
