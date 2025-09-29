fun minScoreTriangulation(values: IntArray): Int {
  val vertexCount = values.size
  // dp[left][right] = min score to triangulate sub-polygon [left..right]
  val minScore = Array(vertexCount) { IntArray(vertexCount) { 0 } }

  // length is the interval size (number of vertices in sub-polygon)
  // We need at least 3 vertices to form any triangle.
  for (intervalLength in 3..vertexCount) {
    for (leftIndex in 0..vertexCount - intervalLength) {
      val rightIndex = leftIndex + intervalLength - 1
      var best = Int.MAX_VALUE

      // choose the third vertex to close triangle (leftIndex, splitIndex, rightIndex)
      for (splitIndex in leftIndex + 1 until rightIndex) {
        val scoreLeft = minScore[leftIndex][splitIndex]
        val scoreRight = minScore[splitIndex][rightIndex]
        val triangleScore = values[leftIndex] * values[splitIndex] * values[rightIndex]
        val totalScore = scoreLeft + scoreRight + triangleScore
        if (totalScore < best) {
          best = totalScore
        }
      }

      minScore[leftIndex][rightIndex] = if (best == Int.MAX_VALUE) 0 else best
    }
  }

  return minScore[0][vertexCount - 1]
}
