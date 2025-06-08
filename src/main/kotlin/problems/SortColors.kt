fun sortColors(nums: IntArray): Unit {
  var low = 0
  var high = nums.size - 1
  var i = 0
    
  while (i <= high) {
    when (nums[i]) {
      0 -> {
        // Swap with low and move both pointers
        val temp = nums[i]
        nums[i] = nums[low]
        nums[low] = temp
        low++
        i++
      }
      2 -> {
        // Swap with high and shrink high
        val temp = nums[i]
        nums[i] = nums[high]
        nums[high] = temp
        high--
      }
      else -> {
        // 1 stays in place, move i
        i++
      }
    }
  }
}
