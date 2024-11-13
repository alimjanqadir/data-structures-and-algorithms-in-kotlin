package problems

/**
 * Definition for a Node in a binary tree.
 */
private class Node(
  var value: Int,
  var left: Node? = null,
  var right: Node? = null,
  var next: Node? = null
)

/**
 * Populates next right pointers for each node in the binary tree.
 * Time Complexity: O(n) where n is the number of nodes
 * Space Complexity: O(1) as we only use constant extra space
 */
private fun connect(root: Node?): Node? {
  // Base case: empty tree
  if (root == null) return null

  // Start with the root node for level traversal
  var levelStart = root

  // Continue until we process all levels
  while (levelStart != null) {
    // Use a dummy node to build the next level's connections
    val dummyHead = Node(0)
    var current = dummyHead

    // Traverse the current level using the next pointers
    var levelNode = levelStart
    while (levelNode != null) {
      // Connect left child if it exists
      if (levelNode.left != null) {
        current.next = levelNode.left
        current = current.next!!
      }

      // Connect right child if it exists
      if (levelNode.right != null) {
        current.next = levelNode.right
        current = current.next!!
      }

      // Move to the next node in current level
      levelNode = levelNode.next
    }

    // Move to the start of next level
    // Find the first node of the next level
    levelStart = dummyHead.next
  }

  return root
}

/**
 * Example usage and test cases
 */
fun main() {
  // Create test case from Example 1
  val root = Node(1).apply {
    left = Node(2).apply {
      left = Node(4)
      right = Node(5)
    }
    right = Node(3).apply {
      right = Node(7)
    }
  }

  // Connect nodes
  connect(root)

  // Print level-order traversal with next pointers
  printLevelOrder(root)
}

/**
 * Utility function to print level-order traversal with next pointers
 */
private fun printLevelOrder(root: Node?) {
  var levelStart = root
  while (levelStart != null) {
    var current = levelStart
    while (current != null) {
      print("${current.value} -> ")
      current = current.next
    }
    println("#")
    levelStart = levelStart.left ?: levelStart.right
  }
}