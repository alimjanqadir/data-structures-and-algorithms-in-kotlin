package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

class BalancedBinaryTreeTest {

  @Test
  fun `test empty tree is balanced`() {
    val result = isBalanced(null)
    assertTrue(result)
  }

  @Test
  fun `test single node tree is balanced`() {
    val root = TreeNode(1)
    val result = isBalanced(root)
    assertTrue(result)
  }

  @Test
  fun `test balanced tree with two levels`() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    val result = isBalanced(root)
    assertTrue(result)
  }

  @Test
  fun `test unbalanced tree - left heavy`() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left!!.left = TreeNode(3)
    root.left!!.left!!.left = TreeNode(4)
    val result = isBalanced(root)
    assertFalse(result)
  }

  @Test
  fun `test unbalanced tree - right heavy`() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.right = TreeNode(3)
    root.right!!.right!!.right = TreeNode(4)
    val result = isBalanced(root)
    assertFalse(result)
  }

  @Test
  fun `test balanced tree with multiple levels`() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    root.right!!.left = TreeNode(6)
    root.right!!.right = TreeNode(7)
    val result = isBalanced(root)
    assertTrue(result)
  }

  @Test
  fun `test unbalanced tree with height difference 2`() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.left!!.left = TreeNode(5)
    val result = isBalanced(root)
    assertFalse(result)
  }
}
