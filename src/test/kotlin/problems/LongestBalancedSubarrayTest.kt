package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LongestBalancedSubarrayTest {
    
    @Test
    fun testLongestBalanced() {
        // Test case 1: Simple case with balanced subarray at the end
        // The entire array has 2 distinct evens (2,4) and 2 distinct odds (1,3)
        assertEquals(
            9,
            longestBalanced(intArrayOf(1, 1, 2, 2, 2, 3, 3, 2, 4))
        )

        // Test case 2: All even numbers
        assertEquals(
            0,
            longestBalanced(intArrayOf(2, 4, 6, 8))
        )

        // Test case 3: All odd numbers (should be 0 since we can't have balanced subarrays with no evens)
        assertEquals(
            0,
            longestBalanced(intArrayOf(1, 3, 5, 7))
        )

        // Test case 4: Alternating even and odd numbers
        assertEquals(
            6,
            longestBalanced(intArrayOf(1, 2, 1, 2, 1, 2))
        )

        // Test case 5: Empty array
        assertEquals(
            0,
            longestBalanced(intArrayOf())
        )

        // Test case 6: Single element array (can't be balanced as it can't have both even and odd)
        assertEquals(
            0,
            longestBalanced(intArrayOf(1))
        )

        // Test case 7: Multiple balanced subarrays
        // The entire array has 3 distinct evens (2,4,6) and 3 distinct odds (1,3,5)
        assertEquals(
            8,
            longestBalanced(intArrayOf(1, 2, 2, 3, 4, 4, 5, 6))
        )
    }
}
