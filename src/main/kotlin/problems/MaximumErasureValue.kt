package problems

fun maximumUniqueSubarray(nums: IntArray): Int {
  val seen = HashSet<Int>()
  var left = 0
  var windowSum = 0
  var maxSum = 0

  for (right in nums.indices) {
    val value = nums[right]
    while (value in seen) {
      val outgoing = nums[left]
      seen.remove(outgoing)
      windowSum -= outgoing
      left++
    }
    seen.add(value)
    windowSum += value
    if (windowSum > maxSum) maxSum = windowSum
  }

  return maxSum
}
