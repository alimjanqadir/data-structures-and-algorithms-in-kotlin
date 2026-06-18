package problems

fun minimumCost(cost: IntArray): Int {
  val sortedCosts = cost.sortedArrayDescending()
  var totalCost = 0
  var candyIndex = 0

  while (candyIndex < sortedCosts.size) {
    totalCost += sortedCosts[candyIndex]

    if (candyIndex + 1 < sortedCosts.size) {
      totalCost += sortedCosts[candyIndex + 1]
    }

    candyIndex += 3
  }

  return totalCost
}
