package problems

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
  if (root == null) return emptyList()

  val result = mutableListOf<List<Int>>()
  val queue = ArrayDeque<TreeNode>()
  queue.addLast(root)
  var leftToRight = true

  while (queue.isNotEmpty()) {
    val levelSize = queue.size
    val currentLevel = mutableListOf<Int>()

    // Process current level
    repeat(levelSize) {
      val node = queue.removeFirst()

      // Add value to current level based on direction
      if (leftToRight) {
        currentLevel.add(node.`val`)
      } else {
        currentLevel.add(0, node.`val`)
      }

      // Add children to queue for next level
      node.left?.let { queue.addLast(it) }
      node.right?.let { queue.addLast(it) }
    }

    result.add(currentLevel)
    leftToRight = !leftToRight
  }

  return result
}

/**
 * Test cases
 */
