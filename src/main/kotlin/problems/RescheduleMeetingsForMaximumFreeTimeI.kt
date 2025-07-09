package problems

fun maxFreeTime(
  eventTime: Int,
  k: Int,
  startTime: IntArray,
  endTime: IntArray,
): Int {
  val n = startTime.size

  // Build all gaps
  val gaps = mutableListOf<Int>()
  // before first
  gaps.add(startTime[0] - 0)
  // between
  for (meetingIndex in 1 until n) {
    gaps.add(startTime[meetingIndex] - endTime[meetingIndex - 1])
  }
  // after last
  gaps.add(eventTime - endTime[n - 1])

  // We can merge (k+1) consecutive gaps into one big interval
  // So best is sum of any (k+1) contiguous gaps
  var maxFree = 0
  var currentSum = 0
  for (gapIndex in 0 until gaps.size) {
    currentSum += gaps[gapIndex]
    if (gapIndex >= k + 1) {
      currentSum -= gaps[gapIndex - (k + 1)]
    }
    if (gapIndex >= k) {
      maxFree = maxOf(maxFree, currentSum)
    }
  }

  return maxFree
}
