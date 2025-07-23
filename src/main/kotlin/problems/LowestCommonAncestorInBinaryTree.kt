import problems.TreeNode

/**
 * Definition for a binary tree node.
 */
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
  // Base cases
  if (root == null || root === p || root === q) {
    return root
  }

  // Recursively search in left and right subtrees
  val leftSearch = lowestCommonAncestor(root.left, p, q)
  val rightSearch = lowestCommonAncestor(root.right, p, q)

  // Case 1: If both searches found something, current node is LCA
  if (leftSearch != null && rightSearch != null) {
    return root
  }

  // Case 2: Return whichever search found a node (or null if neither did)
  return leftSearch ?: rightSearch
}

