import java.util.*

fun largestDivisibleSubset(nums: IntArray): List<Int> {
    val n = nums.size
    // Handle empty input edge case
    if (n == 0) {
        return emptyList()
    }

    // 1. Sort the array
    // Sorting allows us to only check nums[i] % nums[j] for j < i
    nums.sort()

    // 2. Initialize DP arrays
    // dp[i] = size of the largest divisible subset ending with nums[i]
    val dp = IntArray(n) { 1 }
    // prevIndex[i] = index of the element preceding nums[i] in the LDS ending at i
    val prevIndex = IntArray(n) { -1 } // Use -1 to indicate no predecessor

    // Variables to track the overall maximum size and the index of its last element
    var maxSize = 1
    var maxIndex = 0

    // 3. Fill DP table
    for (i in nums.indices) { // Iterate through each element as the potential end of a subset
        for (j in 0 until i) { // Check previous elements
            // If nums[i] is divisible by nums[j]...
            if (nums[i] % nums[j] == 0) {
                // ...and extending the subset ending at j gives a larger subset for i...
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1 // Update the size
                    prevIndex[i] = j    // Record the predecessor index
                }
            }
        }
        // Update the overall maximum size and index if dp[i] is larger
        if (dp[i] > maxSize) {
            maxSize = dp[i]
            maxIndex = i
        }
    }

    // 4. Reconstruct the largest divisible subset
    val result = mutableListOf<Int>()
    var currentIndex = maxIndex
    while (currentIndex != -1) {
        result.add(nums[currentIndex])
        currentIndex = prevIndex[currentIndex] // Move to the predecessor
    }

    // 5. The result is currently in reverse order (largest to smallest)
    // Reverse it to get ascending order (idiomatic but not strictly required by problem)
    // result.reverse() // In-place reverse using java.util.Collections helper
    return result.reversed() // Kotlin idiomatic way to get a reversed list copy
}
