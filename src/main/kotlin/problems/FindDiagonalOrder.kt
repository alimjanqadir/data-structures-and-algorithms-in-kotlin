package problems

fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
  val rowCount = mat.size
  val colCount = mat[0].size
  val totalCount = rowCount * colCount
  val traversal = IntArray(totalCount)

  var rowIndex = 0
  var colIndex = 0
  var movingUp = true
  var writeIndex = 0

  while (writeIndex < totalCount) {
    traversal[writeIndex] = mat[rowIndex][colIndex]
    writeIndex += 1

    if (movingUp) {
      val atTop = rowIndex == 0
      val atRight = colIndex == colCount - 1
      if (atRight) {
        rowIndex += 1
        movingUp = false
      } else if (atTop) {
        colIndex += 1
        movingUp = false
      } else {
        rowIndex -= 1
        colIndex += 1
      }
    } else {
      val atBottom = rowIndex == rowCount - 1
      val atLeft = colIndex == 0
      if (atBottom) {
        colIndex += 1
        movingUp = true
      } else if (atLeft) {
        rowIndex += 1
        movingUp = true
      } else {
        rowIndex += 1
        colIndex -= 1
      }
    }
  }

  return traversal
}
