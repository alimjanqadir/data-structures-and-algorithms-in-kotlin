package problems

private fun maxPathSum(root: TreeNode?): Int {
  var maxPathSum = Int.MIN_VALUE

  fun findSubTreeMaxPathSum(node: TreeNode?): Int {
    if (node == null) return 0

    val leftMax = maxOf(findSubTreeMaxPathSum(node.left), 0)
    val rightMax = maxOf(findSubTreeMaxPathSum(node.right), 0)

    val currentPathSum = leftMax + node.`val` + rightMax
    maxPathSum = maxOf(maxPathSum, currentPathSum)

    return node.`val` + maxOf(leftMax, rightMax)
  }

  if (root == null) return 0
  findSubTreeMaxPathSum(root)
  return maxPathSum
}

