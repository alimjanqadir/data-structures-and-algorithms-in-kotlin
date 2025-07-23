package problems

/**
 * Definition for a binary tree node.
 * Represents a node in a binary tree with a value and left/right child pointers.
 */

/**
 * Solution for flattening a binary tree to a linked list.
 * Contains multiple implementation approaches with different space complexities.
 */
/**
 * Solution 1: Simple recursive approach using preorder traversal
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(n) due to recursive call stack
 */
private fun flattenRecursive(root: TreeNode?): Unit {
  if (root == null) return

  // Store right subtree first as we'll be modifying pointers
  val rightSubtree = root.right

  // Flatten left subtree and make it the right child
  root.right = root.left
  root.left = null

  // Recursively flatten both subtrees
  flattenRecursive(root.right)
  flattenRecursive(rightSubtree)

  // Find the end of the flattened left subtree
  var current = root
  while (current?.right != null) {
    current = current.right!!
  }

  // Attach the right subtree
  current?.right = rightSubtree
}

/**
 * Solution 2: Optimal in-place solution using Morris Traversal technique
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(1) as we only use constant extra space
 */
private fun flatten(root: TreeNode?): Unit {
  var current = root

  while (current != null) {
    if (current.left != null) {
      // Find the rightmost node in the left subtree
      var rightmost = current.left!!
      while (rightmost.right != null) {
        rightmost = rightmost.right!!
      }

      // Rearrange pointers to flatten the tree
      rightmost.right = current.right
      current.right = current.left
      current.left = null
    }

    // Move to the next node
    current = current.right
  }
}

/**
 * Test cases to verify the implementation
 */
/**
 * Helper function to print the flattened tree as a linked list
 */
private fun printLinkedList(node: TreeNode?) {
  var current = node
  val values = mutableListOf<Int>()

  while (current != null) {
    values.add(current.`val`)
    require(current.left == null) { "Left child should be null in flattened tree" }
    current = current.right
  }

  println(values)
}

/**
 * Helper function to print the tree structure (for debugging)
 */
private fun printTree(root: TreeNode?, prefix: String = "", isLeft: Boolean = true) {
  if (root == null) return

  println("$prefix${if (isLeft) "├── " else "└── "}${root.`val`}")

  printTree(root.left, "$prefix${if (isLeft) "│   " else "    "}", true)
  printTree(root.right, "$prefix${if (isLeft) "│   " else "    "}", false)
}
