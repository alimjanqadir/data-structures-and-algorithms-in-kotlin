package problems

/**
 * Solution for LeetCode #104: Maximum Depth of Binary Tree
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
 */

/**
 * Returns the maximum depth of a binary tree using a recursive approach.
 * The depth is the number of nodes along the longest path from root to leaf.
 */
private fun maxDepth(root: TreeNode?): Int {
  // Base case: empty tree has depth 0
  if (root == null) return 0

  // Recursive case: depth is max of left and right subtrees, plus 1 for current node
  return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
}

/**
 * Alternative iterative solution using level-order traversal (BFS)
 * This can be useful when stack space is a concern
 */
private fun maxDepthIterative(root: TreeNode?): Int {
  if (root == null) return 0

  var depth = 0
  val queue = ArrayDeque<TreeNode>()
  queue.addLast(root)

  while (queue.isNotEmpty()) {
    depth++
    // Process all nodes at current level
    repeat(queue.size) {
      val node = queue.removeFirst()
      node.left?.let { queue.addLast(it) }
      node.right?.let { queue.addLast(it) }
    }
  }

  return depth
}

/**
 * Test cases to verify the solution
 */
