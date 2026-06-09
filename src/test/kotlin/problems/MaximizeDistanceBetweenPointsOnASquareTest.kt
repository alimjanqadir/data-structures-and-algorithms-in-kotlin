package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximizeDistanceBetweenPointsOnASquareTest {

    private val solution = Solution()

    @Test
    fun `example 1`() {
        val side = 2
        val points = arrayOf(intArrayOf(0,2), intArrayOf(2,0), intArrayOf(2,2), intArrayOf(0,0))
        val k = 4
        val expected = 2
        assertEquals(expected, solution.maxDistance(side, points, k))
    }

    @Test
    fun `example 2`() {
        val side = 2
        val points = arrayOf(intArrayOf(0,0), intArrayOf(1,2), intArrayOf(2,0), intArrayOf(2,2), intArrayOf(2,1))
        val k = 4
        val expected = 1
        assertEquals(expected, solution.maxDistance(side, points, k))
    }

    @Test
    fun `example 3`() {
        val side = 2
        val points = arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,2), intArrayOf(2,0), intArrayOf(2,2), intArrayOf(2,1))
        val k = 5
        val expected = 1
        assertEquals(expected, solution.maxDistance(side, points, k))
    }

    @Test
    fun `minimum square`() {
        val side = 1
        val points = arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(1,1))
        val k = 4
        val expected = 1
        assertEquals(expected, solution.maxDistance(side, points, k))
    }

    @Test
    fun `select subset`() {
        val side = 3
        val points = arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(0,2), intArrayOf(0,3), 
                           intArrayOf(1,3), intArrayOf(2,3), intArrayOf(3,3), intArrayOf(3,2), 
                           intArrayOf(3,1), intArrayOf(3,0), intArrayOf(2,0), intArrayOf(1,0))
        val k = 4
        val result = solution.maxDistance(side, points, k)
        // The maximum distance should be achievable by selecting corner points
        assertEquals(3, result)
    }
}
