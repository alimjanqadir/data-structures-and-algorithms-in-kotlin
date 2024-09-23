package problems

fun maxScoreSightseeingPair(values: IntArray): Int {
    var maxScore = Int.MIN_VALUE // Initialize maxScore to the smallest possible integer
    var maxI = values[0] + 0     // Initialize maxI as values[0] + 0

    // Loop through the array starting from the second element
    for (j in 1 until values.size) {
        // Calculate the current score with the best i so far and the current j
        // The formula is (values[i] + i) + (values[j] - j)
        val currentScore = maxI + values[j] - j
        // Update maxScore if the currentScore is greater
        maxScore = maxOf(maxScore, currentScore)
        // Update maxI to be the maximum of itself and the new values[j] + j
        maxI = maxOf(maxI, values[j] + j)
    }

    return maxScore // Return the maximum score found
}

fun maxScoreSightseeingPairFunctional(values: IntArray): Int {
    // Pair of (maxI, maxScore), starting with values[0] + 0 and Int.MIN_VALUE
    return values.withIndex().drop(1).fold(
        Pair(values[0] + 0, Int.MIN_VALUE)
    ) { (maxI, maxScore), (j, vj) ->
        // Calculate current score using the accumulated maxI
        val currentScore = maxI + vj - j
        // Update maxI and maxScore
        val newMaxI = maxOf(maxI, vj + j)
        val newMaxScore = maxOf(maxScore, currentScore)
        Pair(newMaxI, newMaxScore) // Return the updated pair
    }.second // Extract the maxScore from the final pair
}

fun main() {
    // Example 1:
    // Input: [8, 1, 5, 2, 6]
    // Expected Output: 11
    println("=== Example 1 ===")
    val values1 = intArrayOf(8, 1, 5, 2, 6)
    println("Input: ${values1.joinToString(", ")}")
    val result1 = maxScoreSightseeingPair(values1)
    println("Output: $result1") // Expected: 11
    println()
    // Example 2:
    // Input: [1, 2]
    // Expected Output: 2
    println("=== Example 2 ===")
    val values2 = intArrayOf(1, 2)
    println("Input: ${values2.joinToString(", ")}")
    val result2 = maxScoreSightseeingPair(values2)
    println("Output: $result2") // Expected: 2
    println()
    // Example 3:
    // Input: [5, 3, 7, 7, 6]
    // Expected Output: 13
    println("=== Example 3 ===")
    val values3 = intArrayOf(5, 3, 7, 7, 6)
    println("Input: ${values3.joinToString(", ")}")
    val result3 = maxScoreSightseeingPair(values3)
    println("Output: $result3") // Expected: 13
    println()
}