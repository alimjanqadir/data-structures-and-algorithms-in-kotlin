package problems

/**
 * LeetCode 2411. Smallest Subarrays With Maximum Bitwise OR
 * https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or/
 */
fun smallestSubarrays(nums: IntArray): IntArray {
  val bitWidth = 32
  val lastSeenBitIndex = IntArray(bitWidth) { -1 }
  val totalElements = nums.size
  val minimalLengths = IntArray(totalElements)

  for (currentIndex in totalElements - 1 downTo 0) {
    var valueMask = nums[currentIndex]
    var bitPosition = 0
    while (valueMask != 0) {
      if ((valueMask and 1) != 0) {
        lastSeenBitIndex[bitPosition] = currentIndex
      }
      bitPosition += 1
      valueMask = valueMask ushr 1
    }

    var farthestRequiredIndex = currentIndex
    for (position in 0 until bitWidth) {
      val seenIndex = lastSeenBitIndex[position]
      if (seenIndex > farthestRequiredIndex) {
        farthestRequiredIndex = seenIndex
      }
    }

    minimalLengths[currentIndex] = farthestRequiredIndex - currentIndex + 1
  }

  return minimalLengths
}

