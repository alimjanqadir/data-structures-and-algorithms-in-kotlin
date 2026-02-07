package problems

fun countSquares(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty()) return 0
    val rowCount = matrix.size
    val columnCount = matrix[0].size

    // dp[c] = largest square side ending at current row, column c-1
    // We use 1-based dp indexing to simplify boundaries.
    val dp = IntArray(columnCount + 1)
    var totalSquares = 0

    for (rowIndex in 1..rowCount) {
      var previousDiagonal = 0 // holds dp[c-1] from the previous row (dp value up-left)
      for (columnIndex in 1..columnCount) {
        val tempPreviousRowSameColumn = dp[columnIndex] // this is dp[r-1][c] before we overwrite
        if (matrix[rowIndex - 1][columnIndex - 1] == 1) {
          val up = dp[columnIndex]
          val left = dp[columnIndex - 1]
          val upLeft = previousDiagonal
          dp[columnIndex] = 1 + minOf(up, left, upLeft)
        } else {
          dp[columnIndex] = 0
        }
        totalSquares += dp[columnIndex]
        previousDiagonal = tempPreviousRowSameColumn
      }
    }
    return totalSquares
}
