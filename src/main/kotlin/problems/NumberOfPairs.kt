package problems

fun numberOfPairs(points: Array<IntArray>): Int {
  val totalPoints = points.size
  var validPairs = 0

  for (indexA in 0 until totalPoints) {
    val ax = points[indexA][0]
    val ay = points[indexA][1]

    for (indexB in 0 until totalPoints) {
      if (indexB == indexA) continue

      val bx = points[indexB][0]
      val by = points[indexB][1]

      // A must be upper-left (or same row/column with at least one strict)
      val isUpperLeft = (ax <= bx && ay >= by) && (ax < bx || ay > by)
      if (!isUpperLeft) continue

      val minX = minOf(ax, bx)
      val maxX = maxOf(ax, bx)
      val minY = minOf(ay, by)
      val maxY = maxOf(ay, by)

      var isEmptyRectangle = true
      for (indexC in 0 until totalPoints) {
        if (indexC == indexA || indexC == indexB) continue
        val cx = points[indexC][0]
        val cy = points[indexC][1]

        // “Including the border” => closed interval checks
        if (cx in minX..maxX && cy in minY..maxY) {
          isEmptyRectangle = false
          break
        }
      }

      if (isEmptyRectangle) {
        validPairs += 1
      }
    }
  }
  return validPairs
}
