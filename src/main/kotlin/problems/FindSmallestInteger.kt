package problems

fun findSmallestInteger(nums: IntArray, value: Int): Int {
  val remainderCount = IntArray(value)
  for (number in nums) {
    var remainder = number % value
    if (remainder < 0) {
      remainder += value
    }
    remainderCount[remainder] = remainderCount[remainder] + 1
  }

  var mex = 0
  while (true) {
    val remainder = mex % value
    if (remainderCount[remainder] == 0) {
      return mex
    }
    remainderCount[remainder] = remainderCount[remainder] - 1
    mex = mex + 1
  }
}
