package problems

class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        println("m: $m")
        println("n: $n")
        // Pointers initialization
        var p1 = m - 1 // Pointer for the last element in the initial part of nums1
        var p2 = n - 1 // Pointer for the last element in nums2
        var p = m + n - 1 // Pointer for the last position in nums1

        // Iterate while both arrays have elements to be compared
        while (p1 >= 0 && p2 >= 0) {
            // Compare elements from the end of both arrays
            if (nums1[p1] > nums2[p2]) {
                // If element in nums1 is larger, place it in the current position of nums1
                nums1[p] = nums1[p1]
                p1-- // Move pointer in nums1
            } else {
                // If element in nums2 is larger, place it in the current position of nums1
                nums1[p] = nums2[p2]
                p2-- // Move pointer in nums2
            }
            p-- // Move the final position pointer
        }

        // If there are still elements in nums2, copy them
        while (p2 >= 0) {
            nums1[p] = nums2[p2]
            p2-- // Move pointer in nums2
            p-- // Move the final position pointer
        }
    }
}
