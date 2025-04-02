package problems

/**
 * Problem 2873. Maximum Value of an Ordered Triplet I
 * Given an integer array nums, find the maximum value of (nums[i] - nums[j]) * nums[k]
 * for all triplets (i, j, k) such that i < j < k.
 * If all triplets have negative values, return 0.
 */
fun maximumTripletValue(nums: IntArray): Long {
    var maxDiff = 0L
    var maxProduct = 0L
    var maxNum = 0L
    
    for (num in nums) {
        maxProduct = maxOf(maxProduct, maxDiff * num)
        maxDiff = maxOf(maxDiff, maxNum - num)
        maxNum = maxOf(maxNum, num.toLong())
    }
    
    return maxProduct
}
