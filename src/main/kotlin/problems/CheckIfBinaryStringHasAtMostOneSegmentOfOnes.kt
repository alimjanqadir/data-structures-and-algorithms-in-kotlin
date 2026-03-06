package problems

/**
 * 1784. Check if Binary String Has at Most One Segment of Ones
 * 
 * Given a binary string s without leading zeros, return true if s contains at most one contiguous segment of ones.
 * Otherwise, return false.
 */
object CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    
  fun checkOnesSegment(s: String): Boolean {
    var foundZeroAfterOnes = false
        
    for (index in 1 until s.length) {
      val previousChar = s[index - 1]
      val currentChar = s[index]

      if (previousChar == '1' && currentChar == '0') {
        foundZeroAfterOnes = true
      } else if (foundZeroAfterOnes && previousChar == '0' && currentChar == '1') {
        return false
      }
    }

    return true
  }
}
