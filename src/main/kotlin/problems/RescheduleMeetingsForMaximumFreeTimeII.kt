package problems

fun maxFreeTime(
  eventTime: Int,
  startTime: IntArray,
  endTime: IntArray,
): Int {
  val meetingCount = startTime.size

  // ---------- 1st pass : find the three largest gaps ----------
  val largestGapLength = IntArray(3) { -1 }
  val largestGapIndex = IntArray(3) { -1 }

  fun recordGap(length: Int, index: Int) {
    when {
      length > largestGapLength[0] -> {
        largestGapLength[2] = largestGapLength[1]
        largestGapIndex[2] = largestGapIndex[1]
        largestGapLength[1] = largestGapLength[0]
        largestGapIndex[1] = largestGapIndex[0]
        largestGapLength[0] = length
        largestGapIndex[0] = index
      }
      length > largestGapLength[1] -> {
        largestGapLength[2] = largestGapLength[1]
        largestGapIndex[2] = largestGapIndex[1]
        largestGapLength[1] = length
        largestGapIndex[1] = index
      }
      length > largestGapLength[2] -> {
        largestGapLength[2] = length
        largestGapIndex[2] = index
      }
    }
  }

  var previousEnd = 0
  var currentGapIndex = 0

  for (meetingIndex in 0 until meetingCount) {
    val gapBefore = startTime[meetingIndex] - previousEnd // g_j
    recordGap(gapBefore, currentGapIndex)

    currentGapIndex += 1 // next gap index
    previousEnd = endTime[meetingIndex]
  }

  // last gap g_n
  val gapAfterLast = eventTime - previousEnd
  recordGap(gapAfterLast, currentGapIndex)

  // ---------- 2nd pass : evaluate every meeting ----------
  var bestFreeInterval = largestGapLength[0] // baseline

  previousEnd = 0
  currentGapIndex = 0 // left gap index for meeting 0

  for (meetingIndex in 0 until meetingCount) {

    // adjacent gaps
    val leftGapLength = startTime[meetingIndex] - previousEnd // g_j
    val leftGapIndex = currentGapIndex

    val rightGapLength = if (meetingIndex == meetingCount - 1) {
      eventTime - endTime[meetingIndex] // g_n
    } else {
      startTime[meetingIndex + 1] - endTime[meetingIndex] // g_(j+1)
    }

    val rightGapIndex = currentGapIndex + 1

    // merged gap after removing the meeting
    val meetingDuration = endTime[meetingIndex] - startTime[meetingIndex]
    val mergedGapLength = leftGapLength + meetingDuration + rightGapLength

    // largest non-adjacent gap
    var suitableOtherGap = 0
    for (rank in 0..2) {
      val gapIdx = largestGapIndex[rank]
      if (gapIdx != leftGapIndex && gapIdx != rightGapIndex && gapIdx != -1) {
        suitableOtherGap = largestGapLength[rank]
        break
      }
    }

    // achievable free interval length with this meeting moved
    val candidateFreeInterval = if (suitableOtherGap >= meetingDuration) {
      mergedGapLength // meeting fits elsewhere
    } else {
      maxOf(mergedGapLength - meetingDuration, suitableOtherGap)
    }

    bestFreeInterval = maxOf(bestFreeInterval, candidateFreeInterval)

    // advance to next meeting
    previousEnd = endTime[meetingIndex]
    currentGapIndex += 1
  }

  return bestFreeInterval
}

