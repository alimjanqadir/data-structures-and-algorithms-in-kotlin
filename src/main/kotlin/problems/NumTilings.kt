private const val MOD = 1_000_000_007

fun numTilings(width: Int): Int {
  if (width == 0) return 1          // empty board
  if (width == 1) return 1
  if (width == 2) return 2

  var waysLenMinus3 = 1             // F(0)
  var waysLenMinus2 = 1             // F(1)
  var waysLenMinus1 = 2             // F(2)

  for (currentLen in 3..width) {
    val currentWays =
      (2L * waysLenMinus1 + waysLenMinus3) % MOD
    waysLenMinus3 = waysLenMinus2
    waysLenMinus2 = waysLenMinus1
    waysLenMinus1 = currentWays.toInt()
  }
  return waysLenMinus1
}
