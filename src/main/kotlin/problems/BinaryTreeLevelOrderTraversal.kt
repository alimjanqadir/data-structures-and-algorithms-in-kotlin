package problems

private fun levelOrder(root: TreeNode?): List<List<Int>> {
  if (root == null) return emptyList()

  val result = mutableListOf<List<Int>>()
  val queue = ArrayDeque<TreeNode>()
  queue.addLast(root)

  while (queue.isNotEmpty()) {
    val levelSize = queue.size
    val currentLevel = mutableListOf<Int>()

    // Process all nodes at current level
    repeat(levelSize) {
      val node = queue.removeFirst()
      currentLevel.add(node.`val`)

      // Add children for next level processing
      node.left?.let { queue.addLast(it) }
      node.right?.let { queue.addLast(it) }
    }

    result.add(currentLevel)
  }

  return result
}

/**
 * Test cases
 */
