package problems

/**
 * 1391. Check if There is a Valid Path in a Grid
 *
 * Treat each cell as a street piece with two open directions. A path is valid only when two neighboring cells connect back to each other.
 *
 * The clean way is a graph search from `(0, 0)`:
 *
 * 1. Move from the current cell to each direction allowed by its street type.
 * 2. For every candidate neighbor, check whether that neighbor has the opposite opening.
 * 3. Mark visited cells so each cell is processed once.
 * 4. Return `true` as soon as `(m - 1, n - 1)` is reached.
 *
 * ### Street connections
 *
 * * `1`: left, right
 * * `2`: up, down
 * * `3`: left, down
 * * `4`: right, down
 * * `5`: left, up
 * * `6`: right, up
 */
class CheckIfThereIsAValidPathInAGrid {
    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val rowCount = grid.size
        val colCount = grid[0].size

        val directionsByStreet = arrayOf(
            emptyArray(),
            arrayOf(intArrayOf(0, -1), intArrayOf(0, 1)),   // 1
            arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0)),   // 2
            arrayOf(intArrayOf(0, -1), intArrayOf(1, 0)),   // 3
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 0)),    // 4
            arrayOf(intArrayOf(0, -1), intArrayOf(-1, 0)),  // 5
            arrayOf(intArrayOf(0, 1), intArrayOf(-1, 0))    // 6
        )

        fun isConnected(currentStreet: Int, deltaRow: Int, deltaCol: Int, nextStreet: Int): Boolean {
            return when {
                deltaRow == 0 && deltaCol == -1 -> nextStreet == 1 || nextStreet == 4 || nextStreet == 6
                deltaRow == 0 && deltaCol == 1 -> nextStreet == 1 || nextStreet == 3 || nextStreet == 5
                deltaRow == -1 && deltaCol == 0 -> nextStreet == 2 || nextStreet == 3 || nextStreet == 4
                else -> nextStreet == 2 || nextStreet == 5 || nextStreet == 6
            }
        }

        val visited = Array(rowCount) { BooleanArray(colCount) }
        val queue: ArrayDeque<IntArray> = ArrayDeque()
        queue.add(intArrayOf(0, 0))
        visited[0][0] = true

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val currentRow = current[0]
            val currentCol = current[1]

            if (currentRow == rowCount - 1 && currentCol == colCount - 1) {
                return true
            }

            val currentStreet = grid[currentRow][currentCol]
            for (direction in directionsByStreet[currentStreet]) {
                val nextRow = currentRow + direction[0]
                val nextCol = currentCol + direction[1]

                if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount) {
                    continue
                }
                if (visited[nextRow][nextCol]) {
                    continue
                }

                val nextStreet = grid[nextRow][nextCol]
                if (isConnected(currentStreet, direction[0], direction[1], nextStreet)) {
                    visited[nextRow][nextCol] = true
                    queue.add(intArrayOf(nextRow, nextCol))
                }
            }
        }

        return false
    }
}
