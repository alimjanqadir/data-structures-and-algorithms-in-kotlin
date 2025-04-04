package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LCADeepestLeavesTest {
    @Test
    fun testLCADeepestLeaves() {
        // Test case 1: Balanced tree with deepest leaves at same level
        val root1 = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3)
        }
        assertEquals(2, lcaDeepestLeaves(root1)?.`val`)

        // Test case 2: Unbalanced tree with single deepest leaf
        val root2 = TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(4)
                }
            }
        }
        assertEquals(4, lcaDeepestLeaves(root2)?.`val`)

        // Test case 3: Single node is its own LCA
        val root3 = TreeNode(1)
        assertEquals(1, lcaDeepestLeaves(root3)?.`val`)
    }
}
