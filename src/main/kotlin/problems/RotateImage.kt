package problems

fun rotate(matrix: Array<IntArray>): Unit {
  // Get the size of the matrix (n x n)
  val len = matrix.size

  // Iterate through each layer of the matrix
  for (row in 0 until len / 2) { // Loop through the rows up to the middle
    for (col in 0 until (len + 1) / 2) { // Loop through the columns up to the middle
      // Store the value of the current element (top-left)
      val tmp = matrix[row][col]

      // Move the bottom-left element to the top-left position
      matrix[row][col] = matrix[len - col - 1][row]

      // Move the bottom-right element to the bottom-left position
      matrix[len - col - 1][row] = matrix[len - row - 1][len - col - 1]

      // Move the top-right element to the bottom-right position
      matrix[len - row - 1][len - col - 1] = matrix[col][len - row - 1]

      // Assign the saved value (original top-left) to the top-right position
      matrix[col][len - row - 1] = tmp
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
