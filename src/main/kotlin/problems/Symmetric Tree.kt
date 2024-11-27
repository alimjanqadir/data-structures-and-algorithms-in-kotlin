package problems

/**
 * Problem: Check if a binary tree is symmetric around its center
 * Time Complexity: O(n) where n is number of nodes
 * Space Complexity: O(h) where h is height of tree for recursive
 *                  O(w) where w is max width of tree for iterative
 */

// Recursive solution
private fun isSymmetric(root: TreeNode?): Boolean {
  if (root == null) return true
  return isMirror(root.left, root.right)
}

// Helper function for recursive approach
private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
  // Both null means symmetric at this point
  if (left == null && right == null) return true

  // One null but not both means asymmetric
  if (left == null || right == null) return false

  return left.`val` == right.`val` &&
    isMirror(left.left, right.right) &&
    isMirror(left.right, right.left)
}

// Iterative solution using a queue
private fun isSymmetricIterative(root: TreeNode?): Boolean {
  if (root == null) return true

  // Using ArrayDeque as it's more efficient than LinkedList for queue operations
  val queue = ArrayDeque<TreeNode?>()
  queue.addLast(root.left)
  queue.addLast(root.right)

  while (queue.isNotEmpty()) {
    // Always process nodes in pairs
    val left = queue.removeFirst()
    val right = queue.removeFirst()

    // Both null means symmetric at this point
    if (left == null && right == null) continue

    // One null but not both means asymmetric
    if (left == null || right == null) return false

    if (left.`val` != right.`val`) return false

    // Add pairs in order that they should match
    // Note: Order is important - we add corresponding pairs together
    queue.addLast(left.left)
    queue.addLast(right.right)
    queue.addLast(left.right)
    queue.addLast(right.left)
  }

  return true
}

// Test cases
fun main() {
  // Test Case 1: Symmetric tree [1,2,2,3,4,4,3]
  val root1 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(3)
      right = TreeNode(4)
    }
    right = TreeNode(2).apply {
      left = TreeNode(4)
      right = TreeNode(3)
    }
  }
  println("Test Case 1 Recursive: ${isSymmetric(root1)}") // Should print true
  println("Test Case 1 Iterative: ${isSymmetricIterative(root1)}") // Should print true

  // Test Case 2: Asymmetric tree [1,2,2,null,3,null,3]
  val root2 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      right = TreeNode(3)
    }
    right = TreeNode(2).apply {
      right = TreeNode(3)
    }
  }
  println("Test Case 2 Recursive: ${isSymmetric(root2)}") // Should print false
  println("Test Case 2 Iterative: ${isSymmetricIterative(root2)}") // Should print false

  // Test Case 3: Single node
  val root3 = TreeNode(1)
  println("Test Case 3 Recursive: ${isSymmetric(root3)}") // Should print true
  println("Test Case 3 Iterative: ${isSymmetricIterative(root3)}") // Should print true
}