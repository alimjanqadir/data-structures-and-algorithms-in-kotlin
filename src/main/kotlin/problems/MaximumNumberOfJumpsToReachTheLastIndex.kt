package problems

/**
 * LeetCode 2770. Maximum Number of Jumps to Reach the Last Index
 * https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/
 */
fun maximumJumps(nums: IntArray, target: Int): Int {
  val compressedValues = nums
    .map { it.toLong() }
    .distinct()
    .sorted()
    .toLongArray()

  val segmentTree = MaximumJumpsSegmentTree(compressedValues.size)

  for (index in nums.indices) {
    val currentValue = nums[index].toLong()
    val lowBound = currentValue - target.toLong()
    val highBound = currentValue + target.toLong()

    val leftPosition = maximumJumpsLowerBound(compressedValues, lowBound)
    val rightPositionExclusive = maximumJumpsUpperBound(compressedValues, highBound)

    val bestPrevious = if (leftPosition < rightPositionExclusive) {
      segmentTree.query(leftPosition, rightPositionExclusive - 1)
    } else {
      -1
    }

    val currentJumps = when {
      index == 0 -> 0
      bestPrevious == -1 -> -1
      else -> bestPrevious + 1
    }

    if (currentJumps != -1) {
      val compressedIndex = maximumJumpsLowerBound(compressedValues, currentValue)
      segmentTree.update(compressedIndex, currentJumps)
    }
  }

  val lastValue = nums[nums.lastIndex].toLong()
  val lastCompressedIndex = maximumJumpsLowerBound(compressedValues, lastValue)
  return segmentTree.query(lastCompressedIndex, lastCompressedIndex)
}

private fun maximumJumpsLowerBound(values: LongArray, target: Long): Int {
  var left = 0
  var right = values.size

  while (left < right) {
    val middle = (left + right) ushr 1
    if (values[middle] < target) {
      left = middle + 1
    } else {
      right = middle
    }
  }

  return left
}

private fun maximumJumpsUpperBound(values: LongArray, target: Long): Int {
  var left = 0
  var right = values.size

  while (left < right) {
    val middle = (left + right) ushr 1
    if (values[middle] <= target) {
      left = middle + 1
    } else {
      right = middle
    }
  }

  return left
}

private class MaximumJumpsSegmentTree(private val size: Int) {
  private val tree = IntArray(size * 4) { -1 }

  fun update(position: Int, value: Int) {
    update(1, 0, size - 1, position, value)
  }

  private fun update(node: Int, left: Int, right: Int, position: Int, value: Int) {
    if (left == right) {
      tree[node] = maxOf(tree[node], value)
      return
    }

    val middle = (left + right) ushr 1
    if (position <= middle) {
      update(node * 2, left, middle, position, value)
    } else {
      update(node * 2 + 1, middle + 1, right, position, value)
    }

    tree[node] = maxOf(tree[node * 2], tree[node * 2 + 1])
  }

  fun query(queryLeft: Int, queryRight: Int): Int {
    if (queryLeft > queryRight) {
      return -1
    }
    return query(1, 0, size - 1, queryLeft, queryRight)
  }

  private fun query(
    node: Int,
    left: Int,
    right: Int,
    queryLeft: Int,
    queryRight: Int
  ): Int {
    if (queryRight < left || right < queryLeft) {
      return -1
    }

    if (queryLeft <= left && right <= queryRight) {
      return tree[node]
    }

    val middle = (left + right) ushr 1
    val leftResult = query(node * 2, left, middle, queryLeft, queryRight)
    val rightResult = query(node * 2 + 1, middle + 1, right, queryLeft, queryRight)
    return maxOf(leftResult, rightResult)
  }
}
