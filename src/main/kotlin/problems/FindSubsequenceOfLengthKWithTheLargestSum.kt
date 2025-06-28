package problems

import java.util.PriorityQueue

/**
 * Returns a subsequence of length [subsequenceLength] with the largest possible sum.
 * Elements maintain their relative order from [nums].
 */
fun maxSubsequence(nums: IntArray, subsequenceLength: Int): IntArray {
  data class Element(val value: Int, val originalIndex: Int)

  // Min-heap ordered by value, preferring later indices when values tie
  val smallestPreferred = PriorityQueue<Element> { a, b ->
    if (a.value != b.value) {
      a.value - b.value
    } else {
      b.originalIndex - a.originalIndex
    }
  }

  // Keep only the best `subsequenceLength` elements
  for (index in nums.indices) {
    smallestPreferred.add(Element(nums[index], index))
    if (smallestPreferred.size > subsequenceLength) {
      smallestPreferred.poll()
    }
  }

  // Extract remaining elements sorted by original index
  val chosen = smallestPreferred.toTypedArray().sortedBy { it.originalIndex }
  val result = IntArray(subsequenceLength)
  for (position in chosen.indices) {
    result[position] = chosen[position].value
  }

  return result
}
