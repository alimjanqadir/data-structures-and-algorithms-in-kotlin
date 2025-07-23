package problems

private var maxPathSum = Int.MIN_VALUE

private fun maxPathSum(root: TreeNode?): Int {
  if (root == null) return 0
  maxGain(root)
  return maxPathSum
}

/**
 * Calculate maximum contribution that the subtree can add to its parent path
 * While also updating the global maximum path sum
 */
private fun maxGain(node: TreeNode?): Int {
  if (node == null) return 0

  // Get maximum path sums from left and right subtrees
  // Only include positive contributions
  val leftGain = maxOf(maxGain(node.left), 0)
  val rightGain = maxOf(maxGain(node.right), 0)

  // Calculate price of path that includes node and maybe both children
  val priceNewPath = node.`val` + leftGain + rightGain

  // Update global maximum if this path is better
  maxPathSum = maxOf(maxPathSum, priceNewPath)

  // Return maximum contribution this node can add to parent path
  // (can only use one child path, not both)
  return node.`val` + maxOf(leftGain, rightGain)
}

/**
 * Test cases
 */
