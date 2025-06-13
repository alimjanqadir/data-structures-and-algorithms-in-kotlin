package problems

/**
 * LeetCode 2616. Minimize the Maximum Difference of Pairs
 */
fun minimizeMax(nums: IntArray, p: Int): Int {
  nums.sort()

  fun canMakePairs(maxDiff: Int): Boolean {
    var count = 0
    var index = 0
    while (index < nums.size - 1) {
      if (nums[index + 1] - nums[index] <= maxDiff) {
        count += 1
        index += 2 // use both indices
      } else {
        index += 1 // skip this one
      }
    }
    return count >= p
  }

  var left = 0
  var right = nums[nums.size - 1] - nums[0]

  while (left < right) {
    val mid = (left + right) / 2
    if (canMakePairs(mid)) {
      right = mid // try a smaller maxDiff
    } else {
      left = mid + 1 // too small, need larger diff
    }
  }

  return left
}
