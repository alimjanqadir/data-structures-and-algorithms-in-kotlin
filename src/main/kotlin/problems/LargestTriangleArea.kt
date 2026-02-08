package problems.largesttrianglearea

fun largestTriangleArea(points: Array<IntArray>): Double {
  fun triangleArea(p1: IntArray, p2: IntArray, p3: IntArray): Double {
    val x1 = p1[0].toDouble()
    val y1 = p1[1].toDouble()
    val x2 = p2[0].toDouble()
    val y2 = p2[1].toDouble()
    val x3 = p3[0].toDouble()
    val y3 = p3[1].toDouble()

    val twiceArea = kotlin.math.abs(
      x1 * (y2 - y3) +
        x2 * (y3 - y1) +
        x3 * (y1 - y2)
    )
    return twiceArea / 2.0
  }

  var maximumArea = 0.0
  val totalPoints = points.size

  for (firstIndex in 0 until totalPoints) {
    for (secondIndex in firstIndex + 1 until totalPoints) {
      for (thirdIndex in secondIndex + 1 until totalPoints) {
        val currentArea = triangleArea(
          points[firstIndex],
          points[secondIndex],
          points[thirdIndex]
        )
        if (currentArea > maximumArea) {
          maximumArea = currentArea
        }
      }
    }
  }
  return maximumArea
}
