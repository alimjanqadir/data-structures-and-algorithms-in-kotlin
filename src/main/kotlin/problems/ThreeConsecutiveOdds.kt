/**
 * LeetCode: Three Consecutive Odds
 * Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
 */

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var consecutiveOdds = 0        // length of current streak of odd numbers
    for (number in arr) {
        if (number and 1 == 1) {   // faster than % 2 for small ints
            consecutiveOdds += 1
            if (consecutiveOdds == 3) return true
        } else {
            consecutiveOdds = 0
        }
    }
    return false
}
