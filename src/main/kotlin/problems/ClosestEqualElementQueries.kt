package problems

/**
 * 3488. Closest Equal Element Queries
 *
 * For each query index, find the closest equal element in the circular array.
 *
 * Key Idea: Group indices by value, then for each query, use binary search to find
 * the closest neighbors in the sorted index list. Consider circular distance.
 *
 * Time Complexity: O(n + q log n) where n is length of nums, q is number of queries
 * Space Complexity: O(n) for storing indices by value
 *
 * @param nums The input array of integers
 * @param queries Array of query indices
 * @return List of closest distances for each query, -1 if no equal element exists
 */
fun closestEqualElementQueries(nums: IntArray, queries: IntArray): List<Int> {
  val valueToIndices = HashMap<Int, MutableList<Int>>()
  val arrayLength = nums.size

  // Step 1: Group indices by value
  for (index in nums.indices) {
    val value = nums[index]
    valueToIndices.computeIfAbsent(value) { mutableListOf() }.add(index)
  }

  val result = MutableList(queries.size) { 0 }

  // Step 2: Process each query
  for (queryIndex in queries.indices) {
    val currentIndex = queries[queryIndex]
    val value = nums[currentIndex]
    val indicesList = valueToIndices[value]!!

    if (indicesList.size == 1) {
      result[queryIndex] = -1
      continue
    }

    // Binary search for currentIndex and get left/right neighbors
    val pos = indicesList.binarySearch(currentIndex)

    val leftIndex: Int
    val rightIndex: Int

    if (pos >= 0) {
      // Found: get neighbors at pos-1 and pos+1
      leftIndex = indicesList[(pos - 1 + indicesList.size) % indicesList.size]
      rightIndex = indicesList[(pos + 1) % indicesList.size]
    } else {
      // Not found: use insertion point
      val insertionPoint = -pos - 1
      leftIndex = indicesList[(insertionPoint - 1 + indicesList.size) % indicesList.size]
      rightIndex = indicesList[insertionPoint % indicesList.size]
    }

    // Filter out the current index itself (if somehow included)
    val candidates = mutableListOf<Int>()
    if (leftIndex != currentIndex) candidates.add(leftIndex)
    if (rightIndex != currentIndex && rightIndex != leftIndex) candidates.add(rightIndex)

    // Calculate minimum circular distance
    var minDistance = Int.MAX_VALUE
    for (candidate in candidates) {
      val dist = circularDistance(currentIndex, candidate, arrayLength)
      minDistance = minOf(minDistance, dist)
    }

    result[queryIndex] = minDistance
  }

  return result
}

private fun circularDistance(firstIndex: Int, secondIndex: Int, arrayLength: Int): Int {
  val directDistance = kotlin.math.abs(firstIndex - secondIndex)
  return minOf(directDistance, arrayLength - directDistance)
}
