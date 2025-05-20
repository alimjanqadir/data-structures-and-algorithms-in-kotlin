package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsZeroArrayTest {
    @Test
    fun testIsZeroArray() {
        // Test case 1: Can zero out the array
        val nums1 = intArrayOf(1, 1, 2, 2, 1)
        val queries1 = arrayOf(
            intArrayOf(0, 4),
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        )
        assertTrue(isZeroArray(nums1, queries1))

        // Test case 2: Cannot zero out the array
        val nums2 = intArrayOf(2, 2, 2, 2, 2)
        val queries2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 3)
        )
        assertFalse(isZeroArray(nums2, queries2))

        // Test case 3: Empty array should return true
        assertTrue(isZeroArray(intArrayOf(), arrayOf()))
        
        // Test case 4: Single element array with matching query
        assertTrue(isZeroArray(intArrayOf(1), arrayOf(intArrayOf(0, 0))))
        
        // Test case 5: Single element array with no queries
        assertFalse(isZeroArray(intArrayOf(1), arrayOf()))
    }
}
