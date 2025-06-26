package problems

/**
 * 2311. Longest Binary Subsequence Less Than or Equal to K
 *
 * Returns the length of the longest subsequence of the given binary string that
 * forms a binary number less than or equal to [limit].
 */
fun longestSubsequence(originalBinaryString: String, limit: Int): Int {
  var selectedCharacterCount = 0  // length of chosen subsequence
  var currentNumericValue = 0L    // value of chosen bits so far
  var currentBitWeight = 1L       // 2⁰ for the least-significant bit

  for (position in originalBinaryString.lastIndex downTo 0) {
    val currentCharacter = originalBinaryString[position]

    if (currentCharacter == '0') {
      selectedCharacterCount += 1  // zeros never change the value
    } else { // currentCharacter == '1'
      if (currentBitWeight <= limit.toLong() &&
        currentNumericValue + currentBitWeight <= limit.toLong()
      ) {
        currentNumericValue += currentBitWeight
        selectedCharacterCount += 1
      }
    }

    // Prepare weight for the next more-significant bit; stop growing once useless
    if (currentBitWeight <= limit.toLong()) {
      currentBitWeight = currentBitWeight shl 1
    }
  }
  return selectedCharacterCount
}
