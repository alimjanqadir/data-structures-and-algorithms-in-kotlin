package algorithms

class Solution {

  fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
    val segmentTree = SegmentTree(baskets)
    var unplacedCount = 0

    for (requiredQuantity in fruits) {
      if (segmentTree.maximumCapacity() < requiredQuantity) {
        unplacedCount += 1            // no basket can accommodate this fruit type
      } else {
        val basketPosition = segmentTree.findFirstFittingBasket(requiredQuantity)
        segmentTree.markBasketUsed(basketPosition)
      }
    }
    return unplacedCount
  }

  // ──────────────────────────────────────────────────────────────────────────────
  private class SegmentTree(private val capacities: IntArray) {

    private val size = capacities.size
    private val maxTree = IntArray(size * 4)

    init { build(node = 1, left = 0, right = size - 1) }

    /** Public helpers */

    fun maximumCapacity(): Int = maxTree[1]

    fun findFirstFittingBasket(required: Int): Int =
      findFirst(node = 1, left = 0, right = size - 1, required)

    fun markBasketUsed(basketIndex: Int) =
      update(node = 1, left = 0, right = size - 1, targetIndex = basketIndex, newValue = 0)

    /** Segment-tree internals */

    private fun build(node: Int, left: Int, right: Int) {
      if (left == right) {
        maxTree[node] = capacities[left]
        return
      }
      val mid = (left + right) ushr 1
      build(node * 2, left, mid)
      build(node * 2 + 1, mid + 1, right)
      maxTree[node] = maxOf(maxTree[node * 2], maxTree[node * 2 + 1])
    }

    private fun update(
      node: Int,
      left: Int,
      right: Int,
      targetIndex: Int,
      newValue: Int
    ) {
      if (left == right) {
        maxTree[node] = newValue
        return
      }
      val mid = (left + right) ushr 1
      if (targetIndex <= mid) {
        update(node * 2, left, mid, targetIndex, newValue)
      } else {
        update(node * 2 + 1, mid + 1, right, targetIndex, newValue)
      }
      maxTree[node] = maxOf(maxTree[node * 2], maxTree[node * 2 + 1])
    }

    private fun findFirst(
      node: Int,
      left: Int,
      right: Int,
      required: Int
    ): Int {
      if (maxTree[node] < required) {
        return -1        // unreachable in correct usage
      }
      if (left == right) {
        return left
      }
      val mid = (left + right) ushr 1
      return if (maxTree[node * 2] >= required) {
        findFirst(node * 2, left, mid, required)
      } else {
        findFirst(node * 2 + 1, mid + 1, right, required)
      }
    }
  }
}
