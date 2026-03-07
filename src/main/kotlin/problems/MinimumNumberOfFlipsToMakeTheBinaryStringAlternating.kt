package problems

/**
 * 1888. Minimum Number of Flips to Make the Binary String Alternating
 *
 * You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:
 *
 * Type-1: Remove the character at the start of the string s and append it to the end of the string.
 * Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
 *
 * Return the minimum number of type-2 operations you need to perform such that s becomes alternating.
 *
 * The string is called alternating if no two adjacent characters are equal.
 *
 * For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
 */
fun minFlips(binaryString: String): Int {
  if (binaryString.isEmpty()) {
    return 0
  }

  val length = binaryString.length
  val doubledString = binaryString + binaryString

  var mismatchWithPatternA = 0
  var mismatchWithPatternB = 0

  var minimumFlips = Int.MAX_VALUE

  for (index in doubledString.indices) {

    val expectedPatternA = if (index % 2 == 0) '0' else '1'
    val expectedPatternB = if (index % 2 == 0) '1' else '0'

    if (doubledString[index] != expectedPatternA) {
      mismatchWithPatternA += 1
    }

    if (doubledString[index] != expectedPatternB) {
      mismatchWithPatternB += 1
    }

    if (index >= length) {

      val leftIndex = index - length

      val leftExpectedA = if (leftIndex % 2 == 0) '0' else '1'
      val leftExpectedB = if (leftIndex % 2 == 0) '1' else '0'

      if (doubledString[leftIndex] != leftExpectedA) {
        mismatchWithPatternA -= 1
      }

      if (doubledString[leftIndex] != leftExpectedB) {
        mismatchWithPatternB -= 1
      }
    }

    if (index >= length - 1) {
      minimumFlips = minOf(
        minimumFlips,
        mismatchWithPatternA,
        mismatchWithPatternB
      )
    }
  }

  return minimumFlips
}
