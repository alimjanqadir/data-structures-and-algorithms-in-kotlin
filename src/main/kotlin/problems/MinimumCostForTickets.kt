package problems

/**
 * Calculates the minimum cost for tickets using a brute-force recursive approach.
 *
 * @param days An array of integers representing the days on which you will travel.
 * @param costs An array of three integers representing the cost of each ticket type.
 * @return The minimum total cost to cover all travel days.
 */
fun mincostTicketsBruteForce(days: IntArray, costs: IntArray): Int {
  // Convert days to a set for O(1) lookups.
  val daySet = days.toSet()

  /**
   * Recursive helper function to compute the minimum cost starting from a given day.
   *
   * @param day The current day to consider.
   * @return The minimum cost starting from the current day.
   */
  fun dfs(day: Int): Int {
    // Base case: No more days to consider.
    if (day > 365) return 0
    // If not a travel day, move to the next day.
    if (day !in daySet) return dfs(day + 1)
    // Consider all ticket options.
    val cost1 = costs[0] + dfs(day + 1)    // 1-day ticket
    val cost7 = costs[1] + dfs(day + 7)    // 7-day ticket
    val cost30 = costs[2] + dfs(day + 30)  // 30-day ticket
    // Return the minimum cost.
    return minOf(cost1, cost7, cost30)
  }

  // Start recursion from the first travel day.
  return dfs(days[0])
}

/**
 * Calculates the minimum cost for tickets using dynamic programming.
 *
 * @param days An array of integers representing the days on which you will travel.
 * @param costs An array of three integers representing the cost of each ticket type.
 * @return The minimum total cost to cover all travel days.
 */
fun mincostTicketsDP(days: IntArray, costs: IntArray): Int {
  val maxDay = days.last()          // Last day of travel
  val daySet = days.toSet()         // Set for O(1) day checks
  val dp = IntArray(maxDay + 1)    // DP array to store min cost up to each day

  for (day in 1..maxDay) {
    if (day !in daySet) {
      // If not a travel day, cost remains the same as previous day.
      dp[day] = dp[day - 1]
    } else {
      // Calculate minimum cost among the three ticket options.
      val cost1 = dp.getOrElse(day - 1) { 0 } + costs[0]   // 1-day ticket
      val cost7 = dp.getOrElse(day - 7) { 0 } + costs[1]   // 7-day ticket
      val cost30 = dp.getOrElse(day - 30) { 0 } + costs[2] // 30-day ticket
      dp[day] = minOf(cost1, cost7, cost30)
    }
  }
  return dp[maxDay]
}

fun mincostTicketsFunctional(days: IntArray, costs: IntArray): Int {
  val travelDaysSet = days.toSet()
  val finalDay = days.last()
  val memoizationCache = mutableMapOf<Int, Int>()

  /**
   * Recursively calculates the minimum cost starting from the specified day.
   *
   * @param currentDay The day from which to calculate the minimum cost.
   * @return The minimum cost from the current day to the end.
   */
  fun calculateMinimumCost(currentDay: Int): Int {
    if (currentDay > finalDay) return 0
    if (currentDay !in travelDaysSet) return calculateMinimumCost(currentDay + 1)
    if (memoizationCache.containsKey(currentDay)) return memoizationCache[currentDay]!!

    val minimumCost = listOf(
      costs[0] + calculateMinimumCost(currentDay + 1),   // 1-day ticket
      costs[1] + calculateMinimumCost(currentDay + 7),   // 7-day ticket
      costs[2] + calculateMinimumCost(currentDay + 30)   // 30-day ticket
    ).minOrNull()!!

    memoizationCache[currentDay] = minimumCost
    return minimumCost
  }

  return calculateMinimumCost(days[0])
}

