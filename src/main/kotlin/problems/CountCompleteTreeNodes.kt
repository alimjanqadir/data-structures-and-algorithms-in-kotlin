package problems

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
private fun countNodes(root: TreeNode?): Int {
  if (root == null) return 0

  // Get left height and right height
  val leftHeight = getLeftHeight(root)
  val rightHeight = getRightHeight(root)

  // If heights are equal, it's a perfect binary tree
  return if (leftHeight == rightHeight) {
    (1 shl leftHeight) - 1  // 2^h - 1
  } else {
    // Recursively count nodes
    1 + countNodes(root.left) + countNodes(root.right)
  }
}

// Get height following left path
private fun getLeftHeight(node: TreeNode?): Int {
  var height = 0
  var current = node
  while (current != null) {
    height++
    current = current.left
  }
  return height
}

// Get height following right path
private fun getRightHeight(node: TreeNode?): Int {
  var height = 0
  var current = node
  while (current != null) {
    height++
    current = current.right
  }
  return height
}

/**
 * Test cases
 */
