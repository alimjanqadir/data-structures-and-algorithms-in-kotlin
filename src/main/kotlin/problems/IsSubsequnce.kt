package problems

fun isSubsequence(s: String, t: String): Boolean {
  var i = 0 // Pointer for s
  var j = 0 // Pointer for t

  // Iterate through t
  while (i < s.length && j < t.length) {
    if (s[i] == t[j]) {
      i++ // Match found, move to next character in s
    }
    j++ // Always move to next character in t
  }

  // If all characters in s were matched
  return i == s.length
}

fun isSubsequenceFunctional(s: String, t: String): Boolean {
  val sLength = s.length
  // Use fold to traverse t and accumulate matched characters
  val matchedChars = t.fold(0) { index, c ->
    when {
      index == sLength -> index // All characters matched
      s[index] == c -> index + 1 // Match found, increment index
      else -> index // No match, keep index unchanged
    }
  }
  // Check if all characters in s were matched
  return matchedChars == sLength
}

fun main() {
  // Test Case 1
  assert(isSubsequence("abc", "ahbgdc")) { "Test Case 1 Failed" }
  // Test Case 2
  assert(!isSubsequence("axc", "ahbgdc")) { "Test Case 2 Failed" }
  // Test Case 3: Empty s
  assert(isSubsequence("", "ahbgdc")) { "Test Case 3 Failed" }
  // Test Case 4: Empty t
  assert(!isSubsequence("abc", "")) { "Test Case 4 Failed" }
  // Test Case 5: Both s and t are empty
  assert(isSubsequence("", "")) { "Test Case 5 Failed" }
  // Test Case 6: Repeating characters in s
  assert(!isSubsequence("aaaaaa", "bbaaaa")) { "Test Case 6 Failed" }
  // Test Case 7: s equals t
  assert(isSubsequence("abc", "abc")) { "Test Case 7 Failed" }
  // Test Case 8: Characters out of order
  assert(!isSubsequence("abc", "acb")) { "Test Case 8 Failed" }
  // Test Case 9: Long strings
  val longS = "a".repeat(100)
  val longT = "a".repeat(10000)
  assert(isSubsequence(longS, longT)) { "Test Case 9 Failed" }
  // Test Case 10: s longer than t
  assert(!isSubsequence("abcde", "abc")) { "Test Case 10 Failed" }

  println("All test cases passed!")
}
