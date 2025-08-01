package problems

/**
 * Validates if a binary tree is a valid Binary Search Tree (BST).
 * Uses a range-based approach where each node's value must fall within
 * an allowed range determined by its position in the tree.
 *
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
 */
private fun isValidBST(root: TreeNode?): Boolean {
  // We use Long to handle edge cases where node values are at Int boundaries
  return isValidBSTInRange(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

/**
 * Helper function that performs recursive validation with range checking.
 * Each node's value must be strictly within the given range (minValue, maxValue).
 */
private fun isValidBSTInRange(node: TreeNode?, minValue: Long, maxValue: Long): Boolean {
  // Base case: empty trees are valid BSTs
  if (node == null) {
    return true
  }

  // Convert current node's value to Long to prevent integer overflow
  val currentValue = node.`val`.toLong()

  // Check if current node's value falls within the valid range
  if (currentValue <= minValue || currentValue >= maxValue) {
    return false
  }

  // Recursively validate left and right subtrees with updated ranges
  return isValidBSTInRange(node.left, minValue, currentValue) &&
    isValidBSTInRange(node.right, currentValue, maxValue)
}

/**
 * Test cases to verify the solution
 */
