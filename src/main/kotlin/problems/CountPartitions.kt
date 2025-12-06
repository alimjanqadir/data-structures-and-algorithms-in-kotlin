package problems

fun countPartitions(nums: IntArray, k: Int): Int {
    val n = nums.size
    val MOD = 1_000_000_000 + 7

    // DP[i]: The number of ways to partition nums[0...i-1]
    // Size n+1 for indices 0 to n
    val dp = IntArray(n + 1)
    // Prefix Sum of DP: S[i] = DP[0] + ... + DP[i]
    val s = IntArray(n + 1)

    // Base case: DP[0] = 1 (one way to partition an empty array)
    dp[0] = 1
    s[0] = 1

    // Deques for monotonic sliding window to track max and min indices
    // maxDeque stores indices of decreasing values (largest element is at front)
    val maxDeque = ArrayDeque<Int>()
    // minDeque stores indices of increasing values (smallest element is at front)
    val minDeque = ArrayDeque<Int>()

    // start_index is the smallest index such that nums[start_index...i-1] is a valid segment
    var start_index = 0

    for (i in 1..n) {
        val current_index = i - 1
        val current_value = nums[current_index]

        // 1. Maintain Monotonic Deques by adding the new element's index
        // Update maxDeque
        while (maxDeque.isNotEmpty() && nums[maxDeque.last()] <= current_value) {
            maxDeque.removeLast()
        }
        maxDeque.addLast(current_index)

        // Update minDeque
        while (minDeque.isNotEmpty() && nums[minDeque.last()] >= current_value) {
            minDeque.removeLast()
        }
        minDeque.addLast(current_index)

        // 2. Shrink the window from the left (increase start_index)
        // until the max-min difference is at most k
        while (maxDeque.isNotEmpty() && minDeque.isNotEmpty()) {
            val maxVal = nums[maxDeque.first()]
            val minVal = nums[minDeque.first()]
            
            if (maxVal - minVal > k) {
                // Current window is invalid. Move start_index to shrink the window.
                start_index++
                
                // Remove elements that are now outside the window [start_index, current_index]
                if (maxDeque.first() < start_index) {
                    maxDeque.removeFirst()
                }
                if (minDeque.first() < start_index) {
                    minDeque.removeFirst()
                }
            } else {
                // Window is valid. The current start_index is the minimal one. Stop shrinking.
                break
            }
        }
        
        // At this point, all segments nums[j...i-1] where start_index <= j <= i-1 are valid.
        // The transition is DP[i] = sum(DP[j]) for j from start_index to i-1.
        
        // Sum = S[i-1] - S[start_index - 1]
        val sum_before_i_minus_1 = if (i - 1 >= 0) s[i - 1] else 0
        val sum_before_start_index_minus_1 = if (start_index - 1 >= 0) s[start_index - 1] else 0

        var current_dp = sum_before_i_minus_1 - sum_before_start_index_minus_1
        
        // Handle negative result from subtraction in modulo arithmetic
        if (current_dp < 0) {
            current_dp += MOD
        }

        dp[i] = current_dp
        
        // Update the prefix sum array S[i] = S[i-1] + DP[i]
        s[i] = (s[i - 1] + dp[i]) % MOD
    }

    return dp[n]
}
