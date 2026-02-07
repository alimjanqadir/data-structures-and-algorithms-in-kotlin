package problems

fun countValidSelections(nums: IntArray): Int {
  var validCount = 0
  for (startIndex in nums.indices) {
    if (nums[startIndex] != 0) continue
    if (simulate(nums, startIndex, 1)) validCount++
    if (simulate(nums, startIndex, -1)) validCount++
  }
  return validCount
}

private fun simulate(original: IntArray, startIndex: Int, initialStep: Int): Boolean {
  val state = original.copyOf()
  val length = state.size
  var position = startIndex
  var step = initialStep

  while (position in 0 until length) {
    if (state[position] == 0) {
      position += step
    } else {
      state[position] = state[position] - 1
      step = -step
      position += step
    }
  }

  for (value in state) {
    if (value != 0) return false
  }
  return true
}
