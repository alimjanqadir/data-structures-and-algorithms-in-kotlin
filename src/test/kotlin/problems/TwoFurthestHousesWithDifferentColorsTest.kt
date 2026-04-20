package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class TwoFurthestHousesWithDifferentColorsTest {

    @Test
    fun testExample1() {
        // colors = [1,1,1,6,1,1,1], expected = 3
        val colors = intArrayOf(1, 1, 1, 6, 1, 1, 1)
        assertEquals(3, maxDistanceBetweenHouses(colors))
    }

    @Test
    fun testExample2() {
        // colors = [1,8,3,8,3], expected = 4
        val colors = intArrayOf(1, 8, 3, 8, 3)
        assertEquals(4, maxDistanceBetweenHouses(colors))
    }

    @Test
    fun testExample3() {
        // colors = [0,1], expected = 1
        val colors = intArrayOf(0, 1)
        assertEquals(1, maxDistanceBetweenHouses(colors))
    }

    @Test
    fun testAllSameColors() {
        // All houses have same color, but constraint says at least 2 different colors
        // This tests edge case behavior
        val colors = intArrayOf(1, 1, 1, 1, 1)
        assertEquals(0, maxDistanceBetweenHouses(colors))
    }

    @Test
    fun testFirstAndLastDifferent() {
        // colors = [1,1,1,1,2], expected = 4 (distance from index 0 to 4)
        val colors = intArrayOf(1, 1, 1, 1, 2)
        assertEquals(4, maxDistanceBetweenHouses(colors))
    }

    @Test
    fun testMinimumCase() {
        // colors = [0,1], minimum valid case
        val colors = intArrayOf(0, 1)
        assertEquals(1, maxDistanceBetweenHouses(colors))
    }

    @Test
    fun testAlternatingColors() {
        // colors = [0,1,0,1,0], first and last are both 0
        // farthest different from first: index 3 (color 1), distance = 3
        // farthest different from last: index 1 (color 1), distance = 3
        val colors = intArrayOf(0, 1, 0, 1, 0)
        assertEquals(3, maxDistanceBetweenHouses(colors))
    }

    @Test
    fun testMiddleDifferent() {
        // colors = [1,1,1,2,1,1,1], distance to middle from both ends
        val colors = intArrayOf(1, 1, 1, 2, 1, 1, 1)
        assertEquals(3, maxDistanceBetweenHouses(colors))
    }
}
