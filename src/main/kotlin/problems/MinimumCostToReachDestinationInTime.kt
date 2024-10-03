package problems

import java.util.*

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

fun main() {
    // Test case 1
    val test1MaxTime = 30
    val test1Edges = arrayOf(
        intArrayOf(0, 1, 10),
        intArrayOf(1, 2, 10),
        intArrayOf(2, 5, 10),
        intArrayOf(0, 3, 1),
        intArrayOf(3, 4, 10),
        intArrayOf(4, 5, 15)
    )
    val test1Fees = intArrayOf(5, 1, 2, 20, 20, 3)
    assert(minCost(test1MaxTime, test1Edges, test1Fees) == 11) { "Test case 1 failed" }

    // Test case 2
    val test2MaxTime = 29
    assert(minCost(test2MaxTime, test1Edges, test1Fees) == 48) { "Test case 2 failed" }

    // Test case 3
    val test3MaxTime = 25
    assert(minCost(test3MaxTime, test1Edges, test1Fees) == -1) { "Test case 3 failed" }

    // Test case 4 - Single edge
    val test4MaxTime = 10
    val test4Edges = arrayOf(intArrayOf(0, 1, 5))
    val test4Fees = intArrayOf(2, 3)
    assert(minCost(test4MaxTime, test4Edges, test4Fees) == 5) { "Test case 4 failed" }

    // Test case 5 - No possible path within time
    val test5MaxTime = 4
    assert(minCost(test5MaxTime, test4Edges, test4Fees) == -1) { "Test case 5 failed" }

    println("All test cases passed!")

    // Optional: Print detailed results for verification
    println("Detailed test results:")
    println("Test 1 (maxTime=30): ${minCost(test1MaxTime, test1Edges, test1Fees)}")
    println("Test 2 (maxTime=29): ${minCost(test2MaxTime, test1Edges, test1Fees)}")
    println("Test 3 (maxTime=25): ${minCost(test3MaxTime, test1Edges, test1Fees)}")
    println("Test 4 (single edge): ${minCost(test4MaxTime, test4Edges, test4Fees)}")
    println("Test 5 (no path): ${minCost(test5MaxTime, test4Edges, test4Fees)}")
}