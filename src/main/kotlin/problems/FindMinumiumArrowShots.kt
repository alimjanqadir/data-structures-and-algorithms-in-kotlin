package problems

fun findMinArrowShotsOptimized(points: Array<IntArray>): Int {
  if (points.isEmpty()) return 0

  // Use compareBy to handle potential integer overflow
  points.sortWith(compareBy<IntArray> { it[1] })

  var count = 1
  var pos = points[0][1]

  for (i in 1 until points.size) {
    // No need to update pos unless we need a new arrow
    if (points[i][0] > pos) {
      pos = points[i][1]
      count++
    }
  }

  return count
}

fun main() {
  // Basic correctness tests with expected results
  val testCases = listOf(
    Pair(
      arrayOf(intArrayOf(10, 16), intArrayOf(2, 8), intArrayOf(1, 6), intArrayOf(7, 12)),
      2
    ),
    Pair(
      arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6), intArrayOf(7, 8)),
      4
    ),
    Pair(
      arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5)),
      2
    ),
    // Edge cases
    Pair(
      arrayOf(intArrayOf(1, 2)),
      1
    ),
    Pair(
      arrayOf<IntArray>(),
      0
    ),
    // Overflow test case
    Pair(
      arrayOf(
        intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE),
        intArrayOf(Int.MIN_VALUE + 1, Int.MAX_VALUE)
      ),
      1
    )
  )

  for ((index, test) in testCases.withIndex()) {
    val (points, expected) = test
    val result = findMinArrowShotsOptimized(points.map { it.clone() }.toTypedArray())

    assert(result == expected) {
      "Test case $index failed: expected $expected, but got $result"
    }
    println("Test case $index passed!")
  }
  println("All correctness tests passed!")
}