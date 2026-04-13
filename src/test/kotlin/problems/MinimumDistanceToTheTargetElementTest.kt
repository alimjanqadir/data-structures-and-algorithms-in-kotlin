package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumDistanceToTheTargetElementTest {

    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(1, getMinDistance(nums, 5, 3))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(1)
        assertEquals(0, getMinDistance(nums, 1, 0))
    }

    @Test
    fun testExample3() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        assertEquals(0, getMinDistance(nums, 1, 0))
    }

    @Test
    fun testMultipleOccurrences() {
        val nums = intArrayOf(5, 2, 5, 2, 5)
        assertEquals(1, getMinDistance(nums, 5, 1))
    }

    @Test
    fun testTargetAtStart() {
        val nums = intArrayOf(3, 1, 2, 3, 4)
        assertEquals(0, getMinDistance(nums, 3, 0))
    }

    @Test
    fun testTargetAtEnd() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(4, getMinDistance(nums, 5, 0))
    }

    @Test
    fun testSymmetricDistance() {
        val nums = intArrayOf(1, 2, 1, 2, 1)
        assertEquals(0, getMinDistance(nums, 1, 2))
    }

    @Test
    fun testTargetNotAtStartPosition() {
        val nums = intArrayOf(1, 2, 1, 2, 1)
        assertEquals(1, getMinDistance(nums, 2, 2))
    }
}
