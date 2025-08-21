package problems

import java.util.ArrayDeque

data class Bar(val height: Int, val widthCount: Int)

fun numSubmat(mat: Array<IntArray>): Int {
  val rowCount = mat.size
  val columnCount = mat[0].size
  val consecutiveOnesHeight = IntArray(columnCount)
  var totalSubmatrices = 0L

  for (rowIndex in 0 until rowCount) {
    // 1) Build histogram heights for this base row
    for (columnIndex in 0 until columnCount) {
      consecutiveOnesHeight[columnIndex] =
        if (mat[rowIndex][columnIndex] == 1)
          consecutiveOnesHeight[columnIndex] + 1
        else
          0
    }

    // 2) Monotonic stack to count all-ones submatrices with bottom at rowIndex
    val stack = ArrayDeque<Bar>()
    var runningTotalForRow = 0L

    for (columnIndex in 0 until columnCount) {
      var widthAccumulated = 1
      var currentHeight = consecutiveOnesHeight[columnIndex]

      // Merge taller/equal bars to maintain increasing heights
      while (stack.isNotEmpty() && stack.peekLast().height >= currentHeight) {
        val removed = stack.removeLast()
        runningTotalForRow -= removed.height.toLong() * removed.widthCount.toLong()
        widthAccumulated += removed.widthCount
      }

      if (currentHeight > 0) {
        runningTotalForRow += currentHeight.toLong() * widthAccumulated.toLong()
        stack.addLast(Bar(currentHeight, widthAccumulated))
      } else {
        // Height is zero: nothing contributes at this column
        stack.clear() // optional (runningTotalForRow already reflects zero-height)
        runningTotalForRow = 0L
      }

      totalSubmatrices += runningTotalForRow
    }
  }

  // Given constraints, this fits in Int, but keep it safe:
  return totalSubmatrices.toInt()
}

