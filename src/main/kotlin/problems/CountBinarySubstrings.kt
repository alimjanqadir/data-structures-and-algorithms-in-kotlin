package problems

/**
 * Solution for counting binary substrings with equal number of consecutive 0s and 1s
 * Time Complexity: O(N) where N is the length of the input string
 * Space Complexity: O(1) - only uses constant extra space
 */
fun countBinarySubstrings(s: String): Int {
  var previousGroupLength = 0
  var currentGroupLength = 1
  var validSubstringCount = 0

  for (index in 1 until s.length) {

    if (s[index] == s[index - 1]) {
      currentGroupLength += 1
    } else {
      validSubstringCount += minOf(previousGroupLength, currentGroupLength)
      previousGroupLength = currentGroupLength
      currentGroupLength = 1
    }
  }

  validSubstringCount += minOf(previousGroupLength, currentGroupLength)

  return validSubstringCount
}
