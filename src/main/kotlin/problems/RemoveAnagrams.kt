package problems

fun removeAnagrams(words: Array<String>): List<String> {
  val remainingWords = mutableListOf<String>()
  var previousSignature: String? = null

  for (currentWord in words) {
    val currentSignature = signatureKey(currentWord)
    if (currentSignature != previousSignature) {
      remainingWords.add(currentWord)
      previousSignature = currentSignature
    }
  }
  return remainingWords
}

private fun signatureKey(text: String): String {
  val letterCounts = IntArray(26)
  for (character in text) {
    val index = character - 'a'
    letterCounts[index] = letterCounts[index] + 1
  }
  val builder = StringBuilder(26 * 2)
  for (count in letterCounts) {
    builder.append(count).append('#')
  }
  return builder.toString()
}
