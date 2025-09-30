package problems

fun triangularSum(nums: IntArray): Int {
  var current = nums
  while (current.size > 1) {
    val next = IntArray(current.size - 1)
    for (index in next.indices) {
      next[index] = (current[index] + current[index + 1]) % 10
    }
    current = next
  }
  return current[0]
}
