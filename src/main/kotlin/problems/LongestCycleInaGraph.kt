package problems

import kotlin.math.max // Or use maxOf

fun longestCycle(edges: IntArray): Int {
  val n = edges.size
  // Step 1: Initialize max_len
  var maxLen = -1
  // Step 2: Initialize visited array
  val visited = BooleanArray(n) { false }

  // Step 3: Loop through all nodes
  for (i in 0 until n) {
    // Step 4: Check if node i is already visited
    if (visited[i]) {
      continue
    }

    // Step 5: Start a new traversal from i
    var currentStep = 1
    var currentNode = i
    val pathNodes = mutableMapOf<Int, Int>() // Tracks {node -> step} for current path

    // Step 6: Traverse the current path
    while (currentNode != -1) {

      // 6a: Check for cycle
      if (pathNodes.containsKey(currentNode)) {
        val firstSeenStep = pathNodes[currentNode]!!
        val cycleLen = currentStep - firstSeenStep
        maxLen = maxOf(maxLen, cycleLen)
        break // Cycle found for this path
      }

      // 6b: Check for merge into visited
      if (visited[currentNode]) {
        break // Merged into already processed component
      }

      // 6c: Continue traversal
      visited[currentNode] = true         // Mark globally visited
      pathNodes[currentNode] = currentStep // Record node and step for this path

      currentNode = edges[currentNode] // Move to next node
      currentStep++                    // Increment step
    }
    // Step 7: Finish traversal (implicit when while loop ends/breaks)
  }

  // Step 8: Return max_len
  return maxLen
}

fun main() {
  // Test Case 1: Has a cycle of length 3
  val edges1 = intArrayOf(3, 3, 4, 2, 3)
  println("Test Case 1: edges = ${edges1.contentToString()}")
  println("Result 1: ${longestCycle(edges1)}") // Should be 3
    
  // Test Case 2: No cycle
  val edges2 = intArrayOf(2, -1, 3, 1)
  println("\nTest Case 2: edges = ${edges2.contentToString()}")
  println("Result 2: ${longestCycle(edges2)}") // Should be -1
    
  // Test Case 3: Single node cycle
  val edges3 = intArrayOf(1, 0)
  println("\nTest Case 3: edges = ${edges3.contentToString()}")
  println("Result 3: ${longestCycle(edges3)}") // Should be 2
}
// println("Longest cycle for edges2: $result2")