package problems

fun findRotation(mat: Array<IntArray>, target: Array<IntArray>): Boolean {
    var currentMatrix = mat

    repeat(4) {
        if (areMatricesEqual(currentMatrix, target)) {
            return true
        }
        currentMatrix = rotate90Clockwise(currentMatrix)
    }

    return false
}

private fun rotate90Clockwise(matrix: Array<IntArray>): Array<IntArray> {
    val size = matrix.size
    val rotatedMatrix = Array(size) { IntArray(size) }

    for (row in 0 until size) {
        for (col in 0 until size) {
            rotatedMatrix[col][size - 1 - row] = matrix[row][col]
        }
    }

    return rotatedMatrix
}

private fun areMatricesEqual(first: Array<IntArray>, second: Array<IntArray>): Boolean {
    val size = first.size

    for (row in 0 until size) {
        for (col in 0 until size) {
            if (first[row][col] != second[row][col]) {
                return false
            }
        }
    }

    return true
}
