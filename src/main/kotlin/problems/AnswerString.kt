package problems

/**
 * Finds the starting index of the lexicographically largest suffix of [input].
 * The search begins at [startPos]. This is an O(n) algorithm.
 */
private fun maxSuffixPos(input: String, startPos: Int = 0): Int {
  var bestIndex = startPos
  var candidateIndex = startPos + 1
  val length = input.length
  while (candidateIndex < length) {
    var offset = 0
    while (candidateIndex + offset < length &&
      input[bestIndex + offset] == input[candidateIndex + offset]
    ) {
      offset++
    }
    if (candidateIndex + offset == length) break
    if (input[bestIndex + offset] < input[candidateIndex + offset]) {
      bestIndex = candidateIndex
      candidateIndex = bestIndex + 1
    } else {
      candidateIndex += offset + 1
    }
  }
  return bestIndex
}

fun answerString(word: String, numFriends: Int): String {
  val length = word.length

  // Only one friend means the entire word remains intact
  if (numFriends == 1) return word

  if (numFriends == 2) {
    val bestPrefix = word.substring(0, length - 1)
    val suffixStart = if (length == 2) 1 else maxSuffixPos(word, 1)
    val bestSuffix = word.substring(suffixStart)
    return if (bestPrefix >= bestSuffix) bestPrefix else bestSuffix
  }

  val maxLength = length - (numFriends - 1)
  val suffixStart = maxSuffixPos(word)
  val charsToTake = minOf(maxLength, length - suffixStart)
  return word.substring(suffixStart, suffixStart + charsToTake)
}
