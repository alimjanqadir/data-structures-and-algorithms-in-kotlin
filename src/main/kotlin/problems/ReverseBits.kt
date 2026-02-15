package problems

/**
 * Solution for reversing bits of a 32-bit unsigned integer
 * Time Complexity: O(32) = O(1) - always processes 32 bits
 * Space Complexity: O(1) - uses constant extra space
 */
fun reverseBits(n: Int): Int {
  var remainingBits = n
  var reversedResult = 0
  var processedBitCount = 0

  while (processedBitCount < 32) {
    val currentBit = remainingBits and 1
    reversedResult = reversedResult shl 1
    reversedResult = reversedResult or currentBit
    remainingBits = remainingBits ushr 1
    processedBitCount += 1
  }

  return reversedResult
}
