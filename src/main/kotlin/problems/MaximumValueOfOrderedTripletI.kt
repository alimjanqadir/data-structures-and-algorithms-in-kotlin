package problems

/**
 * Problem 2873. Maximum Value of an Ordered Triplet I
 * Given an integer array nums, find the maximum value of (nums[i] - nums[j]) * nums[k]
 * for all triplets (i, j, k) such that i < j < k.
 * If all triplets have negative values, return 0.
 */
fun maximumTripletValue(nums: IntArray): Long {
    if (nums.size < 3) return 0L

    var maxValBeforeJ = nums[0].toLong()
    var maxDiff = 0L
    var maxResult = 0L

    for (k in 1 until nums.size) {
        val currentNum = nums[k].toLong()

        // Use previously computed maxDiff (nums[i] - nums[j]) to calculate triplet value
        maxResult = maxOf(maxResult, maxDiff * currentNum)

        // Update maxDiff using the current value as nums[j]
        maxDiff = maxOf(maxDiff, maxValBeforeJ - currentNum)

        // Update maxValBeforeJ to be used in future iterations
        maxValBeforeJ = maxOf(maxValBeforeJ, currentNum)
    }

    return maxResult
}
