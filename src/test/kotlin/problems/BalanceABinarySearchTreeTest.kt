package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class BalanceABinarySearchTreeTest {
  @Test
  fun testBalanceBST() {
    // Test case 1: Already balanced tree
    val root1 = TreeNode(2).apply {
      left = TreeNode(1)
      right = TreeNode(3)
    }
    val balanced1 = balanceBST(root1)
    assertTrue(isBalanced(balanced1))
    assertEquals(3, countNodes(balanced1))

    // Test case 2: Unbalanced right-heavy tree
    val root2 = TreeNode(1).apply {
      right = TreeNode(2).apply {
        right = TreeNode(3).apply {
          right = TreeNode(4)
        }
      }
    }
    val balanced2 = balanceBST(root2)
    assertTrue(isBalanced(balanced2))
    assertEquals(4, countNodes(balanced2))

    // Test case 3: Unbalanced left-heavy tree
    val root3 = TreeNode(4).apply {
      left = TreeNode(3).apply {
        left = TreeNode(2).apply {
          left = TreeNode(1)
        }
      }
    }
    val balanced3 = balanceBST(root3)
    assertTrue(isBalanced(balanced3))
    assertEquals(4, countNodes(balanced3))

    // Test case 4: Empty tree
    val balanced4 = balanceBST(null)
    assertNull(balanced4)
  }

  private fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true
        
    fun height(node: TreeNode?): Int {
      if (node == null) return 0
      return 1 + maxOf(height(node.left), height(node.right))
    }
        
    val leftHeight = height(root.left)
    val rightHeight = height(root.right)
        
    return Math.abs(leftHeight - rightHeight) <= 1 && 
      isBalanced(root.left) && 
      isBalanced(root.right)
  }
    
  private fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + countNodes(root.left) + countNodes(root.right)
  }
}
