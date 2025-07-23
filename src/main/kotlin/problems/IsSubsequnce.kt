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

