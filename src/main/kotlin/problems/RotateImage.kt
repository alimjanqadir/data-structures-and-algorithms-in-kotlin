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


fun main() {
  val testCases = listOf(
    arrayOf(
      intArrayOf(1)
    ),
    arrayOf(
      intArrayOf(1, 2),
      intArrayOf(3, 4)
    ),
    arrayOf(
      intArrayOf(5, 1, 9, 11),
      intArrayOf(2, 4, 8, 10),
      intArrayOf(13, 3, 6, 7),
      intArrayOf(15, 14, 12, 16)
    )
  )

  val expectedResults = listOf(
    arrayOf(
      intArrayOf(1)
    ),
    arrayOf(
      intArrayOf(3, 1),
      intArrayOf(4, 2)
    ),
    arrayOf(
      intArrayOf(15, 13, 2, 5),
      intArrayOf(14, 3, 4, 1),
      intArrayOf(12, 6, 8, 9),
      intArrayOf(16, 7, 10, 11)
    )
  )

  for ((index, testCase) in testCases.withIndex()) {
    val expected = expectedResults[index]

    // Copy the test case to avoid mutation during testing
    val matrixBruteForce = testCase.map { it.clone() }.toTypedArray()
    val matrixOptimized = testCase.map { it.clone() }.toTypedArray()
    val matrixFunctional = testCase.map { it.clone() }.toTypedArray()

    rotate(matrixBruteForce)
    rotateBruteForce(matrixBruteForce)
    rotateFunctional(matrixFunctional)

    assert(matrixEquals(matrixBruteForce, expected)) { "Brute Force Solution Failed on Test Case $index" }
    assert(matrixEquals(matrixOptimized, expected)) { "Optimized Solution Failed on Test Case $index" }
    assert(matrixEquals(matrixFunctional, expected)) { "Functional Solution Failed on Test Case $index" }
  }

  println("All test cases passed.")
}

fun matrixEquals(a: Array<IntArray>, b: Array<IntArray>): Boolean {
  if (a.size != b.size) return false
  for (i in a.indices) {
    if (!a[i].contentEquals(b[i])) return false
  }
  return true
}