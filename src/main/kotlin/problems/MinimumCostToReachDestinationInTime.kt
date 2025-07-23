package problems

import java.util.PriorityQueue

fun minCost(maxTime: Int, edges: Array<IntArray>, passingFees: IntArray): Int {
  val n = passingFees.size
  // Create adjacency list representation of the graph
  val graph = Array(n) { mutableListOf<Pair<Int, Int>>() }
  for ((from, to, time) in edges) {
    graph[from].add(to to time)
    graph[to].add(from to time)
  }

  // dp[city][time] represents the minimum cost to reach city at given time
  val dp = Array(n) { IntArray(maxTime + 1) { Int.MAX_VALUE } }
  // Initialize starting point
  dp[0][0] = passingFees[0]

  // Priority queue to get the minimum cost path
  // Triple: (cost, city, time)
  val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
  pq.offer(Triple(passingFees[0], 0, 0))

  while (pq.isNotEmpty()) {
    val (cost, city, time) = pq.poll()

    // If we've found a better path already, skip this one
    if (cost > dp[city][time]) continue

    // Try all neighbors
    for ((nextCity, travelTime) in graph[city]) {
      val newTime = time + travelTime
      // Check if we're still within time limit
      if (newTime <= maxTime) {
        val newCost = cost + passingFees[nextCity]
        // If we found a better cost for this city at this time
        if (newCost < dp[nextCity][newTime]) {
          dp[nextCity][newTime] = newCost
          pq.offer(Triple(newCost, nextCity, newTime))
        }
      }
    }
  }

  // Find minimum cost among all possible times for the destination
  val minCost = dp[n - 1].minOrNull() ?: Int.MAX_VALUE
  return if (minCost == Int.MAX_VALUE) -1 else minCost
}

