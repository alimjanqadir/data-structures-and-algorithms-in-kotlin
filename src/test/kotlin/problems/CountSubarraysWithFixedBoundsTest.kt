import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSubarraysWithFixedBoundsTest {
    @Test
    fun testExample1() {
        val nums = intArrayOf(1,3,5,2,7,5)
        val minK = 1
        val maxK = 5
        assertEquals(2, countSubarraysWithFixedBounds(nums, minK, maxK))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(1,1,1,1)
        val minK = 1
        val maxK = 1
        assertEquals(10, countSubarraysWithFixedBounds(nums, minK, maxK))
    }

    @Test
    fun testNoValidSubarray() {
        val nums = intArrayOf(2,4,6)
        val minK = 1
        val maxK = 3
        assertEquals(0, countSubarraysWithFixedBounds(nums, minK, maxK))
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(5)
        val minK = 5
        val maxK = 5
        assertEquals(1, countSubarraysWithFixedBounds(nums, minK, maxK))
    }
}
