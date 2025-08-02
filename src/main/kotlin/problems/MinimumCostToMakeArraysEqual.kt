package problems

fun minCost(basket1: IntArray, basket2: IntArray): Long {
  // 1. Frequency difference and global minimum
  val differenceByCost = HashMap<Int, Int>()
  var globalMinimumCost = Int.MAX_VALUE

  fun updateMap(cost: Int, delta: Int) {
    differenceByCost[cost] = (differenceByCost[cost] ?: 0) + delta
    if (cost < globalMinimumCost) globalMinimumCost = cost
  }

  basket1.forEach { updateMap(it, +1) }
  basket2.forEach { updateMap(it, -1) }

  // 2. Build surplus lists and feasibility check
  val surplusFromFirst = mutableListOf<Int>()
  val surplusFromSecond = mutableListOf<Int>()

  for ((cost, diff) in differenceByCost) {
    if (diff % 2 != 0) return -1L          // impossible
    val movesNeeded = kotlin.math.abs(diff) / 2
    repeat(movesNeeded) {
      if (diff > 0) surplusFromFirst.add(cost)   // extra in basket1
      else if (diff < 0) surplusFromSecond.add(cost) // extra in basket2
    }
  }

  if (surplusFromFirst.isEmpty()) return 0L          // already equal

  // 3. Optimal pairing
  surplusFromFirst.sort()               // ascending
  surplusFromSecond.sortDescending()    // descending

  // 4. Compute total minimal cost
  var totalCost = 0L
  for (index in surplusFromFirst.indices) {
    val directSwapCost = kotlin.math.min(
      surplusFromFirst[index],
      surplusFromSecond[index]
    )
    val mediatedSwapCost = 2 * globalMinimumCost
    totalCost += kotlin.math.min(directSwapCost, mediatedSwapCost).toLong()
  }

  return totalCost
}
