package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestBalancedSubarrayTest {
    
  @Test
  fun testLongestBalanced() {
    // Test case 1: Empty array
    assertEquals(
      0,
      longestBalanced(intArrayOf())
    )

    // Test case 2: Single element
    assertEquals(
      0,
      longestBalanced(intArrayOf(1))
    )

    // Test case 3: Simple balanced array
    assertEquals(
      2,
      longestBalanced(intArrayOf(1, 2))
    )

    // Test case 4: All even numbers
    assertEquals(
      0,
      longestBalanced(intArrayOf(2, 4, 6, 8))
    )

    // Test case 5: All odd numbers
    assertEquals(
      0,
      longestBalanced(intArrayOf(1, 3, 5, 7))
    )

    // Test case 6: Perfect balance
    assertEquals(
      6,
      longestBalanced(intArrayOf(1, 2, 3, 4, 5, 6))
    )

    // Test case 7: Larger balanced array
    assertEquals(
      8,
      longestBalanced(intArrayOf(1, 3, 2, 4, 1, 3, 2, 4))
    )

    // Test case 8: Array with zeros
    assertEquals(
      4,
      longestBalanced(intArrayOf(0, 1, 0, 1))
    )

    // Test case 9: Negative numbers
    assertEquals(
      0,
      longestBalanced(intArrayOf(-1, -2, -3, -4))
    )
  }
}
