package problems

import java.util.BitSet

fun maxSum(nums: IntArray): Long {
  val positiveSeen = BitSet()

  var distinctPositiveSum = 0L
  var foundZero = false
  var bestNegative = Int.MIN_VALUE

  for (v in nums) {
    when {
      v > 0 -> if (!positiveSeen.get(v)) {
        positiveSeen.set(v)
        distinctPositiveSum += v
      }
      v == 0 -> foundZero = true
      else -> if (v > bestNegative) bestNegative = v
    }
  }

  return when {
    distinctPositiveSum > 0L -> distinctPositiveSum
    foundZero -> 0L
    else -> bestNegative.toLong()
  }
}
