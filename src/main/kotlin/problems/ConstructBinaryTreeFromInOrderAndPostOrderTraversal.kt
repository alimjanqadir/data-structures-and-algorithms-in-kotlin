package problems

/**
 * Main function to build binary tree from inorder and postorder traversals
 * @param inorder - array representing inorder traversal (LEFT -> ROOT -> RIGHT)
 * @param postorder - array representing postorder traversal (LEFT -> RIGHT -> ROOT)
 * @return root node of constructed binary tree
 */
private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
  // Handle empty arrays
  if (inorder.isEmpty() || postorder.isEmpty()) return null

  // Build map of value to index for O(1) lookup in inorder array
  val inorderMap = inorder.withIndex()
    .associate { (index, value) -> value to index }

  return buildSubtree(
    postorder = postorder,
    postorderIndex = postorder.lastIndex,  // Start from end of postorder
    inStart = 0,                           // Start of inorder range
    inEnd = inorder.lastIndex,             // End of inorder range
    inorderMap = inorderMap
  )
}

/**
 * Recursive helper function to build subtrees
 * @param postorder - original postorder array
 * @param postorderIndex - current index in postorder array
 * @param inStart - start index of current subtree in inorder array
 * @param inEnd - end index of current subtree in inorder array
 * @param inorderMap - map of value to index in inorder array
 * @return root node of current subtree
 */
private fun buildSubtree(
  postorder: IntArray,
  postorderIndex: Int,
  inStart: Int,
  inEnd: Int,
  inorderMap: Map<Int, Int>
): TreeNode? {
  // Base cases: invalid range or index
  if (inStart > inEnd || postorderIndex < 0) return null

  // Current root value is at postorderIndex
  val rootValue = postorder[postorderIndex]
  val root = TreeNode(rootValue)

  // Find position of root in inorder traversal
  val rootIndex = inorderMap[rootValue]!!

  // Calculate size of right subtree
  // All nodes after rootIndex in inorder array belong to right subtree
  val rightSubtreeSize = inEnd - rootIndex

  // Build right subtree first (moving backwards in postorder)
  // Right subtree values come just before root in postorder
  root.right = buildSubtree(
    postorder = postorder,
    postorderIndex = postorderIndex - 1,    // Previous element
    inStart = rootIndex + 1,                // Start after root in inorder
    inEnd = inEnd,                          // End of current range
    inorderMap = inorderMap
  )

  // Build left subtree
  // Left subtree values come before right subtree in postorder
  root.left = buildSubtree(
    postorder = postorder,
    // Skip right subtree elements to get to left subtree elements
    postorderIndex = postorderIndex - rightSubtreeSize - 1,
    inStart = inStart,                     // Start of current range
    inEnd = rootIndex - 1,                 // End before root in inorder
    inorderMap = inorderMap
  )

  return root
}

// Test function
fun main() {
  // Test case 1: Basic tree from example
  println("\nTest Case 1: Basic Tree")
  val inorder1 = intArrayOf(9, 3, 15, 20, 7)
  val postorder1 = intArrayOf(9, 15, 7, 20, 3)
  val root1 = buildTree(inorder1, postorder1)
  println("Constructed tree:")
  printTree(root1)

  // Verify traversals match input
  val verifyInorder1 = verifyArrays(inorder1, getInorderTraversal(root1))
  val verifyPostorder1 = verifyArrays(postorder1, getPostorderTraversal(root1))
  println("Inorder verification: ${if (verifyInorder1) "PASSED" else "FAILED"}")
  println("Postorder verification: ${if (verifyPostorder1) "PASSED" else "FAILED"}")

  // Test case 2: Single node tree
  println("\nTest Case 2: Single Node Tree")
  val inorder2 = intArrayOf(1)
  val postorder2 = intArrayOf(1)
  val root2 = buildTree(inorder2, postorder2)
  println("Constructed tree:")
  printTree(root2)

  val verifyInorder2 = verifyArrays(inorder2, getInorderTraversal(root2))
  val verifyPostorder2 = verifyArrays(postorder2, getPostorderTraversal(root2))
  println("Inorder verification: ${if (verifyInorder2) "PASSED" else "FAILED"}")
  println("Postorder verification: ${if (verifyPostorder2) "PASSED" else "FAILED"}")

  // Test case 3: Left-skewed tree
  println("\nTest Case 3: Left-skewed Tree")
  val inorder3 = intArrayOf(4, 3, 2, 1)
  val postorder3 = intArrayOf(4, 3, 2, 1)
  val root3 = buildTree(inorder3, postorder3)
  println("Constructed tree:")
  printTree(root3)

  val verifyInorder3 = verifyArrays(inorder3, getInorderTraversal(root3))
  val verifyPostorder3 = verifyArrays(postorder3, getPostorderTraversal(root3))
  println("Inorder verification: ${if (verifyInorder3) "PASSED" else "FAILED"}")
  println("Postorder verification: ${if (verifyPostorder3) "PASSED" else "FAILED"}")

  // Test case 4: Right-skewed tree
  println("\nTest Case 4: Right-skewed Tree")
  val inorder4 = intArrayOf(1, 2, 3, 4)
  val postorder4 = intArrayOf(4, 3, 2, 1)
  val root4 = buildTree(inorder4, postorder4)
  println("Constructed tree:")
  printTree(root4)

  val verifyInorder4 = verifyArrays(inorder4, getInorderTraversal(root4))
  val verifyPostorder4 = verifyArrays(postorder4, getPostorderTraversal(root4))
  println("Inorder verification: ${if (verifyInorder4) "PASSED" else "FAILED"}")
  println("Postorder verification: ${if (verifyPostorder4) "PASSED" else "FAILED"}")

  // Test case 5: Empty tree
  println("\nTest Case 5: Empty Tree")
  val inorder5 = intArrayOf()
  val postorder5 = intArrayOf()
  val root5 = buildTree(inorder5, postorder5)
  println("Constructed tree:")
  printTree(root5)

  val verifyInorder5 = verifyArrays(inorder5, getInorderTraversal(root5))
  val verifyPostorder5 = verifyArrays(postorder5, getPostorderTraversal(root5))
  println("Inorder verification: ${if (verifyInorder5) "PASSED" else "FAILED"}")
  println("Postorder verification: ${if (verifyPostorder5) "PASSED" else "FAILED"}")
}

// Helper function to get inorder traversal
private fun getInorderTraversal(root: TreeNode?): List<Int> {
  val result = mutableListOf<Int>()

  fun inorder(node: TreeNode?) {
    if (node == null) return
    inorder(node.left)
    result.add(node.`val`)
    inorder(node.right)
  }

  inorder(root)
  return result
}

// Helper function to get postorder traversal
private fun getPostorderTraversal(root: TreeNode?): List<Int> {
  val result = mutableListOf<Int>()

  fun postorder(node: TreeNode?) {
    if (node == null) return
    postorder(node.left)
    postorder(node.right)
    result.add(node.`val`)
  }

  postorder(root)
  return result
}

// Helper function to print tree level by level
private fun printTree(root: TreeNode?) {
  if (root == null) {
    println("Empty tree")
    return
  }

  val queue = ArrayDeque<Pair<TreeNode?, Int>>()
  queue.add(root to 0)
  var currentLevel = 0
  var currentLevelNodes = mutableListOf<String>()

  while (queue.isNotEmpty()) {
    val (node, level) = queue.removeFirst()

    if (level > currentLevel) {
      println(currentLevelNodes.joinToString(" "))
      currentLevelNodes = mutableListOf()
      currentLevel = level
    }

    if (node == null) {
      currentLevelNodes.add("null")
    } else {
      currentLevelNodes.add(node.`val`.toString())
      queue.add(node.left to level + 1)
      queue.add(node.right to level + 1)
    }
  }

  // Print last level
  println(currentLevelNodes.joinToString(" "))
}

// Helper function to verify if two arrays are equal
private fun verifyArrays(expected: IntArray, actual: List<Int>): Boolean {
  if (expected.size != actual.size) return false
  return expected.toList() == actual
}