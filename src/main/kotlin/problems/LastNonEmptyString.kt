package problems

/**
 * 2844. Minimum Possible String After at Most One Operation
 * LeetCode problem: Easy
 *
 * Returns the lexicographically minimum string achievable after at most one operation.
 * Operation: pick an index i and make s[i] the smallest character that is strictly
 * smaller than all its neighboring characters.
 *
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the result string
 *
 * @param s Input string consisting of lowercase English letters
 * @return Minimum possible string after at most one operation
 */
fun lastNonEmptyString(s: String): String {
  // Track the last occurrence index of each character
  val lastOccurrence = IntArray(26) { -1 }
  
  // First pass: find the last occurrence of each character
  for (i in s.indices) {
    lastOccurrence[s[i] - 'a'] = i
  }
  
  // Find the maximum last occurrence index among all characters that appear
  var maxLastIndex = -1
  for (index in lastOccurrence) {
    if (index > maxLastIndex) {
      maxLastIndex = index
    }
  }
  
  // Collect characters whose last occurrence is at maxLastIndex
  // These characters form the last non-empty string
  val result = StringBuilder()
  for (i in s.indices) {
    if (lastOccurrence[s[i] - 'a'] == i && i <= maxLastIndex) {
      // This is the last occurrence of this character
      result.append(s[i])
    }
  }
  
  return result.toString()
}
