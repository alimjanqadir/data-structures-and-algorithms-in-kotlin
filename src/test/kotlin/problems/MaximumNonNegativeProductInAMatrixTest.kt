package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumNonNegativeProductInAMatrixTest {
    @Test
    fun example1() {
        val grid = arrayOf(
            intArrayOf(-1, -2, -3),
            intArrayOf(-2, -3, -3),
            intArrayOf(-3, -3, -2)
        )
        assertEquals(-1, maxProductPath(grid))
    }

    @Test
    fun example2() {
        val grid = arrayOf(
            intArrayOf(1, -2, 1),
            intArrayOf(1, -2, 1),
            intArrayOf(3, -4, 1)
        )
        assertEquals(8, maxProductPath(grid))
    }

    @Test
    fun example3() {
        val grid = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(0, -4)
        )
        assertEquals(0, maxProductPath(grid))
    }

    @Test
    fun singleCellPositive() {
        val grid = arrayOf(intArrayOf(5))
        assertEquals(5, maxProductPath(grid))
    }

    @Test
    fun singleCellNegative() {
        val grid = arrayOf(intArrayOf(-5))
        assertEquals(-1, maxProductPath(grid))
    }

    @Test
    fun singleCellZero() {
        val grid = arrayOf(intArrayOf(0))
        assertEquals(0, maxProductPath(grid))
    }

    @Test
    fun twoByTwoAllPositive() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(12, maxProductPath(grid)) // 1*3*4 = 12 (down then right)
    }

    @Test
    fun largeModulo() {
        val grid = Array(15) { IntArray(15) { 2 } }
        val result = maxProductPath(grid)
        // Product would be 2^29, modulo 10^9+7
        assertEquals(536870912, result)
    }
}
