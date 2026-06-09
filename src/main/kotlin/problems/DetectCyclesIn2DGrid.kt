class Solution {

    private val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun containsCycle(grid: Array<CharArray>): Boolean {
        val rowCount = grid.size
        val columnCount = grid[0].size
        val visited = Array(rowCount) { BooleanArray(columnCount) }

        for (row in 0 until rowCount) {
            for (column in 0 until columnCount) {
                if (!visited[row][column]) {
                    if (dfs(grid, row, column, -1, -1, visited)) {
                        return true
                    }
                }
            }
        }
        return false
    }

    private fun dfs(
        grid: Array<CharArray>,
        currentRow: Int,
        currentColumn: Int,
        previousRow: Int,
        previousColumn: Int,
        visited: Array<BooleanArray>
    ): Boolean {
        visited[currentRow][currentColumn] = true

        for (direction in directions) {
            val nextRow = currentRow + direction[0]
            val nextColumn = currentColumn + direction[1]

            if (nextRow !in grid.indices || nextColumn !in grid[0].indices) continue
            if (grid[nextRow][nextColumn] != grid[currentRow][currentColumn]) continue

            if (nextRow == previousRow && nextColumn == previousColumn) continue

            if (visited[nextRow][nextColumn]) {
                return true
            }

            if (dfs(grid, nextRow, nextColumn, currentRow, currentColumn, visited)) {
                return true
            }
        }

        return false
    }
}
