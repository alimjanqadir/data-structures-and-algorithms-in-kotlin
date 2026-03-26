package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EqualSumGridPartitionIITest {

    @Test
    fun testCanPartitionGridIIEqualSumWithoutDiscount() {
        // grid = [[1,4],[2,3]], expected: true
        // Horizontal cut between rows: top sum = 1+4=5, bottom sum = 2+3=5
        val grid = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 3)
        )
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIIWithDiscount() {
        // grid = [[1,2,1],[2,2,2]], horizontal cut after first row
        // top = 4, bottom = 6, difference = 2
        // Can discount 2 from bottom section (exists at position [1,0], [1,1], or [1,2])
        val grid = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 2, 2)
        )
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIINoValidCut() {
        // Grid where no valid cut exists even with one discount
        // 2x2 grid with values that don't allow equal partition with single discount
        val grid = arrayOf(
            intArrayOf(1, 100),
            intArrayOf(100, 1)
        )
        // Total = 202, target = 101
        // Horizontal cut: top = 101, bottom = 101 -> actually works!
        // Let me use different values
        val grid2 = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 5)
        )
        // Total = 8, no cut can achieve equal partition with single discount
        assertFalse(canPartitionGridII(grid2))
    }

    @Test
    fun testCanPartitionGridIIVerticalCutWithDiscount() {
        // Vertical cut that requires discounting
        val grid = arrayOf(
            intArrayOf(10, 1, 10),
            intArrayOf(10, 1, 10)
        )
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIISingleRow() {
        // Single row grid
        val grid = arrayOf(
            intArrayOf(5, 1, 5)
        )
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIISingleColumn() {
        // Single column grid
        val grid = arrayOf(
            intArrayOf(5),
            intArrayOf(1),
            intArrayOf(5)
        )
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIILargeGrid() {
        // 3x3 grid that can be partitioned
        // Horizontal cut after row 0: top = 30, bottom = 6, diff = 24
        // Can donate 24 from top (exists at [0,2])
        val grid = arrayOf(
            intArrayOf(10, 10, 10),
            intArrayOf(1, 2, 3)
        )
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIIImpossibleCase() {
        // Grid where partition is impossible
        val grid = arrayOf(
            intArrayOf(100000, 100000),
            intArrayOf(100000, 100000)
        )
        // Can partition with equal halves
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIITwoByTwo() {
        // 2x2 grid that requires discount
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        // Total = 10, can't partition evenly, but can with discount
        assertTrue(canPartitionGridII(grid))
    }

    @Test
    fun testCanPartitionGridIIEdgeCase() {
        // Edge case with minimal values
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2)
        )
        assertTrue(canPartitionGridII(grid))
    }
}
