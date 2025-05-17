import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortColorsTest {
    @Test
    fun testSortColors() {
        // Test case 1: Basic test case
        val nums1 = intArrayOf(2, 0, 2, 1, 1, 0)
        sortColors(nums1)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 2), nums1)

        // Test case 2: Already sorted
        val nums2 = intArrayOf(0, 0, 1, 1, 2, 2)
        sortColors(nums2)
        assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 2), nums2)

        // Test case 3: Single element
        val nums3 = intArrayOf(1)
        sortColors(nums3)
        assertArrayEquals(intArrayOf(1), nums3)


        // Test case 4: All zeros
        val nums4 = intArrayOf(0, 0, 0)
        sortColors(nums4)
        assertArrayEquals(intArrayOf(0, 0, 0), nums4)

        // Test case 5: All ones
        val nums5 = intArrayOf(1, 1, 1)
        sortColors(nums5)
        assertArrayEquals(intArrayOf(1, 1, 1), nums5)

        // Test case 6: All twos
        val nums6 = intArrayOf(2, 2, 2)
        sortColors(nums6)
        assertArrayEquals(intArrayOf(2, 2, 2), nums6)
    }
}
