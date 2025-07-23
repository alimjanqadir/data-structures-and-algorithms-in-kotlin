package problems

// The solution function
fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
  if (intervals.isEmpty()) return arrayOf(newInterval)

  var start = newInterval[0]
  var end = newInterval[1]
  var insertIndex = 0

  // Find the position for merging and update start/end
  for (i in intervals.indices) {
    if (intervals[i][1] < start) {
      insertIndex++
      continue
    }
    if (intervals[i][0] <= end) {
      start = minOf(start, intervals[i][0])
      end = maxOf(end, intervals[i][1])
    }
    else {
      break
    }
  }

  // Create result array with correct size
  var resultSize = insertIndex + 1
  for (i in intervals.indices) {
    if (intervals[i][0] > end) resultSize++
  }

  val result = Array(resultSize) { IntArray(2) }
  var idx = 0

  // Copy intervals before merge point
  for (i in 0 until insertIndex) {
    result[idx++] = intervals[i]
  }

  // Add merged interval
  result[idx++] = intArrayOf(start, end)

  // Copy remaining non-overlapping intervals
  for (i in intervals.indices) {
    if (intervals[i][0] > end) {
      result[idx++] = intervals[i]
    }
  }

  return result
}

