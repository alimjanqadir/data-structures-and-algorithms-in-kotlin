import kotlin.math.max

/**
 * Calculates the maximum value of an ordered triplet (nums[i] - nums[j]) * nums[k]
 * where i < j < k. Returns 0 if all triplet values are negative.
 *
 * Uses a single pass O(n) approach.
 */
fun maximumTripletValue(nums: IntArray): Long {
  if (nums.size < 3) return 0L

  var maxValBeforeJ = nums[0].toLong()
  var maxDiff = 0L
  var maxResult = 0L

  for (k in 1 until nums.size) {
    val currentNum = nums[k].toLong()

    // Use previously computed maxDiff (nums[i] - nums[j]) to calculate triplet value
    maxResult = maxOf(maxResult, maxDiff * currentNum)

    // Update maxDiff using the current value as nums[j]
    maxDiff = maxOf(maxDiff, maxValBeforeJ - currentNum)

    // Update maxValBeforeJ to be used in future iterations
    maxValBeforeJ = maxOf(maxValBeforeJ, currentNum)
  }

  return maxResult
}

fun main() {
  println(maximumTripletValue(intArrayOf(12, 6, 1, 2, 7))) // Output: 77
  println(maximumTripletValue(intArrayOf(1, 10, 3, 4, 19))) // Output: 133
  println(maximumTripletValue(intArrayOf(1, 2, 3)))       // Output: 0
  println(maximumTripletValue(intArrayOf(10, 1, 5, 8, 2)))  // Output: (10 - 1) * 8 = 72
  println(maximumTripletValue(intArrayOf(2, 3, 1)))       // Output: 0 
}
