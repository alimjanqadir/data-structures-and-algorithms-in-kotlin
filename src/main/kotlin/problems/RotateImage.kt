package problems

fun rotate(matrix: Array<IntArray>) {
  val size = matrix.size

  // Step 1: transpose matrix across main diagonal
  for (row in 0 until size) {
    for (col in row until size) {
      val temp = matrix[row][col]
      matrix[row][col] = matrix[col][row]
      matrix[col][row] = temp
    }
  }

  // Step 2: reverse each row
  for (row in 0 until size) {
    var leftColumn = 0
    var rightColumn = size - 1

    while (leftColumn < rightColumn) {
      val temp = matrix[row][leftColumn]
      matrix[row][leftColumn] = matrix[row][rightColumn]
      matrix[row][rightColumn] = temp
      leftColumn += 1
      rightColumn -= 1
    }
  }
}

fun rotateBruteForce(matrix: Array<IntArray>) {
  val n = matrix.size
  val result = Array(n) { IntArray(n) }

  // Copy elements to the new matrix with rotated positions
  for (i in 0 until n) {
    for (j in 0 until n) {
      result[j][n - 1 - i] = matrix[i][j]
    }
  }

  // Copy the result back to the original matrix
  for (i in 0 until n) {
    for (j in 0 until n) {
      matrix[i][j] = result[i][j]
    }
  }
}

fun rotateFunctional(matrix: Array<IntArray>) {
  transpose(matrix)
  reverseRows(matrix)
}

private fun transpose(matrix: Array<IntArray>) {
  val n = matrix.size
  for (i in 0 until n) {
    for (j in i + 1 until n) {
      // Swap elements at (i, j) and (j, i)
      matrix[i][j] = matrix[j][i].also { matrix[j][i] = matrix[i][j] }
    }
  }
}

private fun reverseRows(matrix: Array<IntArray>) {
  for (row in matrix) {
    row.reverse()
  }
}

fun matrixEquals(a: Array<IntArray>, b: Array<IntArray>): Boolean {
  if (a.size != b.size) return false
  for (i in a.indices) {
    if (!a[i].contentEquals(b[i])) return false
  }
  return true
}
