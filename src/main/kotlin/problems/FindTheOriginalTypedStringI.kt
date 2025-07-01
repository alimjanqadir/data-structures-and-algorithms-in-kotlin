package problems

/**
 * LeetCode 2930. Find the Original Typed String I
 *
 * Given the final typed string [word], returns the total number of possible
 * original strings Alice could have intended to type when she might have held
 * down at most one key too long.
 */
fun possibleStringCount(word: String): Long {
  if (word.isEmpty()) return 0

  var runCount = 1
  for (i in 1 until word.length) {
    if (word[i] != word[i - 1]) {
      runCount += 1
    }
  }
  return word.length.toLong() - runCount + 1
}
