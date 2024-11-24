package problems

private fun averageOfLevels(root: TreeNode?): DoubleArray {
  if (root == null) return DoubleArray(0)

  // Use ArrayLists to store sums and counts for each level
  val sums = ArrayList<Long>()  // Using Long to prevent integer overflow
  val counts = ArrayList<Int>()

  // DFS to collect sums and counts
  fun dfs(node: TreeNode?, level: Int) {
    if (node == null) return

    // Extend lists if needed for this level
    if (level >= sums.size) {
      sums.add(0L)
      counts.add(0)
    }

    // Add current node's value to sum and increment count
    sums[level] = sums[level] + node.`val`
    counts[level]++

    // Process children
    dfs(node.left, level + 1)
    dfs(node.right, level + 1)
  }

  // Start DFS from root
  dfs(root, 0)

  // Calculate averages
  return DoubleArray(sums.size) { i ->
    sums[i].toDouble() / counts[i]
  }
}

fun main() {
  // Test Case 1: Example from problem statement
  println("Test Case 1: Regular balanced tree")
  val tree1 = TreeNode(3).apply {
    left = TreeNode(9)
    right = TreeNode(20).apply {
      left = TreeNode(15)
      right = TreeNode(7)
    }
  }
  println("Expected: [3.00000, 14.50000, 11.00000]")
  println("Actual  : ${averageOfLevels(tree1).joinToString(", ") { "%.5f".format(it) }}")
  println()

  // Test Case 2: Empty tree
  println("Test Case 2: Empty tree")
  println("Expected: []")
  println("Actual  : ${averageOfLevels(null).joinToString(", ") { "%.5f".format(it) }}")
  println()

  // Test Case 3: Single node
  println("Test Case 3: Single node")
  val tree3 = TreeNode(1)
  println("Expected: [1.00000]")
  println("Actual  : ${averageOfLevels(tree3).joinToString(", ") { "%.5f".format(it) }}")
  println()

  // Test Case 4: Left-heavy tree
  println("Test Case 4: Left-heavy tree")
  val tree4 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4)
      right = TreeNode(5)
    }
    right = TreeNode(3)
  }
  println("Expected: [1.00000, 2.50000, 4.50000]")
  println("Actual  : ${averageOfLevels(tree4).joinToString(", ") { "%.5f".format(it) }}")
  println()

  // Test Case 5: Large values (testing overflow handling)
  println("Test Case 5: Large values")
  val tree5 = TreeNode(2147483647).apply {  // MAX_INT
    left = TreeNode(2147483647)
    right = TreeNode(2147483647)
  }
  println("Expected: [2147483647.00000, 2147483647.00000]")
  println("Actual  : ${averageOfLevels(tree5).joinToString(", ") { "%.5f".format(it) }}")
  println()

  // Test Case 6: Perfect binary tree
  println("Test Case 6: Perfect binary tree")
  val tree6 = TreeNode(1).apply {
    left = TreeNode(2).apply {
      left = TreeNode(4)
      right = TreeNode(5)
    }
    right = TreeNode(3).apply {
      left = TreeNode(6)
      right = TreeNode(7)
    }
  }
  println("Expected: [1.00000, 2.50000, 5.50000]")
  println("Actual  : ${averageOfLevels(tree6).joinToString(", ") { "%.5f".format(it) }}")
  println()

  // Test Case 7: Negative values
  println("Test Case 7: Negative values")
  val tree7 = TreeNode(-10).apply {
    left = TreeNode(-5)
    right = TreeNode(-15).apply {
      left = TreeNode(-20)
      right = TreeNode(-25)
    }
  }
  println("Expected: [-10.00000, -10.00000, -22.50000]")
  println("Actual  : ${averageOfLevels(tree7).joinToString(", ") { "%.5f".format(it) }}")
}