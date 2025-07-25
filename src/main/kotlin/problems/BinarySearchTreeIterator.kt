package problems

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
private class BSTIterator(root: TreeNode?) {
  // Stack to maintain the path to the current node
  private val stack = ArrayDeque<TreeNode>()

  init {
    // Initialize by pushing all left nodes onto stack
    pushAllLeft(root)
  }

  /**
   * Returns the next smallest number in the BST
   * Time Complexity: O(1) amortized
   */
  fun next(): Int {
    // The top node in stack is always the next smallest element
    val currentNode = stack.removeLast()

    // If this node has a right child,
    // push all left nodes starting from the right child
    pushAllLeft(currentNode.right)

    return currentNode.`val`
  }

  /**
   * Returns whether the iterator has a next number
   * Time Complexity: O(1)
   */
  fun hasNext(): Boolean {
    return stack.isNotEmpty()
  }

  /**
   * Helper function to push all left nodes starting from a given node
   * Time Complexity: O(h) where h is height of the tree
   */
  private fun pushAllLeft(node: TreeNode?) {
    var current = node
    while (current != null) {
      stack.addLast(current)
      current = current.left
    }
  }
}

/**
 * Test cases for BSTIterator
 */
/**
 * Complexity Analysis:
 *
 * Time Complexity:
 * - Constructor: O(h) where h is the height of the tree
 * - next(): O(1) amortized. While a single call might take O(h),
 *   the amortized time across all n nodes is O(1)
 * - hasNext(): O(1)
 *
 * Space Complexity:
 * - O(h) where h is the height of the tree
 * - In worst case (linear tree), h = n
 * - In balanced tree, h = log n
 *
 * Key Implementation Points:
 * 1. Uses a stack to maintain path to current node
 * 2. Implements controlled traversal using stack operations
 * 3. Lazy evaluation - processes nodes only when needed
 * 4. Maintains BST invariant without storing full traversal
 */
