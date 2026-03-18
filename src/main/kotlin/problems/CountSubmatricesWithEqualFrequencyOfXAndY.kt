package problems

/**
 * 3212. Count Submatrices With Equal Frequency of X and Y
 * Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.',
 * return the number of submatrices that contain:
 * - grid[0][0]
 * - an equal frequency of 'X' and 'Y'
 * - at least one 'X'
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
fun numberOfSubmatrices(grid: Array<CharArray>): Int {
    val rows = grid.size
    val cols = grid[0].size

    val balancePrefix = Array(rows) { IntArray(cols) }
    val xCountPrefix = Array(rows) { IntArray(cols) }

    for (row in 0 until rows) {
        for (col in 0 until cols) {

            val value = when (grid[row][col]) {
                'X' -> 1
                'Y' -> -1
                else -> 0
            }

            val xValue = if (grid[row][col] == 'X') 1 else 0

            val topBalance = if (row > 0) balancePrefix[row - 1][col] else 0
            val leftBalance = if (col > 0) balancePrefix[row][col - 1] else 0
            val overlapBalance = if (row > 0 && col > 0) balancePrefix[row - 1][col - 1] else 0

            balancePrefix[row][col] = value + topBalance + leftBalance - overlapBalance

            val topX = if (row > 0) xCountPrefix[row - 1][col] else 0
            val leftX = if (col > 0) xCountPrefix[row][col - 1] else 0
            val overlapX = if (row > 0 && col > 0) xCountPrefix[row - 1][col - 1] else 0

            xCountPrefix[row][col] = xValue + topX + leftX - overlapX
        }
    }

    var result = 0

    for (row in 0 until rows) {
        for (col in 0 until cols) {

            val balance = balancePrefix[row][col]
            val xCount = xCountPrefix[row][col]

            if (balance == 0 && xCount > 0) {
                result += 1
            }
        }
    }

    return result
}
