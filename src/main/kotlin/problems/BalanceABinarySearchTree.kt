package problems

// TreeNode is in the same package (problems)

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

internal fun balanceBST(root: TreeNode?): TreeNode? {
  val sortedValues = mutableListOf<Int>()
  collectInOrderValues(root, sortedValues)
  return buildBalancedTree(sortedValues, 0, sortedValues.size - 1)
}

private fun collectInOrderValues(
  node: TreeNode?,
  sortedValues: MutableList<Int>
) {
  if (node == null) return

  collectInOrderValues(node.left, sortedValues)
  sortedValues.add(node.`val`)
  collectInOrderValues(node.right, sortedValues)
}

private fun buildBalancedTree(
  sortedValues: List<Int>,
  leftIndex: Int,
  rightIndex: Int
): TreeNode? {
  if (leftIndex > rightIndex) return null

  val middleIndex = leftIndex + (rightIndex - leftIndex) / 2
  val rootNode = TreeNode(sortedValues[middleIndex])

  rootNode.left = buildBalancedTree(
    sortedValues,
    leftIndex,
    middleIndex - 1
  )

  rootNode.right = buildBalancedTree(
    sortedValues,
    middleIndex + 1,
    rightIndex
  )

  return rootNode
}
