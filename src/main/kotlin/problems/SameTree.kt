package problems

/**
 * Solution for LeetCode #100: Same Tree
 *
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * Space Complexity: O(h) where h is the height of the tree due to recursion stack
 * In worst case (skewed tree): O(n)
 * In best case (balanced tree): O(log n)
 */

internal fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
  // Base cases
  // If both nodes are null, trees are identical at this point
  if (p == null && q == null) return true

  // If one node is null and other isn't, trees are different
  if (p == null || q == null) return false

  // If values are different, trees are different
  if (p.`val` != q.`val`) return false

  // Recursively check left and right subtrees
  return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}

// Example usage and tests
