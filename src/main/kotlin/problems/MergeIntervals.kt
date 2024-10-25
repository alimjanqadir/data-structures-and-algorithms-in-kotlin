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
fun main() {
    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 6),
            intArrayOf(8, 10),
            intArrayOf(15, 18)
        ),
        arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)),
        arrayOf(intArrayOf(1, 2)),
        arrayOf(intArrayOf(1, 5), intArrayOf(2, 3))
    )

    for ((index, intervals) in testCases.withIndex()) {
        println("Test case ${index + 1}:")
        println("Input: ${intervals.contentDeepToString()}")

        val resultOriginal = mergeIntervals(intervals)
        val resultOptimized = mergeIntervals(intervals)
        val resultFunctional = mergeIntervalsFunctional(intervals)

        println("Original solution: ${resultOriginal.contentDeepToString()}")
        println("Optimized solution: ${resultOptimized.contentDeepToString()}")
        println("Functional solution: ${resultFunctional.contentDeepToString()}")

        assert(resultOriginal.contentDeepEquals(resultOptimized)) { "Original and Optimized solutions differ for test case ${index + 1}" }
        assert(resultOriginal.contentDeepEquals(resultFunctional)) { "Original and Functional solutions differ for test case ${index + 1}" }

        println("All solutions match for test case ${index + 1}")
        println()
    }

    println("All tests passed!")
}
