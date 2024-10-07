package problems

fun spiralOrder(matrix: List<List<Int>>): List<Int> {
    val result = mutableListOf<Int>()
    if (matrix.isEmpty()) return result

    var top = 0
    var bottom = matrix.size - 1
    var left = 0
    var right = matrix[0].size - 1

    while (top <= bottom && left <= right) {
        // Traverse from Left to Right
        for (i in left..right) {
            result.add(matrix[top][i])
        }
        top++

        // Traverse from Top to Bottom
        for (i in top..bottom) {
            result.add(matrix[i][right])
        }
        right--

        // Traverse from Right to Left
        if (top <= bottom) {
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom--
        }

        // Traverse from Bottom to Top
        if (left <= right) {
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }
    }

    return result
}

fun spiralOrderFunctional(matrix: List<List<Int>>): List<Int> {
    if (matrix.isEmpty()) return emptyList()

    val topRow = matrix.first()
    val rest = matrix.drop(1)

    if (rest.isEmpty()) return topRow

    val rotatedRest = rotateCounterClockwise(rest)
    return topRow + spiralOrderFunctional(rotatedRest)
}

fun rotateCounterClockwise(matrix: List<List<Int>>): List<List<Int>> {
    val numRows = matrix.size
    val numCols = matrix[0].size
    val rotated = MutableList(numCols) { MutableList<Int>(numRows) { 0 } }

    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            rotated[numCols - j - 1][i] = matrix[i][j]
        }
    }
    return rotated
}

fun main() {
    val testCases = listOf(
        listOf(listOf(1)) to listOf(1),
        listOf(listOf(1, 2, 3)) to listOf(1, 2, 3),
        listOf(listOf(1), listOf(2), listOf(3)) to listOf(1, 2, 3),
        listOf(listOf(1, 2), listOf(3, 4)) to listOf(1, 2, 4, 3),
        listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9)) to listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
        listOf(listOf(1, 2, 3, 4), listOf(5, 6, 7, 8), listOf(9, 10, 11, 12)) to listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
    )

    for ((input, expected) in testCases) {
        val outputBruteForce = spiralOrder(input)
        val outputFunctional = spiralOrderFunctional(input)

        assert(outputBruteForce == expected) { "Brute Force Failed on input $input" }
        assert(outputFunctional == expected) { "Functional Failed on input $input" }
    }
    println("All tests passed.")
}