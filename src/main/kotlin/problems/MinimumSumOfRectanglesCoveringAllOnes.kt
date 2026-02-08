package problems.minimumsumofrectanglescoveringallones

class Solution {
  fun minimumSum(grid: Array<IntArray>): Int {
    val rows = grid.size
    val cols = grid[0].size
    val INF = 1_000_000_000

    // 2D prefix sum for ones count
    val ps = Array(rows + 1) { IntArray(cols + 1) }
    for (r in 0 until rows) {
      var run = 0
      for (c in 0 until cols) {
        run += grid[r][c]
        ps[r + 1][c + 1] = ps[r][c + 1] + run
      }
    }
    fun onesIn(r1: Int, c1: Int, r2: Int, c2: Int): Int {
      if (r1 > r2 || c1 > c2) return 0
      return ps[r2 + 1][c2 + 1] - ps[r1][c2 + 1] - ps[r2 + 1][c1] + ps[r1][c1]
    }

    // Row/col prefix to quickly test if a row/col segment has any one
    val rowPs = Array(rows) { IntArray(cols + 1) }
    for (r in 0 until rows) {
      for (c in 0 until cols) rowPs[r][c + 1] = rowPs[r][c] + grid[r][c]
    }
    val colPs = Array(cols) { IntArray(rows + 1) }
    for (c in 0 until cols) {
      for (r in 0 until rows) colPs[c][r + 1] = colPs[c][r] + grid[r][c]
    }
    fun rowHasOne(r: Int, c1: Int, c2: Int): Boolean =
      rowPs[r][c2 + 1] - rowPs[r][c1] > 0
    fun colHasOne(c: Int, r1: Int, r2: Int): Boolean =
      colPs[c][r2 + 1] - colPs[c][r1] > 0

    // Area of tight bbox of ones in submatrix; INF if empty (disallowed for a chosen rect)
    fun tightArea(r1: Int, c1: Int, r2: Int, c2: Int): Int {
      if (onesIn(r1, c1, r2, c2) == 0) return INF
      var top = r1
      while (top <= r2 && !rowHasOne(top, c1, c2)) top += 1
      var bottom = r2
      while (bottom >= r1 && !rowHasOne(bottom, c1, c2)) bottom -= 1
      var left = c1
      while (left <= c2 && !colHasOne(left, r1, r2)) left += 1
      var right = c2
      while (right >= c1 && !colHasOne(right, r1, r2)) right -= 1
      val height = bottom - top + 1
      val width = right - left + 1
      return height * width
    }

    // Cache for bestTwo over submatrices (optional but cheap)
    val cacheTwo = HashMap<Long, Int>()
    fun key(r1: Int, c1: Int, r2: Int, c2: Int) =
      (((r1.toLong() shl 45) or (c1.toLong() shl 30) or (r2.toLong() shl 15) or c2.toLong()))

    fun bestTwo(r1: Int, c1: Int, r2: Int, c2: Int): Int {
      val k = key(r1, c1, r2, c2)
      val hit = cacheTwo[k]
      if (hit != null) return hit

      val total = onesIn(r1, c1, r2, c2)
      if (total == 0) { cacheTwo[k] = INF; return INF } // need two non-empty rects
      var best = INF

      // Vertical split: left [c1..cut], right [cut+1..c2]
      var cut = c1
      while (cut < c2) {
        val leftOnes = onesIn(r1, c1, r2, cut)
        val rightOnes = total - leftOnes
        if (leftOnes > 0 && rightOnes > 0) {
          val aLeft = tightArea(r1, c1, r2, cut)
          val aRight = tightArea(r1, cut + 1, r2, c2)
          val sum = aLeft + aRight
          if (sum < best) best = sum
        }
        cut += 1
      }

      // Horizontal split: top [r1..cut], bottom [cut+1..r2]
      var rowCut = r1
      while (rowCut < r2) {
        val topOnes = onesIn(r1, c1, rowCut, c2)
        val botOnes = total - topOnes
        if (topOnes > 0 && botOnes > 0) {
          val aTop = tightArea(r1, c1, rowCut, c2)
          val aBot = tightArea(rowCut + 1, c1, r2, c2)
          val sum = aTop + aBot
          if (sum < best) best = sum
        }
        rowCut += 1
      }

      cacheTwo[k] = best
      return best
    }

    // bestThree on the full grid via first cut then (1,2) or (2,1)
    var answer = INF

    // First: vertical first cut
    var firstV = 0
    while (firstV < cols - 1) {
      val leftOnes = onesIn(0, 0, rows - 1, firstV)
      val rightOnes = onesIn(0, firstV + 1, rows - 1, cols - 1)
      if (leftOnes > 0 && rightOnes > 0) {
        val leftOneRect = tightArea(0, 0, rows - 1, firstV)
        val rightTwoRects = bestTwo(0, firstV + 1, rows - 1, cols - 1)
        val alt1 = if (rightTwoRects < INF) leftOneRect + rightTwoRects else INF

        val rightOneRect = tightArea(0, firstV + 1, rows - 1, cols - 1)
        val leftTwoRects = bestTwo(0, 0, rows - 1, firstV)
        val alt2 = if (leftTwoRects < INF) rightOneRect + leftTwoRects else INF

        val cand = minOf(alt1, alt2)
        if (cand < answer) answer = cand
      }
      firstV += 1
    }

    // Then: horizontal first cut
    var firstH = 0
    while (firstH < rows - 1) {
      val topOnes = onesIn(0, 0, firstH, cols - 1)
      val botOnes = onesIn(firstH + 1, 0, rows - 1, cols - 1)
      if (topOnes > 0 && botOnes > 0) {
        val topOneRect = tightArea(0, 0, firstH, cols - 1)
        val botTwoRects = bestTwo(firstH + 1, 0, rows - 1, cols - 1)
        val alt1 = if (botTwoRects < INF) topOneRect + botTwoRects else INF

        val botOneRect = tightArea(firstH + 1, 0, rows - 1, cols - 1)
        val topTwoRects = bestTwo(0, 0, firstH, cols - 1)
        val alt2 = if (topTwoRects < INF) botOneRect + topTwoRects else INF

        val cand = minOf(alt1, alt2)
        if (cand < answer) answer = cand
      }
      firstH += 1
    }

    return answer
  }
}
