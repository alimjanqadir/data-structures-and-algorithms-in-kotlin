package problems

/**
 * Problem 1123: Lowest Common Ancestor of Deepest Leaves
 * Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.
 *
 * Recall that:
 * - The node of a binary tree is a leaf if and only if it has no children
 * - The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of its children is d + 1
 * - The lowest common ancestor of a set S of nodes is the node A with the largest depth such that every node in S is in the subtree of A
 */
internal fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    fun dfs(node: TreeNode?): Pair<TreeNode?, Int> {
        if (node == null) return Pair(null, 0)

        val (leftLCA, leftDepth) = dfs(node.left)
        val (rightLCA, rightDepth) = dfs(node.right)

        return when {
            leftDepth == rightDepth -> Pair(node, leftDepth + 1)
            leftDepth > rightDepth -> Pair(leftLCA, leftDepth + 1)
            else -> Pair(rightLCA, rightDepth + 1)
        }
    }

    return dfs(root).first
}
