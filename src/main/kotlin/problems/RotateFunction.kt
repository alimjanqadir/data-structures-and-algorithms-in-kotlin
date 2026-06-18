package problems

/**
 * LeetCode 396. Rotate Function
 * https://leetcode.com/problems/rotate-function/
 */
fun maxRotateFunction(nums: IntArray): Int {
  val arrayLength = nums.size
  if (arrayLength == 0) return 0

  var totalSum = 0L
  for (value in nums) {
    totalSum += value
  }

  var currentRotationValue = 0L
  for (index in nums.indices) {
    currentRotationValue += index.toLong() * nums[index]
  }

  var maximumValue = currentRotationValue

  for (rotationStep in 1 until arrayLength) {
    val elementMovingToFront = nums[arrayLength - rotationStep]
    currentRotationValue = currentRotationValue + totalSum - arrayLength.toLong() * elementMovingToFront
    if (currentRotationValue > maximumValue) {
      maximumValue = currentRotationValue
    }
  }

  return maximumValue.toInt()
}
