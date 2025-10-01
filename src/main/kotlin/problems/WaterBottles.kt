package problems

fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
  val additionalFromExchanges = (numBottles - 1) / (numExchange - 1)
  return numBottles + additionalFromExchanges
}
