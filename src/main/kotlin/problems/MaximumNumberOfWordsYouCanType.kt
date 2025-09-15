package problems

/**
 * Returns the number of words in [text] that can be typed without using any of the characters
 * from [brokenLetters]. Words are separated by spaces.
 */
fun canBeTypedWords(text: String, brokenLetters: String): Int {
  val brokenSet = brokenLetters.toSet()
  var typableWordCount = 0
  var currentWordHasBroken = false

  for (character in text) {
    if (character == ' ') {
      if (!currentWordHasBroken) {
        typableWordCount += 1
      }
      currentWordHasBroken = false
    } else {
      if (!currentWordHasBroken && character in brokenSet) {
        currentWordHasBroken = true
      }
    }
  }

  // Account for the final word (no trailing space)
  if (!currentWordHasBroken) {
    typableWordCount += 1
  }

  return typableWordCount
}

