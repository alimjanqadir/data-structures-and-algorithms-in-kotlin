package problems

fun canPartitionGridII(grid: Array<IntArray>): Boolean {
    if (checkHorizontalCutsII(grid)) return true
    if (checkVerticalCutsII(grid)) return true
    return false
}

private fun checkHorizontalCutsII(grid: Array<IntArray>): Boolean {
    val rowCount = grid.size
    val columnCount = grid[0].size
    val topFrequency = IntArray(MAX_VALUE_II + 1)
    val bottomFrequency = IntArray(MAX_VALUE_II + 1)

    var bottomSum = 0L
    for (rowIndex in 0 until rowCount) {
        for (columnIndex in 0 until columnCount) {
            val cellValue = grid[rowIndex][columnIndex]
            bottomFrequency[cellValue] += 1
            bottomSum += cellValue.toLong()
        }
    }

    var topSum = 0L
    for (cutRow in 0 until rowCount - 1) {
        for (columnIndex in 0 until columnCount) {
            val cellValue = grid[cutRow][columnIndex]
            topFrequency[cellValue] += 1
            bottomFrequency[cellValue] -= 1
            topSum += cellValue.toLong()
            bottomSum -= cellValue.toLong()
        }

        if (topSum == bottomSum) return true

        val difference = kotlin.math.abs(topSum - bottomSum)
        if (difference <= MAX_VALUE_II.toLong()) {
            if (topSum > bottomSum) {
                if (canDonateFromSectionII(
                        grid,
                        0,
                        cutRow,
                        0,
                        columnCount - 1,
                        difference,
                        topFrequency
                    )
                ) return true
            } else {
                if (canDonateFromSectionII(
                        grid,
                        cutRow + 1,
                        rowCount - 1,
                        0,
                        columnCount - 1,
                        difference,
                        bottomFrequency
                    )
                ) return true
            }
        }
    }

    return false
}

private fun checkVerticalCutsII(grid: Array<IntArray>): Boolean {
    val rowCount = grid.size
    val columnCount = grid[0].size
    val leftFrequency = IntArray(MAX_VALUE_II + 1)
    val rightFrequency = IntArray(MAX_VALUE_II + 1)

    var rightSum = 0L
    for (rowIndex in 0 until rowCount) {
        for (columnIndex in 0 until columnCount) {
            val cellValue = grid[rowIndex][columnIndex]
            rightFrequency[cellValue] += 1
            rightSum += cellValue.toLong()
        }
    }

    var leftSum = 0L
    for (cutColumn in 0 until columnCount - 1) {
        for (rowIndex in 0 until rowCount) {
            val cellValue = grid[rowIndex][cutColumn]
            leftFrequency[cellValue] += 1
            rightFrequency[cellValue] -= 1
            leftSum += cellValue.toLong()
            rightSum -= cellValue.toLong()
        }

        if (leftSum == rightSum) return true

        val difference = kotlin.math.abs(leftSum - rightSum)
        if (difference <= MAX_VALUE_II.toLong()) {
            if (leftSum > rightSum) {
                if (canDonateFromSectionII(
                        grid,
                        0,
                        rowCount - 1,
                        0,
                        cutColumn,
                        difference,
                        leftFrequency
                    )
                ) return true
            } else {
                if (canDonateFromSectionII(
                        grid,
                        0,
                        rowCount - 1,
                        cutColumn + 1,
                        columnCount - 1,
                        difference,
                        rightFrequency
                    )
                ) return true
            }
        }
    }

    return false
}

private fun canDonateFromSectionII(
    grid: Array<IntArray>,
    startRow: Int,
    endRow: Int,
    startColumn: Int,
    endColumn: Int,
    difference: Long,
    frequency: IntArray
): Boolean {
    val sectionHeight = endRow - startRow + 1
    val sectionWidth = endColumn - startColumn + 1

    return when {
        sectionHeight > 1 && sectionWidth > 1 -> frequency[difference.toInt()] > 0
        sectionHeight == 1 && sectionWidth == 1 -> false
        sectionHeight == 1 -> {
            val leftCellValue = grid[startRow][startColumn]
            val rightCellValue = grid[startRow][endColumn]
            difference == leftCellValue.toLong() || difference == rightCellValue.toLong()
        }
        else -> {
            val topCellValue = grid[startRow][startColumn]
            val bottomCellValue = grid[endRow][startColumn]
            difference == topCellValue.toLong() || difference == bottomCellValue.toLong()
        }
    }
}

private const val MAX_VALUE_II = 100000
