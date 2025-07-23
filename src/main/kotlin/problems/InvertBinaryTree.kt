package problems

/**
 * Solution for inverting a binary tree.
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * Space Complexity: O(h) where h is the height of the tree due to recursion stack
 *     - Best case (balanced tree): O(log n)
 *     - Worst case (skewed tree): O(n)
 */
private fun invertTree(root: TreeNode?): TreeNode? {
  // Base case: if root is null, return null
  root ?: return null

  // Swap the left and right children using Kotlin's also scope function
  // This creates clean, idiomatic code while maintaining readability
  root.left = root.right.also { root.right = root.left }

  // Recursively invert the left and right subtrees
  invertTree(root.left)
  invertTree(root.right)

  return root
}

/**
 * Alternative iterative solution using a queue
 * Same time and space complexity as recursive solution
 */
private fun invertTreeIterative(root: TreeNode?): TreeNode? {
  // If root is null, return null
  root ?: return null

  // Use ArrayDeque as a queue
  val queue = ArrayDeque<TreeNode>()
  queue.addLast(root)

  while (queue.isNotEmpty()) {
    val current = queue.removeFirst()

    // Swap the children
    current.left = current.right.also { current.right = current.left }

    // Add non-null children to the queue
    current.left?.let { queue.addLast(it) }
    current.right?.let { queue.addLast(it) }
  }

  return root
}

/**
 * Example usage and test cases
 */
/**
 * Helper function to print the tree level by level
 */
private fun printTree(root: TreeNode?): String {
  if (root == null) return "[]"

  val result = mutableListOf<String>()
  val queue = ArrayDeque<TreeNode?>()
  queue.addLast(root)

  while (queue.isNotEmpty() && queue.any { it != null }) {
    val current = queue.removeFirst()
    if (current == null) {
      result.add("null")
      continue
    }

    result.add(current.`val`.toString())
    queue.addLast(current.left)
    queue.addLast(current.right)
  }

  // Remove trailing nulls
  while (result.last() == "null") {
    result.removeAt(result.lastIndex)
  }

  return "[${result.joinToString(",")}]"
}
