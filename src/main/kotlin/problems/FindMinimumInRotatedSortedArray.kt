package problems

fun findMin(nums: IntArray): Int {
  var leftIndex = 0
  var rightIndex = nums.lastIndex

  while (leftIndex < rightIndex) {
    val middleIndex = leftIndex + (rightIndex - leftIndex) / 2

    if (nums[middleIndex] > nums[rightIndex]) {
      leftIndex = middleIndex + 1
    } else {
      rightIndex = middleIndex
    }
  }

  return nums[leftIndex]
}
