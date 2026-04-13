package problems

/**
 * 1848. Minimum Distance to the Target Element
 *
 * Given an integer array nums (0-indexed) and two integers target and start,
 * find an index i such that nums[i] == target and abs(i - start) is minimized.
 * Note that abs(x) is the absolute value of x.
 *
 * Return abs(i - start).
 *
 * It is guaranteed that target exists in nums.
 *
 * Time Complexity: O(n) where n is the size of the array
 * Space Complexity: O(1)
 *
 * @param nums The integer array to search
 * @param target The target value to find
 * @param start The starting index to calculate distance from
 * @return The minimum distance from start to any occurrence of target
 */
fun getMinDistance(nums: IntArray, target: Int, start: Int): Int {
    var minimumDistance = Int.MAX_VALUE

    for (currentIndex in nums.indices) {
        if (nums[currentIndex] == target) {
            val distanceFromStart = kotlin.math.abs(currentIndex - start)
            minimumDistance = minOf(minimumDistance, distanceFromStart)
        }
    }

    return minimumDistance
}
