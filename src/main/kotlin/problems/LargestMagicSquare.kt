package problems

/**
 * 1895. Largest Magic Square
 * A k x k magic square is a k x k grid filled with integers such that every row sum,
 * every column sum, and both diagonal sums are all equal.
 * Time Complexity: O(m * n * min(m, n)^2)
 * Space Complexity: O(m * n)
 */
fun largestMagicSquare(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size

    val rowPrefix = Array(rows) { IntArray(cols + 1) }
    val colPrefix = Array(rows + 1) { IntArray(cols) }

    // Build row prefix
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            rowPrefix[row][col + 1] = rowPrefix[row][col] + grid[row][col]
        }
    }

    // Build column prefix
    for (col in 0 until cols) {
        for (row in 0 until rows) {
            colPrefix[row + 1][col] = colPrefix[row][col] + grid[row][col]
        }
    }

    fun getRowSum(row: Int, startCol: Int, endCol: Int): Int {
        return rowPrefix[row][endCol + 1] - rowPrefix[row][startCol]
    }

    fun getColSum(col: Int, startRow: Int, endRow: Int): Int {
        return colPrefix[endRow + 1][col] - colPrefix[startRow][col]
    }

    fun isMagic(topRow: Int, leftCol: Int, size: Int): Boolean {
        val target = getRowSum(topRow, leftCol, leftCol + size - 1)

        // Check rows
        for (row in topRow until topRow + size) {
            if (getRowSum(row, leftCol, leftCol + size - 1) != target) {
                return false
            }
        }

        // Check columns
        for (col in leftCol until leftCol + size) {
            if (getColSum(col, topRow, topRow + size - 1) != target) {
                return false
            }
        }

        // Check diagonals
        var mainDiagonal = 0
        var antiDiagonal = 0

        for (offset in 0 until size) {
            mainDiagonal += grid[topRow + offset][leftCol + offset]
            antiDiagonal += grid[topRow + offset][leftCol + size - 1 - offset]
        }

        return mainDiagonal == target && antiDiagonal == target
    }

    for (size in minOf(rows, cols) downTo 1) {
        for (topRow in 0..rows - size) {
            for (leftCol in 0..cols - size) {
                if (isMagic(topRow, leftCol, size)) {
                    return size
                }
            }
        }
    }

    return 1
}
