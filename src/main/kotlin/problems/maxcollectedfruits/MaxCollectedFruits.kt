package problems.maxcollectedfruits

class Solution {

  fun maxCollectedFruits(fruits: Array<IntArray>): Int {
    val n = fruits.size
    val negInf = Int.MIN_VALUE / 4      // safe sentinel

    /*--- Child A: main diagonal (forced path) ---*/
    var diagonal = 0
    for (i in 0 until n) diagonal += fruits[i][i]

    /*--- DP helper used twice (for B and C) ---*/
    fun bestScore(
      take: (step: Int, idx: Int) -> Int,          // fruit amount at (row, col)
      startIdx: Int                                // B: last column, C: last row
    ): Int {
      var prev = IntArray(n) { negInf }
      prev[startIdx] = take(0, startIdx)           // collect at starting room

      for (step in 1 until n) {
        val cur = IntArray(n) { negInf }
        for (idx in 0 until n) {
          val base = prev[idx]
          if (base == negInf) continue
          for (shift in -1..1) {
            val next = idx + shift
            if (next !in 0 until n) continue
            var score = base
            if (next != step) score += take(step, next)   // skip duplicates on the diagonal
            if (score > cur[next]) cur[next] = score
          }
        }
        prev = cur
      }
      return prev[startIdx]                          // must finish on the border
    }

    /* Child B: starts (0,n-1) – index = column */
    val addB = bestScore(
      take = { row, col -> fruits[row][col] },
      startIdx = n - 1
    )

    /* Child C: starts (n-1,0) – index = row; column == step */
    val addC = bestScore(
      take = { row, col /* here: row */ -> fruits[col][row] }, // transpose lookup
      startIdx = n - 1
    )

    return diagonal + addB + addC
  }
}
