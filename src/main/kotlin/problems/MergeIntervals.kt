// Brute Force Solution
fun mergeIntervalsSimple(intervals: Array<IntArray>): Array<IntArray> {
  // Handle empty input
  if (intervals.isEmpty()) return emptyArray()

  // Sort intervals by start time
  val sortedIntervals = intervals.sortedBy { it[0] }
  val mergedIntervals = mutableListOf<IntArray>()

  var currentInterval = sortedIntervals[0]

  for (nextInterval in sortedIntervals.drop(1)) {
    if (intervalsOverlap(currentInterval, nextInterval)) {
      // Merge overlapping intervals
      currentInterval = merge(currentInterval, nextInterval)
    } else {
      // Add non-overlapping interval to result
      mergedIntervals.add(currentInterval)
      currentInterval = nextInterval
    }
  }

  // Add the last interval
  mergedIntervals.add(currentInterval)

  return mergedIntervals.toTypedArray()
}

// Helper function to check if two intervals overlap
private fun intervalsOverlap(interval1: IntArray, interval2: IntArray): Boolean {
  return interval1[1] >= interval2[0]
}

// Helper function to merge two overlapping intervals
private fun merge(interval1: IntArray, interval2: IntArray): IntArray {
  return intArrayOf(interval1[0], maxOf(interval1[1], interval2[1]))
}

// Optimized Solution using sequence operations
private fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
  return intervals
    .sortedBy { it[0] } // Sort intervals by start time
    .fold(mutableListOf<IntArray>()) { mergedIntervals, currentInterval ->
      if (mergedIntervals.isEmpty() || mergedIntervals.last()[1] < currentInterval[0]) {
        mergedIntervals.add(currentInterval)
      } else {
        // If there's an overlap, merge the current interval with the last merged interval
        val lastMerged = mergedIntervals.last()
        lastMerged[1] = maxOf(lastMerged[1], currentInterval[1])
      }
      mergedIntervals
    }
    .toTypedArray()
}

// Functional Solution with immutable data structures
data class Interval(val start: Int, val end: Int)

private fun mergeIntervalsFunctional(intervals: Array<IntArray>): Array<IntArray> {
  return intervals
    .map { Interval(it[0], it[1]) }
    .sortedBy { it.start }
    .fold(emptyList<Interval>()) { acc, interval ->
      when {
        acc.isEmpty() -> listOf(interval)
        acc.last().end >= interval.start ->
          acc.dropLast(1) +
            Interval(acc.last().start, maxOf(acc.last().end, interval.end))

        else -> acc + interval
      }
    }
    .map { intArrayOf(it.start, it.end) }
    .toTypedArray()
}

// Test cases
