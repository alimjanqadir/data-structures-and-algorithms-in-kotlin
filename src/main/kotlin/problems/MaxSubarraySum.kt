package problems

/**
 * Finds the maximum subarray sum where the subarray length is a multiple of k.
 * 
 * @param nums The input array of integers
 * @param k The integer k which the subarray length must be a multiple of
 * @return The maximum sum of a subarray with length divisible by k
 */
fun maxSubarraySum(nums: IntArray, k: Int): Long {
    val n = nums.size
    var ans = Long.MIN_VALUE
    var currentSum = 0L
    
    // minPrefix[r] = minimum prefix sum seen at index i where i % k == r
    val minPrefix = LongArray(k) { Long.MAX_VALUE }
    
    for (i in 0 until n) {
        currentSum += nums[i]
        val rem = i % k
        
        // Case 1: subarray ending at i, starting from some previous j where j % k == rem
        if (minPrefix[rem] != Long.MAX_VALUE) {
            ans = maxOf(ans, currentSum - minPrefix[rem])
        }
        
        // Case 2: the whole prefix [0..i] has length (i+1) divisible by k
        if ((i + 1) % k == 0) {
            ans = maxOf(ans, currentSum)
        }
        
        // Update the minimum prefix for this remainder
        minPrefix[rem] = minOf(minPrefix[rem], currentSum)
    }
    
    return ans
}
