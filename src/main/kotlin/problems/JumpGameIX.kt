package problems

fun maxValue(nums: IntArray): IntArray {
  val size = nums.size
  val suffixMinimum = IntArray(size + 1) { Int.MAX_VALUE }

  for (index in size - 1 downTo 0) {
    suffixMinimum[index] = minOf(nums[index], suffixMinimum[index + 1])
  }

  val answer = IntArray(size)
  var componentStart = 0
  var currentMaximum = Int.MIN_VALUE

  for (index in 0 until size) {
    currentMaximum = maxOf(currentMaximum, nums[index])

    val isComponentEnd =
      index == size - 1 || currentMaximum <= suffixMinimum[index + 1]

    if (isComponentEnd) {
      for (fillIndex in componentStart..index) {
        answer[fillIndex] = currentMaximum
      }
      componentStart = index + 1
      currentMaximum = Int.MIN_VALUE
    }
  }

  return answer
}
