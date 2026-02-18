package problems

fun gameOfLife(board: Array<IntArray>) {
  val rowCount = board.size
  val columnCount = board[0].size

  // All 8 directions for neighbors
  val neighborOffsets = arrayOf(
    intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1),
    intArrayOf(0, -1),                  intArrayOf(0, 1),
    intArrayOf(1, -1),  intArrayOf(1, 0),  intArrayOf(1, 1)
  )

  // Step 1: Encode state transitions
  for (rowIndex in 0 until rowCount) {
    for (columnIndex in 0 until columnCount) {
      var liveNeighborCount = 0

      // Count live neighbors
      for (offset in neighborOffsets) {
        val neighborRow = rowIndex + offset[0]
        val neighborColumn = columnIndex + offset[1]
        if (neighborRow in 0 until rowCount && neighborColumn in 0 until columnCount) {
          if (board[neighborRow][neighborColumn] == 1 || board[neighborRow][neighborColumn] == 2) {
            liveNeighborCount++
          }
        }
      }

      // Apply Game of Life rules with encoded states
      if (board[rowIndex][columnIndex] == 1 && (liveNeighborCount < 2 || liveNeighborCount > 3)) {
        board[rowIndex][columnIndex] = 2 // alive → dead
      }
      if (board[rowIndex][columnIndex] == 0 && liveNeighborCount == 3) {
        board[rowIndex][columnIndex] = -1 // dead → alive
      }
    }
  }

  // Step 2: Finalize the board
  for (rowIndex in 0 until rowCount) {
    for (columnIndex in 0 until columnCount) {
      if (board[rowIndex][columnIndex] == 2) board[rowIndex][columnIndex] = 0
      if (board[rowIndex][columnIndex] == -1) board[rowIndex][columnIndex] = 1
    }
  }
}
