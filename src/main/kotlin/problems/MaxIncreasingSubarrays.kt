package problems

fun maxIncreasingSubarrays(nums: List<Int>): Int {
  val count = nums.size
  if (count < 2) return 0

  val incRight = IntArray(count)
  incRight[count - 1] = 1
  var index = count - 2
  while (index >= 0) {
    if (nums[index] < nums[index + 1]) {
      incRight[index] = incRight[index + 1] + 1
    } else {
      incRight[index] = 1
    }
    index -= 1
  }

  fun feasible(length: Int): Boolean {
    val lastStart = count - 2 * length
    if (lastStart < 0) return false
    var startIndex = 0
    while (startIndex <= lastStart) {
      if (incRight[startIndex] >= length && incRight[startIndex + length] >= length) {
        return true
      }
      startIndex += 1
    }
    return false
  }

  var low = 1
  var high = count / 2
  var best = 0
  while (low <= high) {
    val mid = low + (high - low) / 2
    if (feasible(mid)) {
      best = mid
      low = mid + 1
    } else {
      high = mid - 1
    }
  }
  return best
}
