package problems

fun rotateTheBox(boxGrid: Array<CharArray>): Array<CharArray> {
  val rowCount = boxGrid.size
  val colCount = boxGrid[0].size

  for (rowIndex in 0 until rowCount) {
    var emptyPosition = colCount - 1

    for (colIndex in colCount - 1 downTo 0) {
      when (boxGrid[rowIndex][colIndex]) {
        '*' -> emptyPosition = colIndex - 1
        '#' -> {
          boxGrid[rowIndex][colIndex] = '.'
          boxGrid[rowIndex][emptyPosition] = '#'
          emptyPosition -= 1
        }
      }
    }
  }

  val rotatedBox = Array(colCount) { CharArray(rowCount) }

  for (rowIndex in 0 until rowCount) {
    for (colIndex in 0 until colCount) {
      rotatedBox[colIndex][rowCount - 1 - rowIndex] = boxGrid[rowIndex][colIndex]
    }
  }

  return rotatedBox
}
