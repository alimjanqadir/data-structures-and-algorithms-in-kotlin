package problems

/**
 * Returns the maximum difference nums[j] - nums[i] for indices i < j and
 * nums[i] < nums[j]. If no such pair exists, returns -1.
 */
fun maximumDifference(nums: IntArray): Int {
  var minSoFar = nums[0]
  var maxDiff = -1
  for (index in 1 until nums.size) {
    val value = nums[index]
    if (value > minSoFar) {
      val diff = value - minSoFar
      if (diff > maxDiff) {
        maxDiff = diff
      }
    } else if (value < minSoFar) {
      minSoFar = value
    }
  }
  return maxDiff
}
