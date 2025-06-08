// LeetCode 3392. Count Subarrays of Length Three With a Condition
// Returns the number of subarrays where first + third == middle / 2.0

fun countSubarraysOfLengthThreeWithACondition(nums: IntArray): Int {
  var count = 0
  for (index in 0 until nums.size - 2) {
    val first = nums[index]
    val middle = nums[index + 1]
    val third = nums[index + 2]
    if (first.toDouble() + third.toDouble() == middle.toDouble() / 2.0) {
      count++
    }
  }
  return count
}
