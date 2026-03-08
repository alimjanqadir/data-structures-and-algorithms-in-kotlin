package problems

/**
 * 1658. Find Different Binary String
 *
 * Given an array of strings representing binary numbers, each string has the same length n.
 * The array contains all possible binary strings of length n except one.
 * Your task is to find the missing binary string.
 *
 * Approach: Use diagonal method - flip the bit at each diagonal position to guarantee
 * the result differs from all strings in the array.
 */
fun findDifferentBinaryString(binaryStrings: Array<String>): String {

  val length = binaryStrings[0].length
  val resultBuilder = StringBuilder()

  for (rowIndex in 0 until binaryStrings.size) {

    // Only access diagonal if within bounds
    val diagonalBit = if (rowIndex < length) {
      binaryStrings[rowIndex][rowIndex]
    } else {
      '0' // Default value if out of bounds
    }

    val flippedBit =
      if (diagonalBit == '0') '1'
      else '0'

    resultBuilder.append(flippedBit)
  }

  // If we have fewer strings than length, fill the rest with '0's
  while (resultBuilder.length < length) {
    resultBuilder.append('0')
  }

  return resultBuilder.toString()
}
