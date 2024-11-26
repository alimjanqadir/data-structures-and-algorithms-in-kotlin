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
fun main() {
  val test1 = TreeNode(3).apply {
    left = TreeNode(9)
    right = TreeNode(20).apply {
      left = TreeNode(15)
      right = TreeNode(7)
    }
  }

  val test2 = TreeNode(1)

  val test3 = null

  val test4 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4)
    }
    right = TreeNode(3).apply {
      right = TreeNode(5)
    }
  }

  val testCases = listOf(test1, test2, test3, test4)

  testCases.forEachIndexed { index, root ->
    val result = zigzagLevelOrder(root)
    println("Test case ${index + 1}: $result")
  }
}