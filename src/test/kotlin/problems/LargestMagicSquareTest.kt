package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LargestMagicSquareTest {

    @Test
    fun testLargestMagicSquareExample1() {
        // Grid with 2x2 magic square (all 5s) embedded
        val grid = arrayOf(
            intArrayOf(7, 1, 4, 3, 6, 5),
            intArrayOf(2, 5, 7, 1, 2, 7),
            intArrayOf(1, 8, 1, 2, 3, 4),
            intArrayOf(4, 2, 1, 6, 5, 1),
            intArrayOf(1, 2, 3, 4, 5, 6)
        )
        assertEquals(1, largestMagicSquare(grid))
    }

    @Test
    fun testLargestMagicSquareExample2() {
        // No magic square larger than 1
        val grid = arrayOf(
            intArrayOf(5, 1, 3),
            intArrayOf(1, 5, 1),
            intArrayOf(3, 1, 5)
        )
        assertEquals(1, largestMagicSquare(grid))
    }

    @Test
    fun testLargestMagicSquareSingleCell() {
        val grid = arrayOf(intArrayOf(5))
        assertEquals(1, largestMagicSquare(grid))
    }

    @Test
    fun testLargestMagicSquareSingleRow() {
        val grid = arrayOf(intArrayOf(1, 2, 3, 4, 5))
        assertEquals(1, largestMagicSquare(grid))
    }

    @Test
    fun testLargestMagicSquareSingleColumn() {
        val grid = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(5)
        )
        assertEquals(1, largestMagicSquare(grid))
    }

    @Test
    fun testLargestMagicSquare2x2() {
        // A valid 2x2 magic square: all elements equal
        val grid = arrayOf(
            intArrayOf(5, 5),
            intArrayOf(5, 5)
        )
        assertEquals(2, largestMagicSquare(grid))
    }

    @Test
    fun testLargestMagicSquare3x3Full() {
        // Classic 3x3 magic square
        val grid = arrayOf(
            intArrayOf(4, 9, 2),
            intArrayOf(3, 5, 7),
            intArrayOf(8, 1, 6)
        )
        assertEquals(3, largestMagicSquare(grid))
    }
}
