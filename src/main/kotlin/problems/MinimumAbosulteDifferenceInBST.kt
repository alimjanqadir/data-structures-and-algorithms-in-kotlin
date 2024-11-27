package problems

private var minDiff = Int.MAX_VALUE
private var prevValue: Int? = null

private fun getMinimumDifference(root: TreeNode?): Int {
  // Reset class variables for each new call
  minDiff = Int.MAX_VALUE
  prevValue = null

  // Perform inorder traversal
  inorderTraversal(root)
  return minDiff
}

private fun inorderTraversal(node: TreeNode?) {
  if (node == null) return

  // Process left subtree
  inorderTraversal(node.left)

  // Process current node
  // Since this is BST, inorder traversal gives values in ascending order
  prevValue?.let { prev ->
    minDiff = minOf(minDiff, Math.abs(node.`val` - prev))
  }
  prevValue = node.`val`

  // Process right subtree
  inorderTraversal(node.right)
}

fun main() {
  // Test Case 1: Example from the problem
  val root1 = TreeNode(4).apply {
    left = TreeNode(2).apply {
      left = TreeNode(1)
      right = TreeNode(3)
    }
    right = TreeNode(6)
  }
  println("Test Case 1: ${getMinimumDifference(root1)} (Expected: 1)")

  // Test Case 2: Second example from the problem
  val root2 = TreeNode(1).apply {
    left = TreeNode(0)
    right = TreeNode(48).apply {
      left = TreeNode(12)
      right = TreeNode(49)
    }
  }
  println("Test Case 2: ${getMinimumDifference(root2)} (Expected: 1)")

  // Test Case 3: Single node
  val root3 = TreeNode(1)
  println("Test Case 3: ${getMinimumDifference(root3)} (Expected: Int.MAX_VALUE)")

  // Test Case 4: Linear tree
  val root4 = TreeNode(5).apply {
    right = TreeNode(7).apply {
      right = TreeNode(9)
    }
  }
  println("Test Case 4: ${getMinimumDifference(root4)} (Expected: 2)")
}