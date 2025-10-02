package problems

fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
  var totalDrunk = numBottles
  var emptyBottles = numBottles
  var currentCost = numExchange

  while (emptyBottles >= currentCost) {
    emptyBottles = emptyBottles - currentCost + 1
    totalDrunk += 1
    currentCost += 1
  }
  return totalDrunk
}
