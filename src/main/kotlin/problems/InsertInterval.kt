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

fun main() {
    // Test case 1: Normal case
    val test1 = insert(
        arrayOf(intArrayOf(1,3), intArrayOf(6,9)),
        intArrayOf(2,5)
    )
    println("Test 1: ${test1.contentDeepToString()}")

    // Test case 2: Multiple overlapping intervals
    val test2 = insert(
        arrayOf(intArrayOf(1,2), intArrayOf(3,5), intArrayOf(6,7), intArrayOf(8,10), intArrayOf(12,16)),
        intArrayOf(4,8)
    )
    println("Test 2: ${test2.contentDeepToString()}")

    // Test case 3: Empty intervals
    val test3 = insert(arrayOf(), intArrayOf(5,7))
    println("Test 3: ${test3.contentDeepToString()}")

    // Test case 4: Insert at beginning
    val test4 = insert(
        arrayOf(intArrayOf(3,5), intArrayOf(6,9)),
        intArrayOf(1,2)
    )
    println("Test 4: ${test4.contentDeepToString()}")

    // Test case 5: Insert at end
    val test5 = insert(
        arrayOf(intArrayOf(1,2), intArrayOf(3,5)),
        intArrayOf(6,8)
    )
    println("Test 5: ${test5.contentDeepToString()}")
}

