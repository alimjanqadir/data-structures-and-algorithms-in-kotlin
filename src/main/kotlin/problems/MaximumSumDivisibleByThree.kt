package problems

fun maxSumDivThree(nums: IntArray): Int {
    // dp[i] represents the maximum sum where sum % 3 == i
    var dp = intArrayOf(0, Int.MIN_VALUE, Int.MIN_VALUE)

    for (x in nums) {
        val mod = x % 3
        // Make a copy of previous dp to avoid using same number multiple times
        val prev = dp.copyOf()

        when (mod) {
            0 -> {
                // Adding x to any sum keeps the same remainder
                dp[0] = maxOf(dp[0], prev[0] + x)
                dp[1] = maxOf(dp[1], prev[1] + x)
                dp[2] = maxOf(dp[2], prev[2] + x)
            }
            1 -> {
                // Remainder 0 + 1 → 1
                // Remainder 1 + 1 → 2
                // Remainder 2 + 1 → 0 (2+1=3≡0)
                dp[0] = maxOf(dp[0], prev[2] + x)
                dp[1] = maxOf(dp[1], prev[0] + x)
                dp[2] = maxOf(dp[2], prev[1] + x)
            }
            2 -> {
                // Remainder 0 + 2 → 2
                // Remainder 1 + 2 → 0 (1+2=3≡0)
                // Remainder 2 + 2 → 1 (2+2=4≡1)
                dp[0] = maxOf(dp[0], prev[1] + x)
                dp[1] = maxOf(dp[1], prev[2] + x)
                dp[2] = maxOf(dp[2], prev[0] + x)
            }
        }
    }
    return dp[0]
}
