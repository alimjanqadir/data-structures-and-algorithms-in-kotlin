package problems

fun largestSubmatrix(matrix: Array<IntArray>): Int {
    val rowCount = matrix.size
    val colCount = matrix[0].size

    val heights = Array(rowCount) { IntArray(colCount) }

    for (colIndex in 0 until colCount) {
        heights[0][colIndex] = matrix[0][colIndex]
        for (rowIndex in 1 until rowCount) {
            if (matrix[rowIndex][colIndex] == 1) {
                heights[rowIndex][colIndex] = heights[rowIndex - 1][colIndex] + 1
            } else {
                heights[rowIndex][colIndex] = 0
            }
        }
    }

    var maximumArea = 0

    for (rowIndex in 0 until rowCount) {
        val sortedHeights = heights[rowIndex].sortedDescending()

        for (colIndex in 0 until colCount) {
            val currentHeight = sortedHeights[colIndex]
            val width = colIndex + 1
            val area = currentHeight * width

            maximumArea = maxOf(maximumArea, area)
        }
    }

    return maximumArea
}
