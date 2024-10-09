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
            if (board[i][j] == 1) {
                if (liveNeighbors == 2 || liveNeighbors == 3) {
                    board[i][j] = 3 // 1 -> 1 (01 -> 11)
                }
                // else: 1 -> 0 (01 -> 01, no change needed)
            } else { // board[i][j] == 0
                if (liveNeighbors == 3) {
                    board[i][j] = 2 // 0 -> 1 (00 -> 10)
                }
                // else: 0 -> 0 (00 -> 00, no change needed)
            }
        }
    }

    // Update the board to the new state
    for (i in 0 until m) {
        for (j in 0 until n) {
            board[i][j] = board[i][j] shr 1 // Right shift to get the new state
        }
    }
}