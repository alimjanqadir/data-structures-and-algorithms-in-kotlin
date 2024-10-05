package problems

fun minimumTime(time: IntArray, totalTrips: Int): Long {
    // Define the search space
    var left = 1L
    var right = time.minOrNull()!!.toLong() * totalTrips

    // Binary search to find the minimum time needed
    while (left < right) {
        val mid = left + (right - left) / 2
        // Check if we can complete the required number of trips within 'mid' time
        if (canCompleteTrips(time, mid, totalTrips)) {
            right = mid // If possible, try for a smaller time
        } else {
            left = mid + 1 // If not possible, increase the time
        }
    }
    return left // The minimum time required to complete all trips
}

// Helper function to check if we can complete the required trips within the given time
fun canCompleteTrips(time: IntArray, givenTime: Long, totalTrips: Int): Boolean {
    var trips = 0L
    // Calculate the total number of trips all buses can make within 'givenTime'
    for (t in time) {
        trips += givenTime / t
        // If we have enough trips, return true early
        if (trips >= totalTrips) return true
    }
    // Return false if the total number of trips is insufficient
    return false
}

fun main() {
    // Test assertions
    assert(minimumTime(intArrayOf(1, 2, 3), 5) == 3L) { "Test case 1 failed" }
    assert(minimumTime(intArrayOf(2), 1) == 2L) { "Test case 2 failed" }
    assert(minimumTime(intArrayOf(3, 7, 9), 10) == 21L) { "Test case 3 failed" }
    assert(minimumTime(intArrayOf(5, 10, 10), 9) == 25L) { "Test case 4 failed" }
    assert(minimumTime(intArrayOf(1, 1, 1), 1000000) == 333334L) { "Test case 5 failed" }
    println("All test cases passed!")
}