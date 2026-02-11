package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals

class MergeSortedArrayTest {
    
  @Test
  fun testMerge() {
    val mergeSortedArray = MergeSortedArray()
        
    // Test case 1: Basic merge
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2 = intArrayOf(2, 5, 6)
    mergeSortedArray.merge(nums1, 3, nums2, 3)
    assertContentEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)
        
    // Test case 2: nums1 empty
    val nums3 = intArrayOf(0, 0, 0)
    val nums4 = intArrayOf(1, 2, 3)
    mergeSortedArray.merge(nums3, 0, nums4, 3)
    assertContentEquals(intArrayOf(1, 2, 3), nums3)
        
    // Test case 3: nums2 empty
    val nums5 = intArrayOf(1, 2, 3)
    val nums6 = intArrayOf()
    mergeSortedArray.merge(nums5, 3, nums6, 0)
    assertContentEquals(intArrayOf(1, 2, 3), nums5)
        
    // Test case 4: All nums1 elements are smaller
    val nums7 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums8 = intArrayOf(4, 5, 6)
    mergeSortedArray.merge(nums7, 3, nums8, 3)
    assertContentEquals(intArrayOf(1, 2, 3, 4, 5, 6), nums7)
        
    // Test case 5: All nums2 elements are smaller
    val nums9 = intArrayOf(4, 5, 6, 0, 0, 0)
    val nums10 = intArrayOf(1, 2, 3)
    mergeSortedArray.merge(nums9, 3, nums10, 3)
    assertContentEquals(intArrayOf(1, 2, 3, 4, 5, 6), nums9)
        
    // Test case 6: Single element arrays
    val nums11 = intArrayOf(2, 0)
    val nums12 = intArrayOf(1)
    mergeSortedArray.merge(nums11, 1, nums12, 1)
    assertContentEquals(intArrayOf(1, 2), nums11)
        
    // Test case 7: Duplicate elements
    val nums13 = intArrayOf(1, 1, 1, 0, 0, 0)
    val nums14 = intArrayOf(1, 1, 1)
    mergeSortedArray.merge(nums13, 3, nums14, 3)
    assertContentEquals(intArrayOf(1, 1, 1, 1, 1, 1), nums13)
  }
}
