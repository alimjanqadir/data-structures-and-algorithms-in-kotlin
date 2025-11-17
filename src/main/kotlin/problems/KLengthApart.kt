package problems

fun kLengthApart(nums: IntArray, k: Int): Boolean {
    var lastOne = -1 - k  // 初始值确保第一个1总是合法
    for (i in nums.indices) {
        if (nums[i] == 1) {
            if (i - lastOne <= k) {
                return false
            }
            lastOne = i
        }
    }
    return true
}
