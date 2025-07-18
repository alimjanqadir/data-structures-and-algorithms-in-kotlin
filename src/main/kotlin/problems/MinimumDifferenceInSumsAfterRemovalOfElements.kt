package problems

import java.util.PriorityQueue

/**
 * Computes the minimum possible difference between the sum of the first n elements
 * and the sum of the next n elements after removing exactly n elements from the input array.
 * The array size must be a multiple of three and equals 3 * n.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 */
fun minimumDifference(nums: IntArray): Long {
  val totalLength = nums.size
  val groupSize = totalLength / 3

  val leftMinSum = LongArray(totalLength)
  val maxHeap = PriorityQueue<Int>(compareByDescending { it })
  var currentLeftSum = 0L

  for (index in nums.indices) {
    val value = nums[index]
    maxHeap.add(value)
    currentLeftSum += value.toLong()
    if (maxHeap.size > groupSize) {
      currentLeftSum -= maxHeap.poll().toLong()
    }
    if (index >= groupSize - 1) {
      leftMinSum[index] = currentLeftSum
    }
  }

  val rightMaxSum = LongArray(totalLength + 1)
  val minHeap = PriorityQueue<Int>()
  var currentRightSum = 0L

  for (index in nums.indices.reversed()) {
    val value = nums[index]
    minHeap.add(value)
    currentRightSum += value.toLong()
    if (minHeap.size > groupSize) {
      currentRightSum -= minHeap.poll().toLong()
    }
    if (index <= totalLength - groupSize) {
      rightMaxSum[index] = currentRightSum
    }
  }

  var best = Long.MAX_VALUE
  for (split in (groupSize - 1) until (2 * groupSize)) {
    val candidate = leftMinSum[split] - rightMaxSum[split + 1]
    if (candidate < best) {
      best = candidate
    }
  }
  return best
}

