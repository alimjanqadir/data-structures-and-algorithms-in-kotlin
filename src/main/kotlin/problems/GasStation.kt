package problems

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
  var totalTank = 0
  var currTank = 0
  var startingStation = 0
  for (i in gas.indices) {
    val diff = gas[i] - cost[i]
    totalTank += diff
    currTank += diff
    // If current tank is negative, reset starting station
    if (currTank < 0) {
      startingStation = i + 1
      currTank = 0
    }
  }
  return if (totalTank >= 0) startingStation % gas.size else -1
}

fun canCompleteCircuitFunctional(gas: IntArray, cost: IntArray): Int {
  data class State(val totalTank: Int, val currTank: Int, val start: Int)

  val n = gas.size
  val result = (0 until n).fold(State(0, 0, 0)) { state, i ->
    val diff = gas[i] - cost[i]
    val total = state.totalTank + diff
    val current = state.currTank + diff
    if (current < 0) {
      State(total, 0, i + 1)
    } else {
      State(total, current, state.start)
    }
  }
  return if (result.totalTank >= 0) result.start % n else -1
}


