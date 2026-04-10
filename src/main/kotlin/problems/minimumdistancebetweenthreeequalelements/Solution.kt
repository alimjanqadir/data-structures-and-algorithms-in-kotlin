package problems.minimumdistancebetweenthreeequalelements

class Solution {
  fun minimumDistance(nums: IntArray): Int {
    val valueToIndices = mutableMapOf<Int, MutableList<Int>>()

    for (index in nums.indices) {
      val value = nums[index]
      valueToIndices.computeIfAbsent(value) { mutableListOf() }.add(index)
    }

    var minimumDistance = Int.MAX_VALUE

    for (indices in valueToIndices.values) {
      if (indices.size >= 3) {
        for (startIndex in 0..indices.size - 3) {
          val firstIndex = indices[startIndex]
          val thirdIndex = indices[startIndex + 2]

          val distance = 2 * (thirdIndex - firstIndex)
          minimumDistance = minOf(minimumDistance, distance)
        }
      }
    }

    return if (minimumDistance == Int.MAX_VALUE) -1 else minimumDistance
  }
}
