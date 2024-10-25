// Brute Force Solution
fun mergeIntervalsSimple(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()

    // Sort by start time
    val sorted = intervals.sortedBy { it[0] }
    val result = mutableListOf<IntArray>()

    var current = sorted[0]
    for (i in 1 until sorted.size) {
        if (current[1] >= sorted[i][0]) {
            current[1] = maxOf(current[1], sorted[i][1])
        } else {
            result.add(current)
            current = sorted[i]
        }
    }
    result.add(current)

    return result.toTypedArray()
}

// Optimized Solution using sequence operations
fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
    return intervals
        .sortedBy { it[0] }
        .fold(mutableListOf<IntArray>()) { acc, interval ->
            if (acc.isEmpty() || acc.last()[1] < interval[0]) {
                acc.add(interval)
            } else {
                acc.last()[1] = maxOf(acc.last()[1], interval[1])
            }
            acc
        }
        .toTypedArray()
}

// Functional Solution with immutable data structures
data class Interval(val start: Int, val end: Int)

fun mergeIntervalsFunctional(intervals: Array<IntArray>): Array<IntArray> {
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
    // Test case 1: Normal overlapping intervals
    assert(
        mergeIntervals(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        )
            .contentDeepEquals(
                arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18))
            )
    )

    // Test case 2: Adjacent intervals
    assert(
        mergeIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)))
            .contentDeepEquals(arrayOf(intArrayOf(1, 5)))
    )

    // Test case 3: Single interval
    assert(mergeIntervals(arrayOf(intArrayOf(1, 2))).contentDeepEquals(arrayOf(intArrayOf(1, 2))))

    // Test case 4: Complete overlap
    assert(
        mergeIntervals(arrayOf(intArrayOf(1, 5), intArrayOf(2, 3)))
            .contentDeepEquals(arrayOf(intArrayOf(1, 5)))
    )

    println("All tests passed!")
}
