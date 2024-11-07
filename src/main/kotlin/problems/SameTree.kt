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
fun main() {
  // Test case 1: [1,2,3] == [1,2,3]
  val p1 = TreeNode(1).apply {
    left = TreeNode(2)
    right = TreeNode(3)
  }
  val q1 = TreeNode(1).apply {
    left = TreeNode(2)
    right = TreeNode(3)
  }
  println("Test 1: ${isSameTree(p1, q1)}") // Should print: true

  // Test case 2: [1,2] != [1,null,2]
  val p2 = TreeNode(1).apply {
    left = TreeNode(2)
  }
  val q2 = TreeNode(1).apply {
    right = TreeNode(2)
  }
  println("Test 2: ${isSameTree(p2, q2)}") // Should print: false

  // Test case 3: [1,2,1] != [1,1,2]
  val p3 = TreeNode(1).apply {
    left = TreeNode(2)
    right = TreeNode(1)
  }
  val q3 = TreeNode(1).apply {
    left = TreeNode(1)
    right = TreeNode(2)
  }
  println("Test 3: ${isSameTree(p3, q3)}") // Should print: false
}