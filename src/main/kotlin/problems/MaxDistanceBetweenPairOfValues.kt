package problems

/**
 * 1855. Maximum Distance Between a Pair of Values
 *
 * Given two non-increasing arrays nums1 and nums2, find the maximum distance j - i
 * such that i <= j and nums1[i] <= nums2[j].
 *
 * Uses binary search for each i to find the furthest j where nums2[j] >= nums1[i].
 *
 * Time Complexity: O(n * log m) where n and m are the lengths of the input arrays
 * Space Complexity: O(1)
 */
fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
    var maximumDistance = 0

    for (i in nums1.indices) {
        var left = i
        var right = nums2.size - 1
        var bestJ = -1

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums2[mid] >= nums1[i]) {
                bestJ = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        if (bestJ != -1) {
            val currentDistance = bestJ - i
            if (currentDistance > maximumDistance) {
                maximumDistance = currentDistance
            }
        }
    }

    return maximumDistance
}
