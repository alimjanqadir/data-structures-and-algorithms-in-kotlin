package problems

/**
 * Solution for LeetCode problem "Maximum Number of Alloys"
 * https://leetcode.com/problems/maximum-number-of-alloys/
 */
fun maxPower(stations: IntArray, r: Int, k: Int): Long {
    val n = stations.size
    val pre = LongArray(n + 1)
    for (i in 0 until n) {
        pre[i + 1] = pre[i] + stations[i].toLong()
    }
    val power = LongArray(n)
    for (i in 0 until n) {
        val left = maxOf(0, i - r)
        val right = minOf(n, i + r + 1)
        power[i] = pre[right] - pre[left]
    }
    var low: Long = 0
    var high: Long = pre[n] + k.toLong()
    var ans: Long = 0
    while (low <= high) {
        val mid = low + (high - low) / 2
        if (canAchieve(power, r, k.toLong(), mid, n)) {
            ans = mid
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return ans
}

private fun canAchieve(power: LongArray, r: Int, kk: Long, mid: Long, n: Int): Boolean {
    val diff = LongArray(n)
    var curBoost: Long = 0
    var added: Long = 0
    for (i in 0 until n) {
        curBoost += diff[i]
        val need = mid - power[i] - curBoost
        if (need > 0) {
            added += need
            if (added > kk) return false
            val y = minOf(i + r, n - 1)
            val L = maxOf(0, y - r)
            val R = minOf(n - 1, y + r)
            diff[L] += need
            if (R + 1 < n) {
                diff[R + 1] -= need
            }
            curBoost += need
        }
    }
    return true
}
