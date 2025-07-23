package problems

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
// State to track the current count and result during traversal
private var count = 0
private var result = 0

private fun kthSmallest(root: TreeNode?, k: Int): Int {
  count = 0 // Reset count for each new search
  result = 0 // Reset result for each new search
  inorderTraverse(root, k)
  return result
}

/**
 * Performs an inorder traversal with early termination
 * Once we find the kth element, we don't need to continue traversing
 */
private fun inorderTraverse(node: TreeNode?, k: Int): Boolean {
  // Base case: null node or already found result
  if (node == null) return false

  // Traverse left subtree
  if (inorderTraverse(node.left, k)) return true

  // Process current node
  count++
  if (count == k) {
    result = node.`val`
    return true // Found kth element, signal to stop traversal
  }

  // Traverse right subtree only if we haven't found kth element
  return inorderTraverse(node.right, k)
}

/**
 * Test cases to verify the solution
 */
