class Solution {
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val rows = grid.size
        val cols = grid[0].size

        // dp[row][col][cost] = max score
        val dp = Array(rows) {
            Array(cols) { IntArray(k + 1) { -1 } }
        }

        dp[0][0][0] = 0

        for (row in 0 until rows) {
            for (col in 0 until cols) {
                for (costUsed in 0..k) {
                    val currentScore = dp[row][col][costUsed]
                    if (currentScore == -1) continue

                    // move right
                    if (col + 1 < cols) {
                        val value = grid[row][col + 1]
                        val extraCost = if (value == 0) 0 else 1
                        val extraScore = value

                        val newCost = costUsed + extraCost
                        if (newCost <= k) {
                            dp[row][col + 1][newCost] =
                                maxOf(dp[row][col + 1][newCost], currentScore + extraScore)
                        }
                    }

                    // move down
                    if (row + 1 < rows) {
                        val value = grid[row + 1][col]
                        val extraCost = if (value == 0) 0 else 1
                        val extraScore = value

                        val newCost = costUsed + extraCost
                        if (newCost <= k) {
                            dp[row + 1][col][newCost] =
                                maxOf(dp[row + 1][col][newCost], currentScore + extraScore)
                        }
                    }
                }
            }
        }

        var answer = -1
        for (cost in 0..k) {
            answer = maxOf(answer, dp[rows - 1][cols - 1][cost])
        }

        return answer
    }
}
