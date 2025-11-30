package problems

class MinimumOperationsToMakeArraySumDivisibleByP {
    fun minSubarray(nums: IntArray, p: Int): Int {
        val n = nums.size
        var sum = 0L
        for (x in nums) sum += x
        val r = (sum % p).toInt()
        if (r == 0) return 0

        val lastSeen = mutableMapOf<Int, Int>()
        lastSeen[0] = -1

        var prefix = 0L
        var ans = n

        for (i in nums.indices) {
            prefix += nums[i]
            val curMod = (prefix % p).toInt()

            val need = (curMod - r + p) % p

            if (lastSeen.containsKey(need)) {
                ans = minOf(ans, i - lastSeen[need]!!)
            }

            // 关键：每次都更新为当前最新位置（覆盖旧的）
            lastSeen[curMod] = i
        }

        return if (ans == n) -1 else ans
    }
}
