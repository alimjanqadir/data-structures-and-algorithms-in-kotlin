package problems

private fun maxPathSum(root: TreeNode?): Int {
  var maxPathSum = Int.MIN_VALUE

  fun findSubTreeMaxPathSum(node: TreeNode?): Int {
    if (node == null) return 0

    val leftMax = maxOf(findSubTreeMaxPathSum(node.left), 0)
    val rightMax = maxOf(findSubTreeMaxPathSum(node.right), 0)

    val currentPathSum = leftMax + node.`val` + rightMax
    maxPathSum = maxOf(maxPathSum, currentPathSum)

    return node.`val` + maxOf(leftMax, rightMax)
  }

  if (root == null) return 0
  findSubTreeMaxPathSum(root)
  return maxPathSum
}

fun main() {
  // Test Case 1: [1,2,3]
  val root1 = TreeNode(1).apply {
    left = TreeNode(2)
    right = TreeNode(3)
  }
  check(maxPathSum(root1) == 6) { "Test case 1 failed" }

  // Test Case 2: [-10,9,20,null,null,15,7]
  val root2 = TreeNode(-10).apply {
    left = TreeNode(9)
    right = TreeNode(20).apply {
      left = TreeNode(15)
      right = TreeNode(7)
    }
  }
  check(maxPathSum(root2) == 42) { "Test case 2 failed" }

  // Test Case 3: Single node
  val root3 = TreeNode(-3)
  check(maxPathSum(root3) == -3) { "Test case 3 failed" }

  // Test Case 4: Negative values
  val root4 = TreeNode(-2).apply {
    left = TreeNode(-1)
    right = TreeNode(-3)
  }
  check(maxPathSum(root4) == -1) { "Test case 4 failed" }

  println("All test cases passed!")
}