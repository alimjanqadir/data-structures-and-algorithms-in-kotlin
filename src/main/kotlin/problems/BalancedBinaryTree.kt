package problems

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

internal fun isBalanced(root: TreeNode?): Boolean {
  fun checkHeight(node: TreeNode?): Int {
    if (node == null) return 0
    
    val leftHeight = checkHeight(node.left)
    if (leftHeight == -1) return -1
    
    val rightHeight = checkHeight(node.right)
    if (rightHeight == -1) return -1
    
    if (Math.abs(leftHeight - rightHeight) > 1) return -1
    
    return Math.max(leftHeight, rightHeight) + 1
  }
  
  return checkHeight(root) != -1
}
