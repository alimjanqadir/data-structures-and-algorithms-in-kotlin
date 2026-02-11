package problems

/**
 * Solution for finding the longest balanced subarray
 * Time Complexity: O(n log n) where n is the length of the input array
 * Space Complexity: O(n) for the segment tree and hash map
 */
fun longestBalanced(nums: IntArray): Int {
  val arrayLength = nums.size
  if (arrayLength == 0) return 0

  val segmentTreeSize = arrayLength + 1
  val balanceSegmentTree = SegmentTree(segmentTreeSize)

  val lastSeenIndexByValue = mutableMapOf<Int, Int>()

  var prefixBalance = 0
  var longestLength = 0

  for (currentIndex in 1..arrayLength) {
    val value = nums[currentIndex - 1]
    val parityDelta = if (value % 2 == 1) 1 else -1

    if (lastSeenIndexByValue.containsKey(value)) {
      val previousIndex = lastSeenIndexByValue[value]!!
      balanceSegmentTree.update(previousIndex, arrayLength, -parityDelta)
      prefixBalance -= parityDelta
    }

    prefixBalance += parityDelta
    lastSeenIndexByValue[value] = currentIndex

    balanceSegmentTree.update(currentIndex, arrayLength, parityDelta)

    val earliestIndexWithSameBalance =
      balanceSegmentTree.findFirstIndexWithValue(prefixBalance)

    val currentLength = currentIndex - earliestIndexWithSameBalance
    longestLength = maxOf(longestLength, currentLength)
  }

  return longestLength
}

private class SegmentTree(treeSize: Int) {

  private val leafBaseIndex: Int
  private val pendingDelta: IntArray
  private val minValue: IntArray
  private val maxValue: IntArray

  init {
    leafBaseIndex =
      if (treeSize <= 1) 1
      else {
        var base = 1
        while (base < treeSize) base = base shl 1
        base
      }

    pendingDelta = IntArray(leafBaseIndex)
    minValue = IntArray(leafBaseIndex * 2)
    maxValue = IntArray(leafBaseIndex * 2)
  }

  fun update(leftIndex: Int, rightIndex: Int, delta: Int) {
    var left = leftIndex + leafBaseIndex
    var right = rightIndex + leafBaseIndex

    val originalLeft = left
    val originalRight = right

    while (left <= right) {
      if (left and 1 == 1) applyDelta(left++, delta)
      if (right and 1 == 0) applyDelta(right--, delta)
      left = left shr 1
      right = right shr 1
    }

    propagateUp(originalLeft)
    propagateUp(originalRight)
  }

  private fun applyDelta(nodeIndex: Int, delta: Int) {
    minValue[nodeIndex] += delta
    maxValue[nodeIndex] += delta
    if (nodeIndex < leafBaseIndex) {
      pendingDelta[nodeIndex] += delta
    }
  }

  private fun propagateUp(nodeIndex: Int) {
    var current = nodeIndex shr 1
    while (current > 0) {
      minValue[current] =
        minOf(minValue[current shl 1], minValue[(current shl 1) or 1]) +
        pendingDelta[current]

      maxValue[current] =
        maxOf(maxValue[current shl 1], maxValue[(current shl 1) or 1]) +
        pendingDelta[current]

      current = current shr 1
    }
  }

  private fun propagateDown(nodeIndex: Int) {
    val height =
      if (nodeIndex == 0) 0
      else 31 - Integer.numberOfLeadingZeros(nodeIndex)

    for (level in height - 1 downTo 0) {
      val current = nodeIndex shr level
      val delta = pendingDelta[current]
      if (delta != 0) {
        applyDelta(current shl 1, delta)
        applyDelta((current shl 1) or 1, delta)
        pendingDelta[current] = 0
      }
    }
  }

  fun findFirstIndexWithValue(targetValue: Int): Int {
    var nodeIndex = 1

    while (nodeIndex < leafBaseIndex) {
      if (pendingDelta[nodeIndex] != 0) {
        propagateDown(nodeIndex)
      }

      val leftChild = nodeIndex shl 1

      nodeIndex =
        if (minValue[leftChild] > targetValue ||
          maxValue[leftChild] < targetValue
        ) {
          leftChild or 1
        } else {
          leftChild
        }
    }

    return nodeIndex - leafBaseIndex
  }
}
