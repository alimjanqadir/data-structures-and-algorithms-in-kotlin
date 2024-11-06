package problems

/**
 * Problem 129: Sum Root to Leaf Numbers
 * Time Complexity: O(N) where N is the number of nodes
 * Space Complexity: O(H) where H is the height of the tree, for recursion stack
 */


/**
 * Calculates the sum of all root-to-leaf paths where each path represents a number.
 * Uses DFS (Depth-First Search) with a running sum to compute all path numbers.
 *
 * @param root The root node of the binary tree
 * @return The total sum of all root-to-leaf numbers
 */
private fun sumNumbers(root: TreeNode?): Int {
  return dfs(root, 0)
}

/**
 * Helper function that performs DFS traversal.
 *
 * @param node Current node being processed
 * @param currentSum Running sum from root to current node
 * @return Sum of all paths in the current subtree
 */
private fun dfs(node: TreeNode?, currentSum: Int): Int {
  // Base case: null node
  if (node == null) return 0

  // Calculate the current number in the path
  val newSum = currentSum * 10 + node.`val`

  // If it's a leaf node, return the current number
  if (node.left == null && node.right == null) {
    return newSum
  }

  // Recurse on left and right children and return their sum
  return dfs(node.left, newSum) + dfs(node.right, newSum)
}

/**
 * Test cases to verify the solution
 */
fun main() {
  // Test Case 1: [1,2,3]
  val root1 = TreeNode(1).apply {
    left = TreeNode(2)
    right = TreeNode(3)
  }
  println("Test Case 1: ${sumNumbers(root1)} (Expected: 25)")

  // Test Case 2: [4,9,0,5,1]
  val root2 = TreeNode(4).apply {
    left = TreeNode(9).apply {
      left = TreeNode(5)
      right = TreeNode(1)
    }
    right = TreeNode(0)
  }
  println("Test Case 2: ${sumNumbers(root2)} (Expected: 1026)")

  // Test Case 3: Single node [5]
  val root3 = TreeNode(5)
  println("Test Case 3: ${sumNumbers(root3)} (Expected: 5)")

  // Test Case 4: Deep path [1,2,3,4,5]
  val root4 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(3).apply {
        left = TreeNode(4).apply {
          left = TreeNode(5)
        }
      }
    }
  }
  println("Test Case 4: ${sumNumbers(root4)} (Expected: 12345)")
}