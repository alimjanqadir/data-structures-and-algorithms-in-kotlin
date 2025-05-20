package problems

/**
 * Checks if all elements in the array can be reduced to zero by applying the given range operations.
 * Each query [l, r] represents a range operation that decrements all elements from index l to r (inclusive) by 1.
 * 
 * @param nums The input array of integers.
 * @param queries Array of range operations where each operation is represented as [l, r].
 * @return true if all elements can be reduced to zero, false otherwise.
 */
fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
    val n = nums.size
    val diff = IntArray(n)
    
    // Build difference array
    for (query in queries) {
        val li = query[0]
        val ri = query[1]
        diff[li] += 1
        if (ri + 1 < n) {
            diff[ri + 1] -= 1
        }
    }
    
    // Check condition with running sum
    var current = 0
    for (i in 0 until n) {
        current += diff[i]  // Number of queries including i
        if (nums[i] > current) {
            return false
        }
    }
    return true
}
