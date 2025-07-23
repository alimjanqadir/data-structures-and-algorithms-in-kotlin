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
