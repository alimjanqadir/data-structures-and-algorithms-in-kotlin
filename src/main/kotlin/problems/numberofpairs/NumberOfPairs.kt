package problems.numberofpairs

class Solution {
  fun numberOfPairs(points: Array<IntArray>): Int {
    val n = points.size

    // 1) Coordinate compression for x and y
    val xs = points.map { it[0] }.distinct().sorted()
    val ys = points.map { it[1] }.distinct().sorted()
    val xIndex = HashMap<Int, Int>(xs.size)
    val yIndex = HashMap<Int, Int>(ys.size)
    for ((rank, xVal) in xs.withIndex()) xIndex[xVal] = rank + 1  // 1-based
    for ((rank, yVal) in ys.withIndex()) yIndex[yVal] = rank + 1  // 1-based

    val xCount = xs.size
    val yCount = ys.size

    // 2) Grid with compressed coordinates
    val grid = Array(xCount + 1) { IntArray(yCount + 1) }
    val compressed = Array(n) { IntArray(2) }
    for (idx in 0 until n) {
      val cx = xIndex[points[idx][0]]!!
      val cy = yIndex[points[idx][1]]!!
      grid[cx][cy] = 1
      compressed[idx][0] = cx
      compressed[idx][1] = cy
    }

    // 3) Build 2D prefix sums (inclusive)
    val pref = Array(xCount + 1) { IntArray(yCount + 1) }
    for (cx in 1..xCount) {
      var rowSum = 0
      for (cy in 1..yCount) {
        rowSum += grid[cx][cy]
        pref[cx][cy] = pref[cx - 1][cy] + rowSum
      }
    }

    fun rectSum(x1: Int, y1: Int, x2: Int, y2: Int): Int {
      if (x1 > x2 || y1 > y2) return 0
      return pref[x2][y2] - pref[x1 - 1][y2] - pref[x2][y1 - 1] + pref[x1 - 1][y1 - 1]
    }

    // 4) Check all ordered pairs (Alice = A, Bob = B)
    var validPairs = 0L
    for (a in 0 until n) {
      val ax = compressed[a][0]
      val ay = compressed[a][1]
      for (b in 0 until n) {
        if (a == b) continue
        val bx = compressed[b][0]
        val by = compressed[b][1]

        // orientation: Alice upper-left, Bob lower-right
        if (ax <= bx && ay >= by) {
          val cnt = rectSum(ax, by, bx, ay)
          if (cnt == 2) validPairs++
        }
      }
    }

    return validPairs.toInt()
  }
}

