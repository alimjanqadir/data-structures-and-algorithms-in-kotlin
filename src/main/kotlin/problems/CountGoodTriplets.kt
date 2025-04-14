package problems

/**
 * Counts the number of good triplets in the given array.
 * A triplet (arr[i], arr[j], arr[k]) is good if:
 * - |arr[i] - arr[j]| <= a
 * - |arr[j] - arr[k]| <= b
 * - |arr[i] - arr[k]| <= c
 *
 * @param arr The input array of integers
 * @param a The maximum allowed difference between first and second elements
 * @param b The maximum allowed difference between second and third elements
 * @param c The maximum allowed difference between first and third elements
 * @return The number of good triplets in the array
 */
fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
    var count = 0
    for (firstIndex in 0 until arr.size) {
        for (secondIndex in firstIndex + 1 until arr.size) {
            if (kotlin.math.abs(arr[firstIndex] - arr[secondIndex]) <= a) {
                for (thirdIndex in secondIndex + 1 until arr.size) {
                    if (kotlin.math.abs(arr[secondIndex] - arr[thirdIndex]) <= b &&
                        kotlin.math.abs(arr[firstIndex] - arr[thirdIndex]) <= c) {
                        count++
                    }
                }
            }
        }
    }
    return count
} 