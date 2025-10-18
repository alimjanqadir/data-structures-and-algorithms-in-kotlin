package problems

fun maxDistinctElements(nums: IntArray, k: Int): Int {
  val sorted = nums.map { it.toLong() }.sorted()
  val moveRange = k.toLong()

  var nextFree: Long = Long.MIN_VALUE / 4
  var distinctCount = 0

  for (original in sorted) {
    val left = original - moveRange
    val right = original + moveRange
    val assigned = maxOf(nextFree, left)
    if (assigned <= right) {
      distinctCount += 1
      nextFree = assigned + 1
    }
  }
  return distinctCount
}
