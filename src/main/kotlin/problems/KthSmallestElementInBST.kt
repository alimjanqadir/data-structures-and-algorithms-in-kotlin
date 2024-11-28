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
fun main() {
  // Test Case 1: Example from problem statement
  val root1 = TreeNode(3).apply {
    left = TreeNode(1).apply {
      right = TreeNode(2)
    }
    right = TreeNode(4)
  }
  assert(kthSmallest(root1, 1) == 1) { "Test case 1 failed" }

  // Test Case 2: Second example from problem statement
  val root2 = TreeNode(5).apply {
    left = TreeNode(3).apply {
      left = TreeNode(2).apply {
        left = TreeNode(1)
      }
      right = TreeNode(4)
    }
    right = TreeNode(6)
  }
  assert(kthSmallest(root2, 3) == 3) { "Test case 2 failed" }

  // Test Case 3: Single node
  val root3 = TreeNode(1)
  assert(kthSmallest(root3, 1) == 1) { "Test case 3 failed" }

  println("All test cases passed!")
}