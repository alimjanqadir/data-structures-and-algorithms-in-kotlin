package problems

/**
 * Finds the minimum value in a rotated sorted array that may contain duplicates.
 */
fun findMin(nums: IntArray): Int {
  var leftIndex = 0
  var rightIndex = nums.lastIndex

  while (leftIndex < rightIndex) {
    val midIndex = leftIndex + (rightIndex - leftIndex) / 2

    when {
      nums[midIndex] < nums[rightIndex] -> {
        rightIndex = midIndex
      }
      nums[midIndex] > nums[rightIndex] -> {
        leftIndex = midIndex + 1
      }
      else -> {
        rightIndex -= 1
      }
    }
  }

  return nums[leftIndex]
}
