package problems

/**
 * Problem 129: Sum Root to Leaf Numbers
 * Time Complexity: O(N) where N is the number of nodes
 * Space Complexity: O(H) where H is the height of the tree, for recursion stack
 */


/**
 * Calculates the sum of all root-to-leaf paths where each path represents a number.
 * Uses DFS (Depth-First Search) with a running sum to compute all path numbers.
 *
 * @param root The root node of the binary tree
 * @return The total sum of all root-to-leaf numbers
 */
fun sumRootToLeaf(root: TreeNode?): Int {
  return computePathSum(root, 0)
}

private fun computePathSum(
  currentNode: TreeNode?,
  accumulatedValue: Int
): Int {

  if (currentNode == null) {
    return 0
  }

  val updatedValue =
    accumulatedValue * 2 + currentNode.`val` 

  val isLeaf =
    currentNode.left == null &&
      currentNode.right == null

  if (isLeaf) {
    return updatedValue
  }

  val leftSum =
    computePathSum(currentNode.left, updatedValue)

  val rightSum =
    computePathSum(currentNode.right, updatedValue)

  return leftSum + rightSum
}

/**
 * Test cases to verify the solution
 */
