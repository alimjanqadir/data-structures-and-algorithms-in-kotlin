package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumOperationsToMakeAUniValueGridTest {

    private val solution = MinimumOperationsToMakeAUniValueGrid()

    @Test
    fun `test example 1`() {
        val grid = arrayOf(
            intArrayOf(2, 4),
            intArrayOf(6, 8)
        )
        val x = 2
        val expected = 4
        assertEquals(expected, solution.minOperations(grid, x))
    }

    @Test
    fun `test example 2`() {
        val grid = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(2, 3)
        )
        val x = 1
        val expected = 5
        assertEquals(expected, solution.minOperations(grid, x))
    }

    @Test
    fun `test impossible case`() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val x = 2
        val expected = -1
        assertEquals(expected, solution.minOperations(grid, x))
    }

    @Test
    fun `test single element`() {
        val grid = arrayOf(
            intArrayOf(5)
        )
        val x = 3
        val expected = 0
        assertEquals(expected, solution.minOperations(grid, x))
    }

    @Test
    fun `test all elements already equal`() {
        val grid = arrayOf(
            intArrayOf(4, 4),
            intArrayOf(4, 4)
        )
        val x = 2
        val expected = 0
        assertEquals(expected, solution.minOperations(grid, x))
    }

    @Test
    fun `test larger grid`() {
        val grid = arrayOf(
            intArrayOf(1, 3, 5),
            intArrayOf(7, 9, 11),
            intArrayOf(13, 15, 17)
        )
        val x = 2
        val expected = 24
        assertEquals(expected, solution.minOperations(grid, x))
    }

    @Test
    fun `test x equals 1`() {
        val grid = arrayOf(
            intArrayOf(10, 20, 30),
            intArrayOf(40, 50, 60)
        )
        val x = 1
        val expected = 90
        assertEquals(expected, solution.minOperations(grid, x))
    }

    @Test
    fun `test negative numbers`() {
        val grid = arrayOf(
            intArrayOf(-2, 0, 2),
            intArrayOf(4, 6, 8)
        )
        val x = 2
        val expected = 12
        assertEquals(expected, solution.minOperations(grid, x))
    }
}
