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

