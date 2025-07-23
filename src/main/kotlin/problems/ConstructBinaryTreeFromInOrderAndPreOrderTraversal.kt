import problems.TreeNode

/**
 * Main function to build the binary tree
 * @param preorder Array containing preorder traversal of the tree
 * @param inorder Array containing inorder traversal of the tree
 * @return Root node of the constructed binary tree
 */
private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
  // Handle empty input case
  if (preorder.isEmpty() || inorder.isEmpty()) return null

  // Create a map of value to index for inorder array for O(1) lookups
  val inorderMap = inorder.withIndex()
    .associate { (index, value) -> value to index }

  return buildSubtree(preorder, 0, 0, inorder.lastIndex, inorderMap)
}

/**
 * Helper function to recursively build subtrees
 * @param preorder Original preorder array
 * @param preorderIndex Current index in preorder array
 * @param inStart Start index of current subtree in inorder array
 * @param inEnd End index of current subtree in inorder array
 * @param inorderMap Map of value to index for O(1) lookups in inorder array
 * @return Root node of the current subtree
 */
private fun buildSubtree(
  preorder: IntArray,
  preorderIndex: Int,
  inStart: Int,
  inEnd: Int,
  inorderMap: Map<Int, Int>
): TreeNode? {
  // Base case: invalid range in inorder array
  if (inStart > inEnd) return null

  // Get root value from preorder array and create node
  val rootValue = preorder[preorderIndex]
  val root = TreeNode(rootValue)

  // Find position of root value in inorder array
  val rootIndex = inorderMap[rootValue]!!

  // Calculate size of left subtree
  val leftSubtreeSize = rootIndex - inStart

  // Recursively build left subtree
  // - Next element in preorder is root of left subtree
  // - Inorder range is from inStart to just before root
  root.left = buildSubtree(
    preorder,
    preorderIndex + 1,
    inStart,
    rootIndex - 1,
    inorderMap
  )

  // Recursively build right subtree
  // - Root of right subtree is after left subtree in preorder
  // - Inorder range is from after root to inEnd
  root.right = buildSubtree(
    preorder,
    preorderIndex + leftSubtreeSize + 1,
    rootIndex + 1,
    inEnd,
    inorderMap
  )

  return root
}

/**
 * Helper function to print tree in a readable format (level order)
 */
private fun printTree(root: TreeNode?) {
  if (root == null) {
    println("Empty tree")
    return
  }

  val queue = ArrayDeque<TreeNode?>()
  queue.add(root)

  while (queue.isNotEmpty()) {
    var levelSize = queue.size
    val level = mutableListOf<String>()

    while (levelSize > 0) {
      val node = queue.removeFirst()
      level.add(node?.`val`?.toString() ?: "null")

      if (node != null) {
        queue.add(node.left)
        queue.add(node.right)
      }
      levelSize--
    }
    // Remove trailing nulls for cleaner output
    while (level.lastOrNull() == "null") {
      level.removeAt(level.lastIndex)
    }
    if (level.isNotEmpty()) {
      println(level.joinToString(" "))
    }
  }
}

