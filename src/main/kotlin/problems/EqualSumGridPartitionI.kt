package problems

fun canPartitionGrid(grid: Array<IntArray>): Boolean {
    val rowCount = grid.size
    val colCount = grid[0].size

    var totalSum = 0L
    for (row in grid) {
        for (value in row) {
            totalSum += value
        }
    }

    if (totalSum % 2L != 0L) {
        return false
    }

    val target = totalSum / 2

    // Try horizontal cuts
    var runningRowSum = 0L
    for (rowIndex in 0 until rowCount - 1) {
        for (value in grid[rowIndex]) {
            runningRowSum += value
        }
        if (runningRowSum == target) {
            return true
        }
    }

    // Compute column sums
    val columnSums = LongArray(colCount)
    for (rowIndex in 0 until rowCount) {
        for (colIndex in 0 until colCount) {
            columnSums[colIndex] += grid[rowIndex][colIndex]
        }
    }

    // Try vertical cuts
    var runningColumnSum = 0L
    for (colIndex in 0 until colCount - 1) {
        runningColumnSum += columnSums[colIndex]
        if (runningColumnSum == target) {
            return true
        }
    }

    return false
}
