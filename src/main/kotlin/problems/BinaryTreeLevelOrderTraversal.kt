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
fun main() {
  // Test Case 1: Example from problem
  val root1 = TreeNode(3).apply {
    left = TreeNode(9)
    right = TreeNode(20).apply {
      left = TreeNode(15)
      right = TreeNode(7)
    }
  }
  println("Test Case 1: ${levelOrder(root1)}")
  // Expected: [[3], [9,20], [15,7]]

  // Test Case 2: Single node
  val root2 = TreeNode(1)
  println("Test Case 2: ${levelOrder(root2)}")
  // Expected: [[1]]

  // Test Case 3: Empty tree
  println("Test Case 3: ${levelOrder(null)}")
  // Expected: []

  // Test Case 4: Unbalanced tree
  val root4 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4)
    }
    right = TreeNode(3)
  }
  println("Test Case 4: ${levelOrder(root4)}")
  // Expected: [[1], [2,3], [4]]
}