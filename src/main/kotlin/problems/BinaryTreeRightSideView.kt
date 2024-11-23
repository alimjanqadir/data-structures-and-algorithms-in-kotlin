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
fun main() {
  // Test Case 1: Example from problem
  val tree1 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(5)
    }
    right = TreeNode(3).apply {
      right = TreeNode(4)
    }
  }
  println("Test 1: ${rightSideView(tree1)} == [1,3,4]") // [1,3,4]

  // Test Case 2: Right-skewed tree
  val tree2 = TreeNode(1).apply {
    right = TreeNode(2).apply {
      right = TreeNode(3)
    }
  }
  println("Test 2: ${rightSideView(tree2)} == [1,2,3]") // [1,2,3]

  // Test Case 3: Left-skewed tree
  val tree3 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(3)
    }
  }
  println("Test 3: ${rightSideView(tree3)} == [1,2,3]") // [1,2,3]

  // Test Case 4: Empty tree
  println("Test 4: ${rightSideView(null)} == []") // []

  // Test Case 5: Single node
  println("Test 5: ${rightSideView(TreeNode(1))} == [1]") // [1]
}