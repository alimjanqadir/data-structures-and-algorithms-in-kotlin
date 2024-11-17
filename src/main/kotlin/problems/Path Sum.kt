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
fun main() {
  // Create test case from Example 1
  val root = TreeNode(5).apply {
    left = TreeNode(4).apply {
      left = TreeNode(11).apply {
        left = TreeNode(7)
        right = TreeNode(2)
      }
    }
    right = TreeNode(8).apply {
      left = TreeNode(13)
      right = TreeNode(4).apply {
        right = TreeNode(1)
      }
    }
  }

  // Test cases
  println("Test case 1 (should be true): ${hasPathSum(root, 22)}")
  println("Test case 2 (empty tree): ${hasPathSum(null, 0)}")

  // Create test case from Example 2
  val root2 = TreeNode(1).apply {
    left = TreeNode(2)
    right = TreeNode(3)
  }
  println("Test case 3 (should be false): ${hasPathSum(root2, 5)}")
}