package problems

import kotlin.Int
import kotlin.IntArray

class Solution {
  fun minimumDifference(nums: IntArray, k: Int): Int {
    // Special case: k = 1 → difference is always 0
    if (k == 1) return 0
        
    // 1. Sort the array (O(n log n))
    nums.sort()
        
    // 2. Find minimum difference between nums[i+k-1] and nums[i]
    var minDiff = Int.MAX_VALUE
        
    // We only need to check n-k+1 windows
    for (i in 0..nums.size - k) {
      val diff = nums[i + k - 1] - nums[i]
      if (diff < minDiff) {
        minDiff = diff
      }
    }
        
    return minDiff
  }
}
