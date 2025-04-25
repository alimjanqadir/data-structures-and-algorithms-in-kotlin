// LeetCode - Count Subarrays With Fixed Bounds
// Solution must be a top-level function per user rules

fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
    var lastSentinel = -1        // a[i] < minK || a[i] > maxK
    var lastMin      = -1        // last index where a[i] == minK
    var lastMax      = -1        // last index where a[i] == maxK
    var total: Long  = 0

    for (index in nums.indices) {
        val value = nums[index]

        if (value < minK || value > maxK) lastSentinel = index
        if (value == minK) lastMin = index
        if (value == maxK) lastMax = index

        val earliestBound = minOf(lastMin, lastMax)
        if (earliestBound > lastSentinel) {
            total += (earliestBound - lastSentinel).toLong()
        }
    }
    return total
}
