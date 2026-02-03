package problems

import java.util.TreeMap

/**
 * LeetCode 3013: Divide an Array Into Subarrays With Minimum Cost II
 * https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii/
 */
fun minimumCost(
  numbers: IntArray,
  groupCount: Int,
  maximumDistance: Int,
): Long {
  val arrayLength = numbers.size
  if (groupCount == 1) return numbers[0].toLong()
  val neededChoices = groupCount - 1
  val windowMaximumSpan = maximumDistance + 1
  val smallValues = TreeMap<Long, Int>()
  val largeValues = TreeMap<Long, Int>()
  var smallValuesSum = 0L
  var smallValuesCount = 0
  var minimumExtraCost = Long.MAX_VALUE
  var windowLeftIndex = 1

  fun addValue(value: Long) {
    if (smallValuesCount < neededChoices) {
      smallValues[value] = smallValues.getOrDefault(value, 0) + 1
      smallValuesSum += value
      smallValuesCount++
    } else if (smallValues.isNotEmpty() && value < smallValues.lastKey()) {
      val largestInSmall = smallValues.lastKey()
      smallValues[largestInSmall] = smallValues[largestInSmall]!! - 1
      if (smallValues[largestInSmall] == 0) smallValues.remove(largestInSmall)
      smallValuesSum -= largestInSmall
      largeValues[largestInSmall] =
        largeValues.getOrDefault(largestInSmall, 0) + 1
      smallValues[value] = smallValues.getOrDefault(value, 0) + 1
      smallValuesSum += value
    } else {
      largeValues[value] = largeValues.getOrDefault(value, 0) + 1
    }
  }

  fun removeValue(value: Long) {
    if (largeValues.containsKey(value)) {
      largeValues[value] = largeValues[value]!! - 1
      if (largeValues[value] == 0) largeValues.remove(value)
    } else if (smallValues.containsKey(value)) {
      smallValues[value] = smallValues[value]!! - 1
      if (smallValues[value] == 0) smallValues.remove(value)
      smallValuesSum -= value
      smallValuesCount--
      if (largeValues.isNotEmpty()) {
        val smallestInLarge = largeValues.firstKey()
        largeValues[smallestInLarge] = largeValues[smallestInLarge]!! - 1
        if (largeValues[smallestInLarge] == 0) {
          largeValues.remove(smallestInLarge)
        }
        smallValues[smallestInLarge] =
          smallValues.getOrDefault(smallestInLarge, 0) + 1
        smallValuesSum += smallestInLarge
        smallValuesCount++
      }
    }
  }

  for (windowRightIndex in 1 until arrayLength) {
    addValue(numbers[windowRightIndex].toLong())
    while (windowRightIndex - windowLeftIndex + 1 > windowMaximumSpan) {
      removeValue(numbers[windowLeftIndex].toLong())
      windowLeftIndex++
    }
    val currentWindowLength = windowRightIndex - windowLeftIndex + 1
    if (
      currentWindowLength >= neededChoices &&
      smallValuesCount == neededChoices
    ) {
      minimumExtraCost = minOf(minimumExtraCost, smallValuesSum)
    }
  }

  return if (minimumExtraCost == Long.MAX_VALUE) {
    -1L
  } else {
    numbers[0].toLong() + minimumExtraCost
  }
}
