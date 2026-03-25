package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class EqualSumGridPartitionITest {

    @Test
    fun testCanPartitionGridExample1() {
        // grid = [[1,4],[2,3]], expected: true
        // Horizontal cut between rows: top sum = 1+4=5, bottom sum = 2+3=5
        val grid = arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 3)
        )
        assertTrue(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridExample2() {
        // grid = [[1,3],[2,4]], expected: false
        // Total sum = 10, target = 5, no cut can achieve equal sum
        val grid = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 4)
        )
        assertFalse(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridVerticalCut() {
        // Vertical cut: left sum = 1+2=3, right sum = 4+3=7 (not equal)
        // But for grid = [[5,5],[5,5]], vertical cut works: left=10, right=10
        val grid = arrayOf(
            intArrayOf(5, 5),
            intArrayOf(5, 5)
        )
        assertTrue(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridOddTotalSum() {
        // Total sum is odd, cannot partition
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertFalse(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridSingleRow() {
        // Single row, can only do vertical cut
        // grid = [[2,2,2,2]], total=8, target=4
        // After first 2 elements: sum=4, which equals target
        val grid = arrayOf(
            intArrayOf(2, 2, 2, 2)
        )
        assertTrue(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridSingleColumn() {
        // Single column, can only do horizontal cut
        // grid = [[2],[2],[2],[2]], total=8, target=4
        // After first 2 elements: sum=4, which equals target
        val grid = arrayOf(
            intArrayOf(2),
            intArrayOf(2),
            intArrayOf(2),
            intArrayOf(2)
        )
        assertTrue(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridCannotPartitionSingleRow() {
        // Single row, cannot partition because no valid vertical cut
        // grid = [[1,2,3]], total=6, target=3
        // After first element: sum=1, after second: sum=3 -> should work
        val grid = arrayOf(
            intArrayOf(1, 2, 3)
        )
        assertTrue(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridCannotPartitionSingleColumn() {
        // Single column where horizontal cut doesn't work
        // grid = [[1],[2],[3]], total=6, target=3
        // After first: sum=1, after second: sum=3 -> should work
        val grid = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3)
        )
        assertTrue(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridLargeNumbers() {
        // Test with large numbers that require Long
        val grid = arrayOf(
            intArrayOf(100000, 100000),
            intArrayOf(100000, 100000)
        )
        // Total = 400000, target = 200000
        // Horizontal cut: top = 200000, which equals target
        assertTrue(canPartitionGrid(grid))
    }

    @Test
    fun testCanPartitionGridNoValidCut() {
        // 2x3 grid where no cut works
        // grid = [[1,1,1],[1,1,2]], total=7 (odd), cannot partition
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 2)
        )
        assertFalse(canPartitionGrid(grid))
    }
}
