// Brute Force Solution - O(n²)
fun containsNearbyDuplicateBrute(nums: IntArray, k: Int): Boolean {
    for (i in nums.indices) {
        for (j in i + 1..minOf(i + k, nums.lastIndex)) {
            if (nums[i] == nums[j]) return true
        }
    }
    return false
}

// Optimized Solution using Sliding Window with HashSet - O(n)
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val window = HashSet<Int>()

    for (i in nums.indices) {
        if (i > k) window.remove(nums[i - k - 1])
        if (!window.add(nums[i])) return true
    }
    return false
}

// Functional Solution using windowed
fun containsNearbyDuplicateFunctional(nums: IntArray, k: Int): Boolean {
    return nums.withIndex()
        .groupBy { it.value }
        .any { (_, indices) ->
            indices.windowed(2)
                .any { (a, b) -> b.index - a.index <= k }
        }
}

fun main() {
    println("Contains Duplicate II - Implementation Comparison")
    println("==============================================")

    val testCases = listOf(
        intArrayOf(1, 2, 3, 1) to 3,           // true
        intArrayOf(1, 0, 1, 1) to 1,           // true
        intArrayOf(1, 2, 3, 1, 2, 3) to 2,     // false
        intArrayOf(1) to 1,                     // false
        intArrayOf(1, 1) to 0                   // false
    )

    testCases.forEachIndexed { index, (nums, k) ->
        println("\nTest ${index + 1}: ${nums.toList()}, k = $k")

        val bruteForceSolution = containsNearbyDuplicateBrute(nums, k)
        val optimizedSolution = containsNearbyDuplicate(nums, k)
        val functionalSolution = containsNearbyDuplicateFunctional(nums, k)

        println("Brute Force: $bruteForceSolution")
        println("Optimized:   $optimizedSolution")
        println("Functional:  $functionalSolution")

        if (bruteForceSolution == optimizedSolution && optimizedSolution == functionalSolution) {
            println("✓ All implementations match")
        } else {
            println("✗ WARNING: Implementations give different results!")
        }
    }
}