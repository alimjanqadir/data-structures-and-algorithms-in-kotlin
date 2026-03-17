package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LargestSubmatrixWithRearrangementsTest {

    @Test
    fun testExample1() {
        val matrix = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1)
        )
        val result = largestSubmatrix(matrix)
        assertEquals(4, result)
    }

    @Test
    fun testExample2() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 1, 0, 1)
        )
        val result = largestSubmatrix(matrix)
        assertEquals(3, result)
    }

    @Test
    fun testExample3() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        val result = largestSubmatrix(matrix)
        assertEquals(2, result)
    }

    @Test
    fun testAllOnes() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        val result = largestSubmatrix(matrix)
        assertEquals(9, result)
    }

    @Test
    fun testSingleRow() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1, 1)
        )
        val result = largestSubmatrix(matrix)
        assertEquals(4, result)
    }

    @Test
    fun testSingleColumn() {
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(1),
            intArrayOf(1)
        )
        val result = largestSubmatrix(matrix)
        assertEquals(3, result)
    }
}
