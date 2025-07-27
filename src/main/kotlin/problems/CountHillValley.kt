package problems

/**
 * LeetCode 2210. Count Hills and Valleys in an Array
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
 */
fun countHillValley(nums: IntArray): Int {
  // 1) In-place compress consecutive duplicates.
  var writeIndex = 0
  var readIndex = 0
  while (readIndex < nums.size) {
    val currentValue = nums[readIndex]
    nums[writeIndex] = currentValue
    writeIndex += 1
    // skip all following equals
    readIndex += 1
    while (readIndex < nums.size && nums[readIndex] == currentValue) {
      readIndex += 1
    }
  }
  val sizeAfterCompression = writeIndex
  if (sizeAfterCompression < 3) return 0 // need neighbors on both sides

  // 2) Count hills and valleys in the compressed prefix
  var structuresCount = 0
  var position = 1
  val lastValidIndex = sizeAfterCompression - 2
  while (position <= lastValidIndex) {
    val leftValue = nums[position - 1]
    val midValue = nums[position]
    val rightValue = nums[position + 1]

    val isHill = midValue > leftValue && midValue > rightValue
    val isValley = midValue < leftValue && midValue < rightValue

    if (isHill || isValley) {
      structuresCount += 1
    }
    position += 1
  }
  return structuresCount
}
