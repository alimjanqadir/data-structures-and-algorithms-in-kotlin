package problems

/**
 * LeetCode: Count Subarrays Where Max Element Appears at Least K Times
 * https://leetcode.com/problems/count-subarrays-where-maximum-element-appears-at-least-k-times/
 *
 * Returns the number of subarrays where the global maximum appears at least k times.
 *
 * @param nums The input array
 * @param k The minimum number of times the maximum must appear
 * @return The number of qualifying subarrays
 *
 * Note: Function name is unique and top-level per project rules.
 */
fun countSubarraysWhereMaxElementAppearsAtLeastKTimes(nums: IntArray, k: Int): Long {
    val maxValue = nums.maxOrNull()!!               // global maximum M
    val maxPositions = ArrayDeque<Int>()            // indices where nums[i] == M
    var qualifiedCount = 0L

    for (currentIndex in nums.indices) {
        if (nums[currentIndex] == maxValue) {
            maxPositions.addLast(currentIndex)
        }

        if (maxPositions.size >= k) {
            val kthLatestIndex = maxPositions[maxPositions.size - k]
            qualifiedCount += (kthLatestIndex + 1)  // all starts 0..kthLatestIndex
        }
    }
    return qualifiedCount
}
