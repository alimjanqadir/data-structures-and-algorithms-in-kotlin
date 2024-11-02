package problems

class MergeSortedArray {
  fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    // Start from the end of the filled portion of nums1
    var i = m - 1
    // Start from the end of nums2
    var j = n - 1
    // Start filling from the end of nums1
    var k = m + n - 1

    // Merge in reverse order
    while (j >= 0) {
      // If nums1 has elements left and its current element is larger
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--]
      } else {
        // Either nums1 is exhausted or nums2's current element is larger
        nums1[k--] = nums2[j--]
      }
    }
    // No need to handle remaining elements in nums1, they're already in place
  }
}
