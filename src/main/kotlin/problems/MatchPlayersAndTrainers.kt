package problems

fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
  players.sort()
  trainers.sort()

  var playerIndex = 0
  var trainerIndex = 0
  var totalMatches = 0

  while (playerIndex < players.size && trainerIndex < trainers.size) {
    val ability = players[playerIndex]
    val capacity = trainers[trainerIndex]

    if (ability <= capacity) {
      totalMatches += 1
      playerIndex += 1
      trainerIndex += 1
    } else {
      trainerIndex += 1
    }
  }

  return totalMatches
}
