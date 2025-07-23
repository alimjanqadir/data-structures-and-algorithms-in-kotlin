package problems

/**
 * Problem 129: Sum Root to Leaf Numbers
 * Time Complexity: O(N) where N is the number of nodes
 * Space Complexity: O(H) where H is the height of the tree, for recursion stack
 */


/**
 * Calculates the sum of all root-to-leaf paths where each path represents a number.
 * Uses DFS (Depth-First Search) with a running sum to compute all path numbers.
 *
 * @param root The root node of the binary tree
 * @return The total sum of all root-to-leaf numbers
 */
private fun sumNumbers(root: TreeNode?): Int {
  return dfs(root, 0)
}

/**
 * Helper function that performs DFS traversal.
 *
 * @param node Current node being processed
 * @param currentSum Running sum from root to current node
 * @return Sum of all paths in the current subtree
 */
private fun dfs(node: TreeNode?, currentSum: Int): Int {
  // Base case: null node
  if (node == null) return 0

  // Calculate the current number in the path
  val newSum = currentSum * 10 + node.`val`

  // If it's a leaf node, return the current number
  if (node.left == null && node.right == null) {
    return newSum
  }

  // Recurse on left and right children and return their sum
  return dfs(node.left, newSum) + dfs(node.right, newSum)
}

/**
 * Test cases to verify the solution
 */
