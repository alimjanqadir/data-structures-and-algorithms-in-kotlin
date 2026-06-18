package problems

fun search(nums: IntArray, target: Int): Int {
  var leftIndex = 0
  var rightIndex = nums.lastIndex

  while (leftIndex <= rightIndex) {
    val middleIndex = leftIndex + (rightIndex - leftIndex) / 2

    if (nums[middleIndex] == target) {
      return middleIndex
    }

    if (nums[leftIndex] <= nums[middleIndex]) {
      if (target >= nums[leftIndex] && target < nums[middleIndex]) {
        rightIndex = middleIndex - 1
      } else {
        leftIndex = middleIndex + 1
      }
    } else {
      if (target > nums[middleIndex] && target <= nums[rightIndex]) {
        leftIndex = middleIndex + 1
      } else {
        rightIndex = middleIndex - 1
      }
    }
  }

  return -1
}
