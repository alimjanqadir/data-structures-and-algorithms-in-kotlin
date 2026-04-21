package problems

/**
 * LeetCode 1722: Minimize Hamming Distance After Swap Operations
 *
 * The allowed swaps define groups of indices that can freely rearrange values among themselves.
 * Inside each connected component, any permutation is achievable.
 * For each component, we match values from source to target as much as possible.
 *
 * Time Complexity: O(n α(n)) where n is the length of source array and α is the inverse Ackermann function
 * Space Complexity: O(n)
 */
fun minimumHammingDistance(
  source: IntArray,
  target: IntArray,
  allowedSwaps: Array<IntArray>
): Int {

  val parent = IntArray(source.size) { it }

  fun find(index: Int): Int {
    if (parent[index] != index) {
      parent[index] = find(parent[index])
    }
    return parent[index]
  }

  fun union(indexA: Int, indexB: Int) {
    val rootA = find(indexA)
    val rootB = find(indexB)
    if (rootA != rootB) {
      parent[rootA] = rootB
    }
  }

  // Build components using Union-Find
  for (swap in allowedSwaps) {
    union(swap[0], swap[1])
  }

  // Group indices by root
  val componentMap = HashMap<Int, MutableList<Int>>()
  for (index in source.indices) {
    val root = find(index)
    componentMap.computeIfAbsent(root) { mutableListOf() }.add(index)
  }

  var hammingDistance = 0

  // Process each component
  for (indices in componentMap.values) {
    val frequency = HashMap<Int, Int>()

    // Count source values in this component
    for (index in indices) {
      val value = source[index]
      frequency[value] = frequency.getOrDefault(value, 0) + 1
    }

    // Match target values
    for (index in indices) {
      val value = target[index]
      val count = frequency.getOrDefault(value, 0)

      if (count > 0) {
        frequency[value] = count - 1
      } else {
        hammingDistance += 1
      }
    }
  }

  return hammingDistance
}
