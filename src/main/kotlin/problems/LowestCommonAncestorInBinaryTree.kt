import problems.TreeNode

/**
 * Definition for a binary tree node.
 */
private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
  // Base cases
  if (root == null || root === p || root === q) {
    return root
  }

  // Recursively search in left and right subtrees
  val leftSearch = lowestCommonAncestor(root.left, p, q)
  val rightSearch = lowestCommonAncestor(root.right, p, q)

  // Case 1: If both searches found something, current node is LCA
  if (leftSearch != null && rightSearch != null) {
    return root
  }

  // Case 2: Return whichever search found a node (or null if neither did)
  return leftSearch ?: rightSearch
}

fun main() {
  // Test helper function to verify results
  fun testLCA(description: String, root: TreeNode?, p: Int, q: Int, expected: Int) {
    // Find the actual nodes for p and q
    fun findNode(root: TreeNode?, value: Int): TreeNode? {
      if (root == null || root.`val` == value) return root
      return findNode(root.left, value) ?: findNode(root.right, value)
    }

    val pNode = findNode(root, p)
    val qNode = findNode(root, q)
    val result = lowestCommonAncestor(root, pNode, qNode)?.`val`

    println("\nTest: $description")
    println("Finding LCA of $p and $q")
    println("Expected: $expected")
    println("Got: $result")
    println("Result: ${if (result == expected) "PASS" else "FAIL"}")

    assert(result == expected) { "Expected $expected but got $result" }
  }

  // Test 1: Example from problem statement
  val tree1 = TreeNode(3).apply {
    left = TreeNode(5).apply {
      left = TreeNode(6)
      right = TreeNode(2).apply {
        left = TreeNode(7)
        right = TreeNode(4)
      }
    }
    right = TreeNode(1).apply {
      left = TreeNode(0)
      right = TreeNode(8)
    }
  }
  testLCA("Problem Example 1", tree1, 5, 1, 3)
  testLCA("Problem Example 2", tree1, 5, 4, 5)

  // Test 2: Minimal tree
  val tree2 = TreeNode(1).apply {
    left = TreeNode(2)
  }
  testLCA("Minimal Tree", tree2, 1, 2, 1)

  // Test 3: Linear path (skewed tree)
  val tree3 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(3)
    }
  }
  testLCA("Linear Path", tree3, 2, 3, 2)

  // Test 4: Balanced tree
  val tree4 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4)
      right = TreeNode(5)
    }
    right = TreeNode(3).apply {
      left = TreeNode(6)
      right = TreeNode(7)
    }
  }
  testLCA("Balanced Tree - Same Level", tree4, 4, 5, 2)
  testLCA("Balanced Tree - Cross Subtrees", tree4, 4, 6, 1)

  // Test 5: Depth differences
  val tree5 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4).apply {
        left = TreeNode(8)
        right = TreeNode(9).apply {
          right = TreeNode(10)
        }
      }
    }
    right = TreeNode(3).apply {
      right = TreeNode(7)
    }
  }
  testLCA("Deep Nodes Same Subtree", tree5, 8, 10, 4)
  testLCA("Deep Node with Shallow Node", tree5, 8, 7, 1)

  println("\nAll tests passed!")
}