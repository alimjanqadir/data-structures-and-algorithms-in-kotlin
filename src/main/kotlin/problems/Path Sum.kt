package problems

/**
 * Determines if there exists a root-to-leaf path that sums to targetSum.
 *
 * Time Complexity: O(N) where N is the number of nodes in the tree
 * Space Complexity: O(H) where H is the height of the tree (due to recursion stack)
 *                  In worst case (skewed tree) O(N), in balanced tree O(log N)
 */
private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
  // Base case: empty tree
  if (root == null) return false

  // If we're at a leaf node, check if the remaining sum equals this node's value
  if (root.left == null && root.right == null) {
    return targetSum == root.`val`
  }

  // Recursively check left and right subtrees with reduced target sum
  val remainingSum = targetSum - root.`val`
  return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum)
}

/**
 * Example usage:
 */
