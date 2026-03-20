package problems

import kotlin.test.Test
import kotlin.test.assertTrue

class FlipSquareSubmatrixVerticallyTest {

    private fun assert2DArrayContentEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertTrue(expected.size == actual.size, "Arrays have different sizes: ${expected.size} vs ${actual.size}")
        for (i in expected.indices) {
            assertTrue(expected[i].size == actual[i].size, "Row $i has different sizes: ${expected[i].size} vs ${actual[i].size}")
            for (j in expected[i].indices) {
                assertTrue(expected[i][j] == actual[i][j], "Element at [$i][$j] differs: expected ${expected[i][j]}, actual ${actual[i][j]}")
            }
        }
    }

    @Test
    fun testBasicExample() {
        // Test case 1: Basic 2x2 flip
        val input = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val expected = arrayOf(
            intArrayOf(3, 4),
            intArrayOf(1, 2)
        )

        reverseSubmatrix(input, 0, 0, 2)
        assert2DArrayContentEquals(expected, input)
    }

    @Test
    fun testFlipWithinLargerMatrix() {
        // Test case 2: Flip a 2x2 submatrix within a larger 3x3 matrix
        val input = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(7, 8, 6),
            intArrayOf(4, 5, 9)
        )

        reverseSubmatrix(input, 1, 0, 2)
        assert2DArrayContentEquals(expected, input)
    }

    @Test
    fun test3x3Flip() {
        // Test case 3: Flip a 3x3 submatrix
        val input = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(7, 8, 9),
            intArrayOf(4, 5, 6),
            intArrayOf(1, 2, 3)
        )

        reverseSubmatrix(input, 0, 0, 3)
        assert2DArrayContentEquals(expected, input)
    }

    @Test
    fun test1x1Flip() {
        // Test case 4: 1x1 submatrix (no change)
        val input = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        reverseSubmatrix(input, 1, 1, 1)
        assert2DArrayContentEquals(expected, input)
    }

    @Test
    fun testOffsetSubmatrix() {
        // Test case 5: Flip submatrix starting at offset position
        val input = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 10, 11, 8),
            intArrayOf(9, 6, 7, 12),
            intArrayOf(13, 14, 15, 16)
        )

        reverseSubmatrix(input, 1, 1, 2)
        assert2DArrayContentEquals(expected, input)
    }

    @Test
    fun test4x4Flip() {
        // Test case 6: Flip 4x4 matrix
        val input = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(13, 14, 15, 16),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(1, 2, 3, 4)
        )

        reverseSubmatrix(input, 0, 0, 4)
        assert2DArrayContentEquals(expected, input)
    }

    @Test
    fun testLargerGridPartialFlip() {
        // Test case 7: 5x5 grid with 3x3 flip at position (1, 1)
        val input = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 7, 8, 9, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 17, 18, 19, 20),
            intArrayOf(21, 22, 23, 24, 25)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 17, 18, 19, 10),
            intArrayOf(11, 12, 13, 14, 15),
            intArrayOf(16, 7, 8, 9, 20),
            intArrayOf(21, 22, 23, 24, 25)
        )

        reverseSubmatrix(input, 1, 1, 3)
        assert2DArrayContentEquals(expected, input)
    }
}
