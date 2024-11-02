package problems

fun setZeroesBruteForce(matrix: Array<IntArray>) {
  val m = matrix.size
  val n = matrix[0].size
  val rows = mutableSetOf<Int>()
  val cols = mutableSetOf<Int>()

  // First pass: record rows and columns that contain zeros
  for (i in 0 until m) {
    for (j in 0 until n) {
      if (matrix[i][j] == 0) {
        rows.add(i)
        cols.add(j)
      }
    }
  }

  // Second pass: set matrix elements to zero based on recorded rows and columns
  for (i in 0 until m) {
    for (j in 0 until n) {
      if (i in rows || j in cols) {
        matrix[i][j] = 0
      }
    }
  }
}

fun setZeroesOptimized(matrix: Array<IntArray>) {
  val m = matrix.size
  val n = matrix[0].size
  var firstRowZero = false
  var firstColZero = false

  // Check if first row needs to be zeroed
  for (j in 0 until n) {
    if (matrix[0][j] == 0) {
      firstRowZero = true
      break
    }
  }

  // Check if first column needs to be zeroed
  for (i in 0 until m) {
    if (matrix[i][0] == 0) {
      firstColZero = true
      break
    }
  }

  // Use first row and column as markers
  for (i in 1 until m) {
    for (j in 1 until n) {
      if (matrix[i][j] == 0) {
        matrix[i][0] = 0  // Mark corresponding row
        matrix[0][j] = 0  // Mark corresponding column
      }
    }
  }

  // Zero out cells based on markers in the first row and column
  for (i in 1 until m) {
    for (j in 1 until n) {
      if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        matrix[i][j] = 0
      }
    }
  }

  // Zero out the first row if needed
  if (firstRowZero) {
    for (j in 0 until n) {
      matrix[0][j] = 0
    }
  }

  // Zero out the first column if needed
  if (firstColZero) {
    for (i in 0 until m) {
      matrix[i][0] = 0
    }
  }
}

fun setZeroesFunctional(matrix: Array<IntArray>) {
  val m = matrix.size
  val n = matrix[0].size

  val firstRowZero = matrix[0].any { it == 0 }
  val firstColZero = matrix.any { it[0] == 0 }

  // Mark zeros in first row and column
  markZeros(matrix)

  // Set zeros based on markers
  setZerosBasedOnMarkers(matrix)

  // Handle first row and column separately
  if (firstRowZero) zeroRow(matrix, 0)
  if (firstColZero) zeroColumn(matrix, 0)
}

fun markZeros(matrix: Array<IntArray>) {
  val m = matrix.size
  val n = matrix[0].size

  for (i in 1 until m) {
    for (j in 1 until n) {
      if (matrix[i][j] == 0) {
        matrix[i][0] = 0  // Mark row
        matrix[0][j] = 0  // Mark column
      }
    }
  }
}

fun setZerosBasedOnMarkers(matrix: Array<IntArray>) {
  val m = matrix.size
  val n = matrix[0].size

  for (i in 1 until m) {
    for (j in 1 until n) {
      if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        matrix[i][j] = 0
      }
    }
  }
}

fun zeroRow(matrix: Array<IntArray>, row: Int) {
  for (j in matrix[row].indices) {
    matrix[row][j] = 0
  }
}

fun zeroColumn(matrix: Array<IntArray>, col: Int) {
  for (i in matrix.indices) {
    matrix[i][col] = 0
  }
}

fun main() {
  testSetZeroes(::setZeroesBruteForce)
  testSetZeroes(::setZeroesOptimized)
  testSetZeroes(::setZeroesFunctional)
}

fun testSetZeroes(setZeroesFunc: (Array<IntArray>) -> Unit) {
  val testCases = listOf(
    // Test case 1
    Pair(
      arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)
      ),
      arrayOf(
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 0),
        intArrayOf(1, 0, 1)
      )
    ),
    // Test case 2
    Pair(
      arrayOf(
        intArrayOf(0, 1, 2, 0),
        intArrayOf(3, 4, 5, 2),
        intArrayOf(1, 3, 1, 5)
      ),
      arrayOf(
        intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 4, 5, 0),
        intArrayOf(0, 3, 1, 0)
      )
    ),
    // Test case 3 (No zeros)
    Pair(
      arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
      ),
      arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
      )
    ),
    // Test case 4 (All zeros)
    Pair(
      arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 0)
      ),
      arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 0)
      )
    ),
    // Test case 5 (Zeros in first row and column)
    Pair(
      arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 0)
      ),
      arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 4, 0),
        intArrayOf(0, 0, 0)
      )
    )
  )

  for ((index, testCase) in testCases.withIndex()) {
    val (inputMatrix, expectedMatrix) = testCase
    val inputCopy = inputMatrix.map { it.clone() }.toTypedArray()
    setZeroesFunc(inputCopy)
    assert(
      matricesAreEqual(inputCopy, expectedMatrix)
    ) {
      "Test case ${index + 1} failed.\n" +
        "Input:\n${matrixToString(inputMatrix)}\n" +
        "Expected:\n${matrixToString(expectedMatrix)}\n" +
        "Got:\n${matrixToString(inputCopy)}"
    }
  }
  println("${setZeroesFunc.javaClass.name} passed all test cases.")
}

fun matricesAreEqual(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Boolean {
  if (matrix1.size != matrix2.size) return false
  for (i in matrix1.indices) {
    if (!matrix1[i].contentEquals(matrix2[i])) return false
  }
  return true
}

fun matrixToString(matrix: Array<IntArray>): String {
  return matrix.joinToString(separator = "\n") { row ->
    row.joinToString(prefix = "[", postfix = "]", separator = ", ")
  }
}