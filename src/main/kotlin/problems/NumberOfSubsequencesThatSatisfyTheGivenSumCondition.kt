package problems

/**
 * Returns the count of non-empty subsequences where the sum of the minimum and maximum
 * elements is less than or equal to the given [target]. The answer is returned modulo
 * `1_000_000_007`.
 */
fun numSubseq(numbers: IntArray, target: Int): Int {
  val modulo = 1_000_000_007
  numbers.sort()

  val elementCount = numbers.size
  if (elementCount == 0) return 0

  // Precompute powers of two up to the array length.
  val powersOfTwo = IntArray(elementCount)
  powersOfTwo[0] = 1
  for (index in 1 until elementCount) {
    powersOfTwo[index] = ((powersOfTwo[index - 1].toLong() * 2) % modulo).toInt()
  }

  var leftIndex = 0
  var rightIndex = elementCount - 1
  var validSubsequenceTotal = 0

  while (leftIndex <= rightIndex) {
    val smallest = numbers[leftIndex]
    val largest = numbers[rightIndex]

    if (smallest + largest <= target) {
      // For a fixed pair of smallest and largest, any subset of the middle
      // elements forms a valid subsequence. There are 2^(rightIndex - leftIndex)
      // such subsets.
      validSubsequenceTotal =
        (validSubsequenceTotal + powersOfTwo[rightIndex - leftIndex]) % modulo
      leftIndex += 1
    } else {
      rightIndex -= 1
    }
  }

  return validSubsequenceTotal
}
