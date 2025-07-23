package problems

private class Node(
  var `val`: Int = 0,
  var neighbors: MutableList<Node> = mutableListOf()
)

private fun cloneGraph(node: Node?): Node? {
  // We can move the visited map inside the function
  // This provides better memory management as it's cleared after each call
  return node?.let { dfs(it, HashMap()) }
}

private fun dfs(node: Node, visited: MutableMap<Node, Node>): Node {
  // Check if we've already cloned this node
  visited[node]?.let { return it }

  // Create clone and immediately add to visited map
  return Node(node.`val`).also { clone ->
    visited[node] = clone
    // Use map instead of for-loop for more idiomatic Kotlin
    clone.neighbors = node.neighbors
      .map { dfs(it, visited) }
      .toMutableList()
  }
}

