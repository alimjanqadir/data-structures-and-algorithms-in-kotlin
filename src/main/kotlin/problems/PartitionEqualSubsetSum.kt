package problems

fun canPartition(nums: IntArray): Boolean {
    val total = nums.sum()
    if (total % 2 != 0) return false
    val target = total / 2

    val dp = BooleanArray(target + 1)
    dp[0] = true

    for (num in nums) {
        for (sum in target downTo num) {
            dp[sum] = dp[sum] || dp[sum - num]
        }
    }

    return dp[target]
}
