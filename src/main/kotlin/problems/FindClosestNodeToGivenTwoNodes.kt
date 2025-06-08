package problems

fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
  val nodeCount = edges.size
  // Initialize distances with -1 (meaning unreachable)
  val distanceFromFirst = IntArray(nodeCount) { -1 }
  val distanceFromSecond = IntArray(nodeCount) { -1 }

  // Helper to fill distances from a given start node
  fun fillDistances(startNode: Int, distances: IntArray) {
    var currentNode = startNode
    var stepCount = 0
    // Track visited to avoid infinite loops
    val visited = BooleanArray(nodeCount)
    while (currentNode != -1 && !visited[currentNode]) {
      visited[currentNode] = true
      distances[currentNode] = stepCount
      val nextNode = edges[currentNode]
      currentNode = nextNode
      stepCount++
    }
  }


  // Compute distances from both start nodes
  fillDistances(node1, distanceFromFirst)
  fillDistances(node2, distanceFromSecond)


  // Search for the best meeting node
  var bestNode = -1
  var bestScore = Int.MAX_VALUE

  for (candidate in 0 until nodeCount) {
    val dist1 = distanceFromFirst[candidate]
    val dist2 = distanceFromSecond[candidate]
    if (dist1 >= 0 && dist2 >= 0) {
      val score = maxOf(dist1, dist2)
      if (score < bestScore || (score == bestScore && candidate < bestNode)) {
        bestScore = score
        bestNode = candidate
      }
    }
  }


  return bestNode
}
