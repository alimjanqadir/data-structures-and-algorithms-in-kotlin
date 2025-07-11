package problems

/**
 * Count Days Without Meetings
 *
 * Given the total number of days and a list of meeting intervals,
 * return the number of days without any meetings scheduled.
 */
fun countDays(totalDays: Int, meetings: Array<IntArray>): Int {
  if (meetings.isEmpty()) return totalDays

  meetings.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

  var mergedStart = meetings[0][0]
  var mergedEnd = meetings[0][1]
  var occupiedDays = 0L

  for (index in 1 until meetings.size) {
    val nextStart = meetings[index][0]
    val nextEnd = meetings[index][1]
    if (nextStart <= mergedEnd + 1) {
      if (nextEnd > mergedEnd) mergedEnd = nextEnd
    } else {
      occupiedDays += (mergedEnd - mergedStart + 1).toLong()
      mergedStart = nextStart
      mergedEnd = nextEnd
    }
  }
  occupiedDays += (mergedEnd - mergedStart + 1).toLong()

  val freeDays = totalDays.toLong() - occupiedDays
  return freeDays.toInt()
}
