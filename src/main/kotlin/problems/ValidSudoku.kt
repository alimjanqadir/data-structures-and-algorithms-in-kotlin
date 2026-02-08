package problems.validsudoku

class Solution {
  fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rowUsed = IntArray(9)
    val columnUsed = IntArray(9)
    val boxUsed = IntArray(9)

    for (rowIndex in 0 until 9) {
      for (columnIndex in 0 until 9) {
        val cell = board[rowIndex][columnIndex]
        if (cell == '.') continue

        val digitIndex = cell - '1'          // 0..8
        if (digitIndex !in 0..8) return false // guard against invalid chars

        val bit = 1 shl digitIndex
        val boxIndex = (rowIndex / 3) * 3 + (columnIndex / 3)

        val seenInRow = (rowUsed[rowIndex] and bit) != 0
        val seenInColumn = (columnUsed[columnIndex] and bit) != 0
        val seenInBox = (boxUsed[boxIndex] and bit) != 0
        if (seenInRow || seenInColumn || seenInBox) return false

        rowUsed[rowIndex] = rowUsed[rowIndex] or bit
        columnUsed[columnIndex] = columnUsed[columnIndex] or bit
        boxUsed[boxIndex] = boxUsed[boxIndex] or bit
      }
    }
    return true
  }
}
