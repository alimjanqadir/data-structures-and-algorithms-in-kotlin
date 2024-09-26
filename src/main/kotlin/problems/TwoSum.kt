package problems

/**
 * Finds two numbers such that they add up to a specific target number using brute force.
 *
 * @param numbers An array of integers sorted in non-decreasing order.
 * @param target The target sum.
 * @return An array containing the 1-based indices of the two numbers.
 */
fun twoSumBruteForce(numbers: IntArray, target: Int): IntArray {
    val n = numbers.size
    // Iterate through each element except the last one
    for (i in 0 until n - 1) {
        // Iterate from the next element to the end
        for (j in i + 1 until n) {
            // Check if the sum equals the target
            if (numbers[i] + numbers[j] == target) {
                // Return 1-based indices
                return intArrayOf(i + 1, j + 1)
            }
        }
    }
    // If no pair is found, return an empty array
    return intArrayOf()
}

/**
 * Finds two numbers using the two-pointer technique.
 *
 * @param numbers An array of integers sorted in non-decreasing order.
 * @param target The target sum.
 * @return An array containing the 1-based indices of the two numbers.
 */
fun twoSumTwoPointers(numbers: IntArray, target: Int): IntArray {
    // Initialize pointers at the start and end of the array
    var left = 0
    var right = numbers.size - 1

    // Loop until the pointers meet
    while (left < right) {
        val currentSum = numbers[left] + numbers[right]
        // If the current sum matches the target, return the indices
        if (currentSum == target) {
            return intArrayOf(left + 1, right + 1)
        }
        // If current sum is less than target, move the left pointer to the right
        if (currentSum < target) {
            left++
        } else {
            // If current sum is greater than target, move the right pointer to the left
            right--
        }
    }
    // Return an empty array if no solution is found
    return intArrayOf()
}

/**
 * Finds two numbers using functional programming concepts.
 *
 * @param numbers An array of integers sorted in non-decreasing order.
 * @param target The target sum.
 * @return An array containing the 1-based indices of the two numbers.
 */
fun twoSumFunctional(numbers: IntArray, target: Int): IntArray {
    // Recursive inner function to maintain immutability
    tailrec fun search(left: Int, right: Int): IntArray {
        // Base case: pointers have crossed
        if (left >= right) return intArrayOf()
        val currentSum = numbers[left] + numbers[right]
        return when {
            currentSum == target -> intArrayOf(left + 1, right + 1)
            currentSum < target -> search(left + 1, right)
            else -> search(left, right - 1)
        }
    }
    // Start the recursive search
    return search(0, numbers.size - 1)
}

fun main() {
    // Brute Force Tests
    assert(twoSumBruteForce(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(1, 2))) { "Test case 1 failed" }
    assert(twoSumBruteForce(intArrayOf(2, 3, 4), 6).contentEquals(intArrayOf(1, 3))) { "Test case 2 failed" }
    assert(twoSumBruteForce(intArrayOf(-1, 0), -1).contentEquals(intArrayOf(1, 2))) { "Test case 3 failed" }

    // Two-Pointer Tests
    assert(twoSumTwoPointers(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(1, 2))) { "Test case 1 failed" }
    assert(twoSumTwoPointers(intArrayOf(2, 3, 4), 6).contentEquals(intArrayOf(1, 3))) { "Test case 2 failed" }
    assert(twoSumTwoPointers(intArrayOf(-1, 0), -1).contentEquals(intArrayOf(1, 2))) { "Test case 3 failed" }

    // Functional Composition Tests
    assert(twoSumFunctional(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(1, 2))) { "Test case 1 failed" }
    assert(twoSumFunctional(intArrayOf(2, 3, 4), 6).contentEquals(intArrayOf(1, 3))) { "Test case 2 failed" }
    assert(twoSumFunctional(intArrayOf(-1, 0), -1).contentEquals(intArrayOf(1, 2))) { "Test case 3 failed" }

    println("All test cases passed!")
}