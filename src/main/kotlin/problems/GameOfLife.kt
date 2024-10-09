package problems

fun gameOfLife(board: Array<IntArray>) {
    val m = board.size
    val n = board[0].size

    val dirs = arrayOf(
        intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
        intArrayOf(0, -1),               intArrayOf(0, 1),
        intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1)
    )

    for (i in 0 until m) {
        for (j in 0 until n) {
            var liveNeighbors = 0
            // Count live neighbors using original state (least significant bit)
            for (dir in dirs) {
                val ni = i + dir[0]
                val nj = j + dir[1]
                if (ni in 0 until m && nj in 0 until n && (board[ni][nj] and 1) == 1) {
                    liveNeighbors++
                }
            }
            // Encode new state in the second bit
            if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                board[i][j] = 2 // 1 -> 0
            } else if (board[i][j] == 0 && liveNeighbors == 3) {
                board[i][j] = 3 // 0 -> 1
            }
            // Else, the state remains the same (1->1 or 0->0)
        }
    }

    // Update the board to the new state
    for (i in 0 until m) {
        for (j in 0 until n) {
            board[i][j] %= 2 // New state is the least significant bit
        }
    }
}