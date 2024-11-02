package problems

/**
 * Finds the minimal length of a substring containing at least 'k' occurrences
 * of each character 'a', 'b', and 'c' by only removing characters from the
 * left and/or right ends of the string.
 *
 * @param s The input string consisting of 'a', 'b', and 'c'.
 * @param k The minimum required occurrences for each character.
 * @return The length of the shortest valid substring, or -1 if impossible.
 */
fun takeCharacters(s: String, k: Int): Int {
  val n = s.length
  val totalCounts = IntArray(3) // Total counts of 'a', 'b', 'c' in the string.

  // Calculate total counts of each character.
  for (char in s) {
    totalCounts[char - 'a']++
  }

  // If any character occurs fewer than 'k' times, return -1.
  if (totalCounts.any { it < k }) return -1

  // If 'k' is zero, no need to remove any characters.
  if (k == 0) return 0

  // Maximum number of each character we can remove.
  val maxRemovals = IntArray(3) { totalCounts[it] - k }
  var left = 0 // Left pointer for the sliding window.
  var maxWindowLength = 0 // Maximum length of the window we can remove.
  val windowCounts = IntArray(3) // Counts of characters in the current window.

  // Iterate over the string with the right pointer.
  for (right in s.indices) {
    val idxRight = s[right] - 'a'
    windowCounts[idxRight]++ // Include current character in the window.

    // Shrink the window from the left if counts exceed the maximum removals.
    while (windowCounts[idxRight] > maxRemovals[idxRight]) {
      val idxLeft = s[left] - 'a'
      windowCounts[idxLeft]--
      left++
    }

    // Update the maximum window length.
    maxWindowLength = maxOf(maxWindowLength, right - left + 1)
  }

  // The minimal length is the total length minus the maximum removable window length.
  return n - maxWindowLength
}

fun takeCharactersFunctional(s: String, k: Int): Int {
  val totalCounts = s.groupingBy { it }.eachCount().withDefault { 0 }
  if (listOf('a', 'b', 'c').any { totalCounts.getValue(it) < k }) return -1
  if (k == 0) return 0

  val maxRemovals = listOf('a', 'b', 'c').associateWith { totalCounts.getValue(it) - k }

  data class State(val left: Int, val counts: Map<Char, Int>, val maxWindowLength: Int)

  val initialState = State(0, mapOf('a' to 0, 'b' to 0, 'c' to 0), 0)

  val finalState = s.foldIndexed(initialState) { right, state, c ->
    val newCounts = state.counts + (c to state.counts.getValue(c) + 1)
    var newLeft = state.left
    var updatedCounts = newCounts
    while (updatedCounts.getValue(c) > maxRemovals.getValue(c)) {
      val leftChar = s[newLeft]
      updatedCounts = updatedCounts + (leftChar to updatedCounts.getValue(leftChar) - 1)
      newLeft++
    }
    val newWindowLength = right - newLeft + 1
    val newMaxWindowLength = maxOf(state.maxWindowLength, newWindowLength)
    State(newLeft, updatedCounts, newMaxWindowLength)
  }

  return s.length - finalState.maxWindowLength
}

fun takeCharactersBruteForce(s: String, k: Int): Int {
  val n = s.length
  var minLength = Int.MAX_VALUE
  for (left in 0..n) {
    for (right in n downTo left) {
      val substring = s.substring(left, right)
      val counts = substring.groupingBy { it }.eachCount()
      if (counts.getOrDefault('a', 0) >= k &&
        counts.getOrDefault('b', 0) >= k &&
        counts.getOrDefault('c', 0) >= k) {
        minLength = minOf(minLength, substring.length)
      }
    }
  }
  return if (minLength == Int.MAX_VALUE) -1 else minLength
}

fun main() {
  assert(takeCharacters("aabaaaacaabc", 2) == 8)
  assert(takeCharacters("abcabc", 2) == 6)
  assert(takeCharacters("abc", 1) == 3)
  assert(takeCharacters("a", 1) == -1)
  assert(takeCharacters("aaabbbccc", 2) == 6)
  assert(takeCharacters("abaccc", 2) == -1)
  println("All test cases passed.")
}