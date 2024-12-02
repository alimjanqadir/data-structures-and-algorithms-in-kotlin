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

fun main() {
  // Test case from problem
  val node1 = Node(1)
  val node2 = Node(2)
  val node3 = Node(3)
  val node4 = Node(4)

  node1.neighbors = mutableListOf(node2, node4)
  node2.neighbors = mutableListOf(node1, node3)
  node3.neighbors = mutableListOf(node2, node4)
  node4.neighbors = mutableListOf(node1, node3)

  val cloned = cloneGraph(node1)
  println("Original node: ${node1.`val`}")
  println("Cloned node: ${cloned?.`val`}")
  println("Neighbors match: ${node1.neighbors.map { it.`val` } == cloned?.neighbors?.map { it.`val` }}")
}