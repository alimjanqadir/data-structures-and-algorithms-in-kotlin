package problems

fun earliestAndLatest(
  totalNumberOfPlayers: Int,
  firstFavoritePlayer: Int,
  secondFavoritePlayer: Int
): IntArray {
  val lowerFavoritePlayer = minOf(firstFavoritePlayer, secondFavoritePlayer)
  val higherFavoritePlayer = maxOf(firstFavoritePlayer, secondFavoritePlayer)
  val memoizedResults = mutableMapOf<Int, IntArray>()

  fun computeRounds(currentPlayersBitmask: Int): IntArray {
    memoizedResults[currentPlayersBitmask]?.let { return it }

    val activePlayers = mutableListOf<Int>()
    for (playerNumber in 1..totalNumberOfPlayers) {
      if ((currentPlayersBitmask shr (playerNumber - 1) and 1) == 1) activePlayers += playerNumber
    }
    val numberOfActivePlayers = activePlayers.size
    val numberOfMatchesThisRound = numberOfActivePlayers / 2

    for (matchIndex in 0 until numberOfMatchesThisRound) {
      val playerFromStart = activePlayers[matchIndex]
      val playerFromEnd = activePlayers[numberOfActivePlayers - 1 - matchIndex]
      if ((playerFromStart == lowerFavoritePlayer && playerFromEnd == higherFavoritePlayer) ||
        (playerFromStart == higherFavoritePlayer && playerFromEnd == lowerFavoritePlayer)
      ) {
        return intArrayOf(1, 1).also { memoizedResults[currentPlayersBitmask] = it }
      }
    }

    val nextRoundBitmaskOptions = mutableSetOf<Int>()

    fun generateNextRoundConfigurations(currentMatchNumber: Int, accumulatedBitmask: Int) {
      if (currentMatchNumber == numberOfMatchesThisRound) {
        val finalBitmask = if (numberOfActivePlayers and 1 == 1)
          accumulatedBitmask or (1 shl (activePlayers[numberOfMatchesThisRound] - 1))
        else
          accumulatedBitmask
        nextRoundBitmaskOptions += finalBitmask
        return
      }

      val playerOnLeft = activePlayers[currentMatchNumber]
      val playerOnRight = activePlayers[numberOfActivePlayers - 1 - currentMatchNumber]

      when {
        playerOnLeft == lowerFavoritePlayer || playerOnLeft == higherFavoritePlayer -> {
          generateNextRoundConfigurations(currentMatchNumber + 1, accumulatedBitmask or (1 shl (playerOnLeft - 1)))
        }
        playerOnRight == lowerFavoritePlayer || playerOnRight == higherFavoritePlayer -> {
          generateNextRoundConfigurations(currentMatchNumber + 1, accumulatedBitmask or (1 shl (playerOnRight - 1)))
        }
        else -> {
          generateNextRoundConfigurations(currentMatchNumber + 1, accumulatedBitmask or (1 shl (playerOnLeft - 1)))
          generateNextRoundConfigurations(currentMatchNumber + 1, accumulatedBitmask or (1 shl (playerOnRight - 1)))
        }
      }
    }

    generateNextRoundConfigurations(0, 0)

    var earliestPossibleRound = Int.MAX_VALUE
    var latestPossibleRound = Int.MIN_VALUE
    for (nextRoundBitmask in nextRoundBitmaskOptions) {
      val roundsResult = computeRounds(nextRoundBitmask)
      earliestPossibleRound = minOf(earliestPossibleRound, roundsResult[0] + 1)
      latestPossibleRound = maxOf(latestPossibleRound, roundsResult[1] + 1)
    }
    return intArrayOf(earliestPossibleRound, latestPossibleRound)
      .also { memoizedResults[currentPlayersBitmask] = it }
  }

  val initialFullPlayerBitmask = (1 shl totalNumberOfPlayers) - 1
  return computeRounds(initialFullPlayerBitmask)
}
