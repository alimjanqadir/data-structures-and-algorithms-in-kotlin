package problems

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class SumRootToLeafNumbersTest {

  @Test
  fun `test empty tree`() {
    val result = sumRootToLeaf(null)
    assertEquals(0, result)
  }

  @Test
  fun `test single node`() {
    val root = TreeNode(1)
    val result = sumRootToLeaf(root)
    assertEquals(1, result)
  }

  @Test
  fun `test two level tree - simple case`() {
    val root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    
    // Paths: 1->0 = binary 10 = 2, 1->1 = binary 11 = 3
    // Sum: 2 + 3 = 5
    val result = sumRootToLeaf(root)
    assertEquals(5, result)
  }

  @Test
  fun `test three level tree`() {
    val root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    root.left!!.left = TreeNode(1)
    root.left!!.right = TreeNode(0)
    root.right!!.left = TreeNode(1)
    root.right!!.right = TreeNode(0)
    
    // Paths:
    // 1->0->1 = binary 101 = 5
    // 1->0->0 = binary 100 = 4
    // 1->1->1 = binary 111 = 7
    // 1->1->0 = binary 110 = 6
    // Sum: 5 + 4 + 7 + 6 = 22
    val result = sumRootToLeaf(root)
    assertEquals(22, result)
  }

  @Test
  fun `test unbalanced tree`() {
    val root = TreeNode(1)
    root.left = TreeNode(1)
    root.left!!.left = TreeNode(0)
    
    // Only one path: 1->1->0 = binary 110 = 6
    val result = sumRootToLeaf(root)
    assertEquals(6, result)
  }

  @Test
  fun `test tree with only right children`() {
    val root = TreeNode(1)
    root.right = TreeNode(0)
    root.right!!.right = TreeNode(1)
    
    // Only one path: 1->0->1 = binary 101 = 5
    val result = sumRootToLeaf(root)
    assertEquals(5, result)
  }

  @Test
  fun `test complex tree`() {
    val root = TreeNode(1)
    root.left = TreeNode(1)
    root.right = TreeNode(0)
    root.left!!.left = TreeNode(0)
    root.left!!.right = TreeNode(1)
    root.right!!.right = TreeNode(1)
    
    // Paths:
    // 1->1->0 = binary 110 = 6
    // 1->1->1 = binary 111 = 7
    // 1->0->1 = binary 101 = 5
    // Sum: 6 + 7 + 5 = 18
    val result = sumRootToLeaf(root)
    assertEquals(18, result)
  }
}
