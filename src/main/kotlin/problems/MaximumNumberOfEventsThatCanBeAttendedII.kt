package problems

/**
 * LeetCode 1751. Maximum Number of Events That Can Be Attended II
 * https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 */
fun maxValue(events: Array<IntArray>, maxAttendableEvents: Int): Int {
  val totalEvents = events.size
  if (totalEvents == 0 || maxAttendableEvents == 0) return 0

  /* ---------- 1. sort by start day ---------- */
  events.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })

  val startDays = IntArray(totalEvents) { index -> events[index][0] }

  /* ---------- 2. next non-overlapping event for every event ---------- */
  val nextIndex = IntArray(totalEvents)
  for (eventIndex in 0 until totalEvents) {
    val currentEnd = events[eventIndex][1]
    var left = eventIndex + 1
    var right = totalEvents
    while (left < right) {                        // binary search
      val middle = left + (right - left) / 2
      if (startDays[middle] <= currentEnd) {
        left = middle + 1                     // still overlapping
      } else {
        right = middle
      }
    }
    nextIndex[eventIndex] = left                  // may be totalEvents (sentinel)
  }

  val effectiveK = kotlin.math.min(maxAttendableEvents, totalEvents)

  /* ---------- 3. DP with two rolling rows ---------- */
  var dpPrevious = IntArray(totalEvents + 1) { 0 }  // p-1 remaining selections
  var dpCurrent  = IntArray(totalEvents + 1) { 0 }  // p   remaining selections

  for (selectionCount in 1..effectiveK) {
    for (eventIndex in totalEvents - 1 downTo 0) {
      val valueIfChosen =
        events[eventIndex][2] + dpPrevious[nextIndex[eventIndex]]
      val valueIfSkipped = dpCurrent[eventIndex + 1]
      dpCurrent[eventIndex] =
        if (valueIfChosen > valueIfSkipped) valueIfChosen else valueIfSkipped
    }
    // reuse arrays: dpCurrent becomes dpPrevious for next iteration
    val swap = dpPrevious
    dpPrevious = dpCurrent
    dpCurrent = swap
  }

  /* ---------- 4. answer ---------- */
  return dpPrevious[0]
}
