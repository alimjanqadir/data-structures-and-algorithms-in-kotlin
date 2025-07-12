package problems

fun earliestAndLatest(n: Int, firstPlayer: Int, secondPlayer: Int): IntArray {
  val originalPlayers = n
  val favouriteA = minOf(firstPlayer, secondPlayer)
  val favouriteB = maxOf(firstPlayer, secondPlayer)
  val startMask = (1 until n).fold(1) { m, i -> m or (1 shl i) }
  val memo = HashMap<Int, IntArray>()

  fun dfs(mask: Int): IntArray {
    memo[mask]?.let { return it }

    val currentRow = mutableListOf<Int>()
    for (player in 1..originalPlayers) {
      if ((mask shr (player - 1) and 1) == 1) currentRow += player
    }
    val playersNow = currentRow.size
    val halfPairs = playersNow / 2

    for (i in 0 until halfPairs) {
      val left = currentRow[i]
      val right = currentRow[playersNow - 1 - i]
      if ((left == favouriteA && right == favouriteB) ||
        (left == favouriteB && right == favouriteA)
      ) {
        val result = intArrayOf(1, 1)
        memo[mask] = result
        return result
      }
    }

    val nextMasks = HashSet<Int>()

    fun dfsPairs(pairIdx: Int, nextMask: Int) {
      if (pairIdx == halfPairs) {
        val finalMask = if (playersNow and 1 == 1)
          nextMask or (1 shl (currentRow[halfPairs] - 1))
        else
          nextMask
        nextMasks += finalMask
        return
      }

      val left = currentRow[pairIdx]
      val right = currentRow[playersNow - 1 - pairIdx]
      when {
        left == favouriteA || left == favouriteB -> dfsPairs(pairIdx + 1, nextMask or (1 shl (left - 1)))
        right == favouriteA || right == favouriteB -> dfsPairs(pairIdx + 1, nextMask or (1 shl (right - 1)))
        else -> {
          dfsPairs(pairIdx + 1, nextMask or (1 shl (left - 1)))
          dfsPairs(pairIdx + 1, nextMask or (1 shl (right - 1)))
        }
      }
    }

    dfsPairs(0, 0)

    var earliest = Int.MAX_VALUE
    var latest = Int.MIN_VALUE
    for (next in nextMasks) {
      val sub = dfs(next)
      earliest = minOf(earliest, sub[0] + 1)
      latest = maxOf(latest, sub[1] + 1)
    }
    val res = intArrayOf(earliest, latest)
    memo[mask] = res
    return res
  }

  return dfs(startMask)
}
