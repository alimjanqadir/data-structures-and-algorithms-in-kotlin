package problems

/**
 * 1752. Check if Array Is Sorted and Rotated
 */
fun checkIfArrayIsSortedAndRotated(nums: IntArray): Boolean {
  var decreasingCount = 0
  val size = nums.size

  for (index in nums.indices) {
    val nextIndex = (index + 1) % size

    if (nums[index] > nums[nextIndex]) {
      decreasingCount += 1
    }
  }

  return decreasingCount <= 1
}
