package problems

// Direction arrays for moving in 4 directions (up, right, down, left)
private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

fun surroundedRegions(board: Array<CharArray>) {
  if (board.isEmpty() || board[0].isEmpty()) return

  val rows = board.size
  val cols = board[0].size

  // Step 1: Mark all 'O's connected to border as safe using DFS
  // Check first and last row
  for (j in 0 until cols) {
    if (board[0][j] == 'O') dfs(board, 0, j)
    if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j)
  }

  // Check first and last column
  for (i in 0 until rows) {
    if (board[i][0] == 'O') dfs(board, i, 0)
    if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1)
  }

  // Step 2: Process the entire board
  // - Convert remaining 'O's to 'X's (these are surrounded)
  // - Convert '#'s back to 'O's (these were safe)
  for (i in 0 until rows) {
    for (j in 0 until cols) {
      if (board[i][j] == 'O') {
        board[i][j] = 'X'
      } else if (board[i][j] == '#') {
        board[i][j] = 'O'
      }
    }
  }
}

// DFS to mark connected 'O's as safe using temporary marker '#'
private fun dfs(board: Array<CharArray>, row: Int, col: Int) {
  // Base case: out of bounds or not an 'O'
  if (row < 0 || row >= board.size || col < 0 || col >= board[0].size || board[row][col] != 'O') {
    return
  }

  // Mark current cell as safe
  board[row][col] = '#'

  // Recursively check all 4 directions
  for (i in 0..3) {
    dfs(board, row + dx[i], col + dy[i])
  }
}

// Test cases
fun printBoard(board: Array<CharArray>) {
  for (row in board) {
    println(row.joinToString(" "))
  }
}
