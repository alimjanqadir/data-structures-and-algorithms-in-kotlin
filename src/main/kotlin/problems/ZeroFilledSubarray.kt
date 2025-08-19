package problems

fun zeroFilledSubarray(nums: IntArray): Long {
  var consecutiveZeros: Long = 0L
  var totalZeroOnlySubarrays: Long = 0L

  for (value in nums) {
    if (value == 0) {
      consecutiveZeros += 1L
      totalZeroOnlySubarrays += consecutiveZeros
    } else {
      consecutiveZeros = 0L
    }
  }
  return totalZeroOnlySubarrays
}

