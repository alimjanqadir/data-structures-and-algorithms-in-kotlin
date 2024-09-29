package problems

fun maxAreaBruteForce(height: IntArray): Int {
    var maxArea = 0
    val n = height.size
    // Iterate over all possible pairs of lines
    for (i in 0 until n - 1) {
        for (j in i + 1 until n) {
            // Calculate the area formed by lines at i and j
            val area = minOf(height[i], height[j]) * (j - i)
            // Update maxArea if the current area is larger
            if (area > maxArea) {
                maxArea = area
            }
        }
    }
    return maxArea
}

fun maxAreaOptimized(height: IntArray): Int {
    var maxArea = 0
    var left = 0                // Left pointer starting at the beginning
    var right = height.lastIndex  // Right pointer starting at the end

    // Loop until the two pointers meet
    while (left < right) {
        // Calculate the width between the two lines
        val width = right - left
        // Determine the limiting height (shorter line)
        val minHeight = minOf(height[left], height[right])
        // Calculate the current area
        val currentArea = minHeight * width
        // Update maxArea if the current area is larger
        if (currentArea > maxArea) {
            maxArea = currentArea
        }
        // Move the pointer pointing to the shorter line inward
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxArea
}

fun maxAreaFunctional(height: IntArray): Int {
    /**
     * Tail-recursive helper function to compute maximum area.
     *
     * @param leftIndex The current left pointer.
     * @param rightIndex The current right pointer.
     * @param currentMaxArea The maximum area found so far.
     * @return The maximum area after evaluating all possible pairs.
     */
    tailrec fun computeMaxArea(leftIndex: Int, rightIndex: Int, currentMaxArea: Int): Int {
        // Termination condition: pointers have met or crossed
        if (leftIndex >= rightIndex) {
            return currentMaxArea
        }

        // Calculate current area
        val width = rightIndex - leftIndex
        val minHeight = minOf(height[leftIndex], height[rightIndex])
        val currentArea = minHeight * width
        val newMaxArea = maxOf(currentMaxArea, currentArea)

        // Decide which pointer to move
        return if (height[leftIndex] < height[rightIndex]) {
            // Move the left pointer inward
            computeMaxArea(leftIndex + 1, rightIndex, newMaxArea)
        } else {
            // Move the right pointer inward
            computeMaxArea(leftIndex, rightIndex - 1, newMaxArea)
        }
    }

    // Initial call to the helper function with starting pointers and initial maxArea
    return computeMaxArea(0, height.lastIndex, 0)
}

fun main() {
    // List of test cases
    val testCases = listOf(
        intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7) to 49,
        intArrayOf(1, 1) to 1,
        intArrayOf(4, 3, 2, 1, 4) to 16,
        intArrayOf(1, 2, 1) to 2,
        intArrayOf(2, 3, 4, 5, 18, 17, 6) to 17,
        IntArray(100000) { 10000 } to 999990000
    )

    // List of functions to test
    val functions = listOf(
        ::maxAreaBruteForce,
        ::maxAreaOptimized,
        ::maxAreaFunctional
    )

    // Run test cases for each function
    for ((index, function) in functions.withIndex()) {
        println("Testing function ${index + 1}")
        for ((input, expected) in testCases) {
            val output = function(input)
            assert(output == expected) {
                "Test failed for input ${input.joinToString(limit = 10)}: Expected $expected, got $output"
            }
        }
        println("All tests passed for function ${index + 1}\n")
    }
}