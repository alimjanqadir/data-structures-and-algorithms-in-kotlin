fun constructTransformedArray(nums: IntArray): IntArray {
  val arrayLength = nums.size
  val result = IntArray(arrayLength)

  for (currentIndex in nums.indices) {
    val stepsToMove = nums[currentIndex]

    if (stepsToMove == 0) {
      result[currentIndex] = 0
    } else {
      val rawLandingIndex = currentIndex + stepsToMove
      val normalizedLandingIndex =
        ((rawLandingIndex % arrayLength) + arrayLength) % arrayLength

      result[currentIndex] = nums[normalizedLandingIndex]
    }
  }

  return result
}
