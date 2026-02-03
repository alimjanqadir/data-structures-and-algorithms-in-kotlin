package problems

fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
  val dp = Array(m + 1) { IntArray(n + 1) }
  for (str in strs) {
    val zeros = str.count { it == '0' }
    val ones = str.length - zeros
    for (j in m downTo zeros) {
      for (k in n downTo ones) {
        dp[j][k] = maxOf(dp[j][k], dp[j - zeros][k - ones] + 1)
      }
    }
  }
  return dp[m][n]
}
