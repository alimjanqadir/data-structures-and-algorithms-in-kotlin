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


fun main() {
  // Test case 1: Expected output 3
  val gas1 = intArrayOf(1, 2, 3, 4, 5)
  val cost1 = intArrayOf(3, 4, 5, 1, 2)
  assert(canCompleteCircuit(gas1, cost1) == 3) { "Test case 1 failed" }
  // Test case 2: Expected output -1
  val gas2 = intArrayOf(2, 3, 4)
  val cost2 = intArrayOf(3, 4, 3)
  assert(canCompleteCircuit(gas2, cost2) == -1) { "Test case 2 failed" }
  // Test case 3: Expected output 0
  val gas3 = intArrayOf(5)
  val cost3 = intArrayOf(4)
  assert(canCompleteCircuit(gas3, cost3) == 0) { "Test case 3 failed" }
  // Test case 4: Expected output -1
  val gas4 = intArrayOf(1, 2, 3, 4, 5)
  val cost4 = intArrayOf(6, 6, 6, 6, 6)
  assert(canCompleteCircuit(gas4, cost4) == -1) { "Test case 4 failed" }
  // Test case 5: Expected output 4
  val gas5 = intArrayOf(3, 1, 1)
  val cost5 = intArrayOf(1, 2, 2)
  assert(canCompleteCircuit(gas5, cost5) == 0) { "Test case 5 failed" }
  println("All test cases passed!")
}