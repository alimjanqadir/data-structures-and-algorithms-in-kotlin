package problems

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
private fun rightSideView(root: TreeNode?): List<Int> {
  if (root == null) return emptyList()

  val result = mutableListOf<Int>()
  val queue = ArrayDeque<TreeNode>()
  queue.add(root)

  while (queue.isNotEmpty()) {
    val levelSize = queue.size

    // Process all nodes at current level
    repeat(levelSize) { index ->
      val node = queue.removeFirst()

      // If this is the last node in the current level, add it to result
      if (index == levelSize - 1) {
        result.add(node.`val`)
      }

      // Add children to queue for next level processing
      node.left?.let { queue.add(it) }
      node.right?.let { queue.add(it) }
    }
  }

  return result
}

/**
 * Test cases
 */
