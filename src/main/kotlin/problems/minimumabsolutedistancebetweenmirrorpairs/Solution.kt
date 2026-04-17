package problems.minimumabsolutedistancebetweenmirrorpairs

class MinimumAbsoluteDistanceBetweenMirrorPairs {
  fun minMirrorPairDistance(nums: IntArray): Int {
    val reversedValueToIndex = HashMap<Int, Int>()
    var minimumDistance = Int.MAX_VALUE

    for (currentIndex in nums.indices) {
      val currentValue = nums[currentIndex]

      if (reversedValueToIndex.containsKey(currentValue)) {
        val previousIndex = reversedValueToIndex[currentValue]!!
        val distance = currentIndex - previousIndex
        minimumDistance = minOf(minimumDistance, distance)
      }

      val reversedValue = reverseNumber(currentValue)
      reversedValueToIndex[reversedValue] = currentIndex
    }

    return if (minimumDistance == Int.MAX_VALUE) -1 else minimumDistance
  }

  private fun reverseNumber(number: Int): Int {
    var remaining = number
    var reversed = 0

    while (remaining > 0) {
      val digit = remaining % 10
      reversed = reversed * 10 + digit
      remaining /= 10
    }

    return reversed
  }
}
