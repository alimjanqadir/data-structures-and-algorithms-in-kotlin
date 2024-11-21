package problems

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
private fun countNodes(root: TreeNode?): Int {
  if (root == null) return 0

  // Get left height and right height
  val leftHeight = getLeftHeight(root)
  val rightHeight = getRightHeight(root)

  // If heights are equal, it's a perfect binary tree
  return if (leftHeight == rightHeight) {
    (1 shl leftHeight) - 1  // 2^h - 1
  } else {
    // Recursively count nodes
    1 + countNodes(root.left) + countNodes(root.right)
  }
}

// Get height following left path
private fun getLeftHeight(node: TreeNode?): Int {
  var height = 0
  var current = node
  while (current != null) {
    height++
    current = current.left
  }
  return height
}

// Get height following right path
private fun getRightHeight(node: TreeNode?): Int {
  var height = 0
  var current = node
  while (current != null) {
    height++
    current = current.right
  }
  return height
}

/**
 * Test cases
 */
fun main() {
  // Test Case 1: Perfect binary tree
  val test1 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4)
      right = TreeNode(5)
    }
    right = TreeNode(3).apply {
      left = TreeNode(6)
      right = TreeNode(7)
    }
  }
  assert(countNodes(test1) == 7) { "Test case 1 failed" }

  // Test Case 2: Complete but not perfect
  val test2 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4)
      right = TreeNode(5)
    }
    right = TreeNode(3).apply {
      left = TreeNode(6)
    }
  }
  assert(countNodes(test2) == 6) { "Test case 2 failed" }

  // Test Case 3: Single node
  val test3 = TreeNode(1)
  assert(countNodes(test3) == 1) { "Test case 3 failed" }

  // Test Case 4: Empty tree
  assert(countNodes(null) == 0) { "Test case 4 failed" }

  println("All test cases passed!")
}