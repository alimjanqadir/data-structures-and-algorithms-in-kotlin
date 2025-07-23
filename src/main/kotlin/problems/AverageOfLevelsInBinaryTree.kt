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

