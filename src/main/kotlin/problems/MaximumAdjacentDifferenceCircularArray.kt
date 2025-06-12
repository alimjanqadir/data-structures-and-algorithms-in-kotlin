package problems

import kotlin.math.abs

fun maxAdjacentDistance(values: IntArray): Int {
  val totalElements = values.size
  if (totalElements <= 1) return 0

  var maximumAbsoluteDifference = 0
  for (currentIndex in 0 until totalElements) {
    val nextIndex = (currentIndex + 1) % totalElements
    val absoluteDifference = abs(values[currentIndex] - values[nextIndex])
    if (absoluteDifference > maximumAbsoluteDifference) {
      maximumAbsoluteDifference = absoluteDifference
    }
  }
  return maximumAbsoluteDifference
}
