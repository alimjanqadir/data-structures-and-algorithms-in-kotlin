package problems

private var maxPathSum = Int.MIN_VALUE

private fun maxPathSum(root: TreeNode?): Int {
  if (root == null) return 0
  maxGain(root)
  return maxPathSum
}

/**
 * Calculate maximum contribution that the subtree can add to its parent path
 * While also updating the global maximum path sum
 */
private fun maxGain(node: TreeNode?): Int {
  if (node == null) return 0

  // Get maximum path sums from left and right subtrees
  // Only include positive contributions
  val leftGain = maxOf(maxGain(node.left), 0)
  val rightGain = maxOf(maxGain(node.right), 0)

  // Calculate price of path that includes node and maybe both children
  val priceNewPath = node.`val` + leftGain + rightGain

  // Update global maximum if this path is better
  maxPathSum = maxOf(maxPathSum, priceNewPath)

  // Return maximum contribution this node can add to parent path
  // (can only use one child path, not both)
  return node.`val` + maxOf(leftGain, rightGain)
}

/**
 * Test cases
 */
fun main() {
  // Test Case 1: [1,2,3]
  val root1 = TreeNode(1)
  root1.left = TreeNode(2)
  root1.right = TreeNode(3)
  assert(maxPathSum(root1) == 6) { "Test case 1 failed" }

  // Test Case 2: [-10,9,20,null,null,15,7]
  val root2 = TreeNode(-10)
  root2.left = TreeNode(9)
  root2.right = TreeNode(20)
  root2.right?.left = TreeNode(15)
  root2.right?.right = TreeNode(7)
  assert(maxPathSum(root2) == 42) { "Test case 2 failed" }

  // Test Case 3: Single node
  val root3 = TreeNode(1)
  assert(maxPathSum(root3) == 1) { "Test case 3 failed" }

  // Test Case 4: All negative values
  val root4 = TreeNode(-1)
  root4.left = TreeNode(-2)
  root4.right = TreeNode(-3)
  assert(maxPathSum(root4) == -1) { "Test case 4 failed" }

  println("All test cases passed!")
}