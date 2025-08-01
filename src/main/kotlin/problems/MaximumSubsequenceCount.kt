package problems

fun maximumSubsequenceCount(text: String, pattern: String): Long {
  // Efficient Approach
  // This function computes the maximum number of times the pattern can occur as a subsequence
  // after inserting either pattern[0] or pattern[1] exactly once anywhere in the text.
  val pattern0 = pattern[0]
  val pattern1 = pattern[1]

  // Special case when both characters in pattern are the same
  if (pattern0 == pattern1) {
    var count = 0L
    // Count the number of times pattern[0] appears in text
    for (c in text) {
      if (c == pattern0) {
        count += 1
      }
    }
    // After adding one more pattern[0], total subsequences is count * (count + 1) / 2
    return (count + 1) * count / 2
  } else {
    // For pattern[0] != pattern[1]
    var totalOccurrences = 0L // Total number of subsequences of pattern in text
    var countPattern0 = 0L    // Number of times pattern[0] has appeared so far
    var countPattern0Total = 0L // Total number of pattern[0] in text
    var countPattern1Total = 0L // Total number of pattern[1] in text

    // First pass to count total occurrences of pattern[0] and pattern[1] in text
    for (c in text) {
      if (c == pattern0) {
        countPattern0Total += 1
      }
      if (c == pattern1) {
        countPattern1Total += 1
      }
    }

    // Second pass to compute totalOccurrences of pattern as subsequence
    for (c in text) {
      if (c == pattern0) {
        countPattern0 += 1
      }
      if (c == pattern1) {
        // For each pattern[1], add the number of pattern[0] seen so far
        totalOccurrences += countPattern0
      }
    }

    // Option 1: Add pattern[0] at the beginning to maximize subsequences
    val totalOccurrencesOption1 = totalOccurrences + countPattern1Total
    // Option 2: Add pattern[1] at the end to maximize subsequences
    val totalOccurrencesOption2 = totalOccurrences + countPattern0Total
    // Return the maximum of the two options
    return maxOf(totalOccurrencesOption1, totalOccurrencesOption2)
  }
}

fun maximumSubsequenceCountFunctional(text: String, pattern: String): Long {
  val (pattern0, pattern1) = pattern.toCharArray()

  if (pattern0 == pattern1) {
    val count = text.count { it == pattern0 }.toLong()
    return (count + 1) * count / 2
  } else {
    val countPattern0Total = text.count { it == pattern0 }.toLong()
    val countPattern1Total = text.count { it == pattern1 }.toLong()
    var totalOccurrences = 0L
    var countPattern0 = 0L

    text.forEach { c ->
      if (c == pattern0) countPattern0++
      if (c == pattern1) totalOccurrences += countPattern0
    }

    val totalOccurrencesOption1 = totalOccurrences + countPattern1Total
    val totalOccurrencesOption2 = totalOccurrences + countPattern0Total

    return maxOf(totalOccurrencesOption1, totalOccurrencesOption2)
  }
}

