package problems

fun minCost(grid: Array<IntArray>, k: Int): Int {
  val m = grid.size
  val n = grid[0].size
  val INF = 1_000_000_000 // safer than Int.MAX_VALUE / 2 to avoid overflow issues

  // dp[t][i][j] = min cost to reach (i,j) using exactly t teleports
  val dp = Array(k + 1) { Array(m) { IntArray(n) { INF } } }

  // Starting point: cost 0, no teleport used
  dp[0][0][0] = 0

  // Fill the no-teleport layer (t = 0) — only right and down moves
  for (i in 0 until m) {
    for (j in 0 until n) {
      if (i == 0 && j == 0) continue
      var minPrev = INF
      if (i > 0) minPrev = minOf(minPrev, dp[0][i - 1][j])
      if (j > 0) minPrev = minOf(minPrev, dp[0][i][j - 1])
      if (minPrev != INF) {
        dp[0][i][j] = minPrev + grid[i][j]
      }
    }
  }

  // Group cells by their value
  val valueToCells = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
  val allValues = mutableSetOf<Int>()

  for (i in 0 until m) {
    for (j in 0 until n) {
      val v = grid[i][j]
      allValues.add(v)
      valueToCells.computeIfAbsent(v) { mutableListOf() }.add(i to j)
    }
  }

  val sortedValues = allValues.toList().sorted()

  // For each additional teleport count
  for (t in 1..k) {
    // suffixMin[idx] = min cost among all cells with value >= sortedValues[idx] using t-1 teleports
    val suffixMin = IntArray(sortedValues.size) { INF }
    var runningMin = INF

    // Build suffix minima from highest value to lowest
    for (idx in sortedValues.indices.reversed()) {
      val v = sortedValues[idx]
      valueToCells[v]?.forEach { (x, y) ->
        runningMin = minOf(runningMin, dp[t - 1][x][y])
      }
      suffixMin[idx] = runningMin
    }

    // Now update dp[t] for every cell
    for (i in 0 until m) {
      for (j in 0 until n) {
        val v = grid[i][j]
        var cand = INF

        // Case 1: arrive via normal move (left or up), same t, add grid[i][j]
        if (i > 0) cand = minOf(cand, dp[t][i - 1][j] + grid[i][j])
        if (j > 0) cand = minOf(cand, dp[t][i][j - 1] + grid[i][j])

        // Case 2: arrive via teleport (from t-1), cost +0, do NOT add grid[i][j]
        val pos = sortedValues.binarySearch(v)
        val startIdx = if (pos >= 0) pos else -pos - 1
        if (startIdx < sortedValues.size) {
          cand = minOf(cand, suffixMin[startIdx])
        }

        dp[t][i][j] = minOf(dp[t][i][j], cand)
      }
    }
  }

  // Find the minimum cost over all possible teleport counts
  var ans = INF
  for (t in 0..k) {
    ans = minOf(ans, dp[t][m - 1][n - 1])
  }

  return if (ans == INF) -1 else ans // though problem guarantees reachability
}
