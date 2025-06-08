package problems

/**
 * LeetCode 2900. Longest Unequal Adjacent Groups Subsequence I
 * Returns the longest subsequence where adjacent words belong to different groups.
 * @param words Array of words
 * @param groups Array of group ids
 * @return List<String> - the longest valid subsequence
 */
fun longestUnequalAdjacentGroupsSubsequenceI(words: Array<String>, groups: IntArray): List<String> {
  val result = mutableListOf<String>()
  if (words.isNotEmpty()) {
    result.add(words[0])
    var lastGroup = groups[0]
    for (i in 1 until words.size) {
      if (groups[i] != lastGroup) {
        result.add(words[i])
        lastGroup = groups[i]
      }
    }
  }
  return result
}
