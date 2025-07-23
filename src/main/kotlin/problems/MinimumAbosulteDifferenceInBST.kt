package problems

private var minDiff = Int.MAX_VALUE
private var prevValue: Int? = null

private fun getMinimumDifference(root: TreeNode?): Int {
  // Reset class variables for each new call
  minDiff = Int.MAX_VALUE
  prevValue = null

  // Perform inorder traversal
  inorderTraversal(root)
  return minDiff
}

private fun inorderTraversal(node: TreeNode?) {
  if (node == null) return

  // Process left subtree
  inorderTraversal(node.left)

  // Process current node
  // Since this is BST, inorder traversal gives values in ascending order
  prevValue?.let { prev ->
    minDiff = minOf(minDiff, Math.abs(node.`val` - prev))
  }
  prevValue = node.`val`

  // Process right subtree
  inorderTraversal(node.right)
}

