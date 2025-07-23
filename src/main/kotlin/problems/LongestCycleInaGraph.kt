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

// println("Longest cycle for edges2: $result2")
