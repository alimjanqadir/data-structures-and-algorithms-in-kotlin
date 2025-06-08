package problems

/**
 * Returns the lexicographically smallest equivalent string of [baseStr]
 * based on the equivalence pairs provided in [s1] and [s2].
 *
 * Each pair of characters at the same position in [s1] and [s2] is
 * considered equivalent. The algorithm uses a union‑find data structure
 * over the 26 lowercase letters so that every group of equivalent
 * characters is represented by its smallest element.
 */
fun smallestEquivalentString(
  s1: String,
  s2: String,
  baseStr: String
): String {
  // Each letter initially leads its own set
  val parent = IntArray(26) { it }

  // Find the representative character for the given index
  fun findLeader(letterIndex: Int): Int {
    if (parent[letterIndex] != letterIndex) {
      parent[letterIndex] = findLeader(parent[letterIndex])
    }
    return parent[letterIndex]
  }

  // Merge the sets for the two given letters, keeping the smaller as leader
  fun mergeSets(firstIndex: Int, secondIndex: Int) {
    val leaderA = findLeader(firstIndex)
    val leaderB = findLeader(secondIndex)
    if (leaderA == leaderB) return

    if (leaderA < leaderB) {
      parent[leaderB] = leaderA
    } else {
      parent[leaderA] = leaderB
    }
  }

  // Unite corresponding characters from s1 and s2
  for (position in s1.indices) {
    val index1 = s1[position] - 'a'
    val index2 = s2[position] - 'a'
    mergeSets(index1, index2)
  }

  // Build the resulting string using the smallest representative for each char
  val resultBuilder = StringBuilder()
  for (originalChar in baseStr) {
    val minimalCharIndex = findLeader(originalChar - 'a')
    resultBuilder.append('a' + minimalCharIndex)
  }
  return resultBuilder.toString()
}
