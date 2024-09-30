package problems

class ThreeSumBruteForce {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val result = mutableSetOf<List<Int>>()
        // Iterate over all possible triplets
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                for (k in j + 1 until n) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Sort the triplet to handle duplicates
                        val triplet = listOf(nums[i], nums[j], nums[k]).sorted()
                        result.add(triplet)
                    }
                }
            }
        }
        return result.toList()
    }
}

class ThreeSumEfficient {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort() // Sort the array to use two-pointer technique
        val n = nums.size

        for (i in 0 until n - 2) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = n - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--
                        // Skip duplicates for the second number
                        while (left < right && nums[left] == nums[left - 1]) left++
                        // Skip duplicates for the third number
                        while (left < right && nums[right] == nums[right + 1]) right--
                    }
                    sum < 0 -> left++
                    else -> right--
                }
            }
        }

        return result
    }
}

class ThreeSumFunctional {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()

        return nums.sorted().let { sorted ->
            (0..sorted.lastIndex - 2).asSequence()
                .filter { i -> i == 0 || sorted[i] != sorted[i - 1] }
                .flatMap { i -> findPairs(sorted, i) }
                .toList()
        }
    }

    private fun findPairs(nums: List<Int>, i: Int): Sequence<List<Int>> = sequence {
        var left = i + 1
        var right = nums.lastIndex
        val target = -nums[i]

        while (left < right) {
            val sum = nums[left] + nums[right]
            when {
                sum == target -> {
                    yield(listOf(nums[i], nums[left], nums[right]))
                    do { left++ } while (left < right && nums[left] == nums[left - 1])
                    do { right-- } while (left < right && nums[right] == nums[right + 1])
                }
                sum < target -> left++
                else -> right--
            }
        }
    }
}


fun main() {
    val solution = ThreeSumEfficient()

    // Test case 1
    val nums1 = intArrayOf(-1, 0, 1, 2, -1, -4)
    val expected1 = setOf(listOf(-1, -1, 2), listOf(-1, 0, 1))
    assert(solution.threeSum(nums1).toSet() == expected1) { "Test case 1 failed" }

    // Test case 2
    val nums2 = intArrayOf()
    val expected2 = emptySet<List<Int>>()
    assert(solution.threeSum(nums2).toSet() == expected2) { "Test case 2 failed" }

    // Test case 3
    val nums3 = intArrayOf(0)
    val expected3 = emptySet<List<Int>>()
    assert(solution.threeSum(nums3).toSet() == expected3) { "Test case 3 failed" }

    // Test case 4 (All zeros)
    val nums4 = intArrayOf(0, 0, 0, 0)
    val expected4 = setOf(listOf(0, 0, 0))
    assert(solution.threeSum(nums4).toSet() == expected4) { "Test case 4 failed" }

    // Test case 5 (No triplet sums to zero)
    val nums5 = intArrayOf(1, 2, 3, 4, 5)
    val expected5 = emptySet<List<Int>>()
    assert(solution.threeSum(nums5).toSet() == expected5) { "Test case 5 failed" }

    // Test case 6 (Multiple duplicates)
    val nums6 = intArrayOf(-2, -2, 0, 0, 2, 2)
    val expected6 = setOf(listOf(-2, 0, 2))
    assert(solution.threeSum(nums6).toSet() == expected6) { "Test case 6 failed" }

    println("All enhanced functional solution test cases passed.")
}