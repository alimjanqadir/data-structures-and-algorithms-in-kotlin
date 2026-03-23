package problems

/**
 * 1594. Maximum Non Negative Product in a Matrix
 * You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0),
 * and in each step, you can only move right or down in the matrix.
 *
 * Among all possible paths starting from (0, 0) and ending in (m - 1, n - 1),
 * find the path with the maximum non-negative product.
 * The product of a path is the product of all integers visited along the path.
 *
 * Return the maximum non-negative product modulo 10^9 + 7.
 * If the maximum product is negative, return -1.
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
fun maxProductPath(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size

    val maxProduct = Array(rows) { LongArray(cols) }
    val minProduct = Array(rows) { LongArray(cols) }

    maxProduct[0][0] = grid[0][0].toLong()
    minProduct[0][0] = grid[0][0].toLong()

    // First column
    for (row in 1 until rows) {
        val value = grid[row][0].toLong()
        maxProduct[row][0] = maxProduct[row - 1][0] * value
        minProduct[row][0] = maxProduct[row][0]
    }

    // First row
    for (col in 1 until cols) {
        val value = grid[0][col].toLong()
        maxProduct[0][col] = maxProduct[0][col - 1] * value
        minProduct[0][col] = maxProduct[0][col]
    }

    // Fill rest
    for (row in 1 until rows) {
        for (col in 1 until cols) {
            val value = grid[row][col].toLong()

            val candidates = listOf(
                maxProduct[row - 1][col] * value,
                minProduct[row - 1][col] * value,
                maxProduct[row][col - 1] * value,
                minProduct[row][col - 1] * value
            )

            maxProduct[row][col] = candidates.maxOrNull()!!
            minProduct[row][col] = candidates.minOrNull()!!
        }
    }

    val result = maxProduct[rows - 1][cols - 1]
    val mod = 1_000_000_007L

    return if (result < 0) -1 else (result % mod).toInt()
}
