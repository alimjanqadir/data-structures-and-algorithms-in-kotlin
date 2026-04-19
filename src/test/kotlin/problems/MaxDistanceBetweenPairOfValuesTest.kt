package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MaxDistanceBetweenPairOfValuesTest {

    @Test
    fun testMaxDistance() {
        // Test case 1: Example from problem
        val nums1 = intArrayOf(55, 30, 5, 4, 2)
        val nums2 = intArrayOf(100, 20, 10, 10, 5)
        assertEquals(2, maxDistance(nums1, nums2))

        // Test case 2: Another example
        val nums3 = intArrayOf(2, 2, 2)
        val nums4 = intArrayOf(10, 10, 1)
        assertEquals(1, maxDistance(nums3, nums4))

        // Test case 3: All elements in nums1 greater than nums2
        val nums5 = intArrayOf(30, 29, 19, 5)
        val nums6 = intArrayOf(25, 25, 25, 25, 25)
        assertEquals(2, maxDistance(nums5, nums6))

        // Test case 4: Single element arrays
        val nums7 = intArrayOf(5)
        val nums8 = intArrayOf(5)
        assertEquals(0, maxDistance(nums7, nums8))

        // Test case 5: nums1 larger than nums2
        val nums9 = intArrayOf(10, 9, 8, 7, 6, 5)
        val nums10 = intArrayOf(10, 10, 10)
        assertEquals(2, maxDistance(nums9, nums10))

        // Test case 6: nums2 larger than nums1
        val nums11 = intArrayOf(5, 4)
        val nums12 = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3)
        assertEquals(5, maxDistance(nums11, nums12))

        // Test case 7: No valid pair (all nums1[i] > nums2[j])
        val nums13 = intArrayOf(100, 90, 80)
        val nums14 = intArrayOf(50, 40, 30)
        assertEquals(0, maxDistance(nums13, nums14))
    }
}
