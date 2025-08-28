package problems

fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
  val size = grid.size
  if (size <= 1) return grid

  for (startCol in 0 until size) {
    val shouldAscending = startCol > 0
    processDiagonal(grid, startRow = 0, startCol = startCol, ascending = shouldAscending)
  }

  for (startRow in 1 until size) {
    processDiagonal(grid, startRow = startRow, startCol = 0, ascending = false)
  }

  return grid
}

private fun processDiagonal(
  grid: Array<IntArray>,
  startRow: Int,
  startCol: Int,
  ascending: Boolean
) {
  val size = grid.size
  val diagonalValues = ArrayList<Int>()
  var rowIndex = startRow
  var colIndex = startCol

  while (rowIndex < size && colIndex < size) {
    diagonalValues.add(grid[rowIndex][colIndex])
    rowIndex += 1
    colIndex += 1
  }

  diagonalValues.sort()
  if (!ascending) {
    diagonalValues.reverse()
  }

  rowIndex = startRow
  colIndex = startCol
  var writeIndex = 0
  while (rowIndex < size && colIndex < size) {
    grid[rowIndex][colIndex] = diagonalValues[writeIndex]
    writeIndex += 1
    rowIndex += 1
    colIndex += 1
  }
}

