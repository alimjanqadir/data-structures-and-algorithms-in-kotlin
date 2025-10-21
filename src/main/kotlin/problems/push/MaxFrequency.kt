package problems.push

import java.util.Arrays

fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
  val n = nums.size
  if (n == 0) return 0
  Arrays.sort(nums)

  fun lowerBound(target: Int): Int {
    var low = 0
    var high = n
    while (low < high) {
      val mid = (low + high) ushr 1
      if (nums[mid] >= target) {
        high = mid
      } else {
        low = mid + 1
      }
    }
    return low
  }

  fun upperBound(target: Int): Int {
    var low = 0
    var high = n
    while (low < high) {
      val mid = (low + high) ushr 1
      if (nums[mid] > target) {
        high = mid
      } else {
        low = mid + 1
      }
    }
    return low
  }

  var maxWindowSizeAny = 1
  var leftIndex = 0
  var rightIndex = 0
  while (rightIndex < n) {
    while (nums[rightIndex] - nums[leftIndex] > 2 * k) {
      leftIndex += 1
    }
    val windowSize = rightIndex - leftIndex + 1
    if (windowSize > maxWindowSizeAny) {
      maxWindowSizeAny = windowSize
    }
    rightIndex += 1
  }

  var best = 1
  var runStart = 0
  while (runStart < n) {
    var runEnd = runStart
    val value = nums[runStart]
    while (runEnd < n && nums[runEnd] == value) {
      runEnd += 1
    }
    val runCount = runEnd - runStart

    val leftBound = value - k
    val rightBound = value + k
    val leftPos = lowerBound(leftBound)
    val rightPosExclusive = upperBound(rightBound)
    val windowSizeAroundV = rightPosExclusive - leftPos

    val candidateForV = minOf(windowSizeAroundV, runCount + numOperations)
    if (candidateForV > best) {
      best = candidateForV
    }

    runStart = runEnd
  }

  val candidateNoFreebies = minOf(maxWindowSizeAny, numOperations)
  if (candidateNoFreebies > best) {
    best = candidateNoFreebies
  }

  return best
}
