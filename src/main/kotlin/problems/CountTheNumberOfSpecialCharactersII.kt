package problems

/**
 * LeetCode 3121. Count the Number of Special Characters II
 * https://leetcode.com/problems/count-the-number-of-special-characters-ii/
 */
fun numberOfSpecialChars(word: String): Int {
  val lastLowercase = IntArray(26) { -1 }
  val firstUppercase = IntArray(26) { -1 }

  for (index in word.indices) {
    val currentCharacter = word[index]

    if (currentCharacter in 'a'..'z') {
      val characterIndex = currentCharacter - 'a'
      lastLowercase[characterIndex] = index
    } else {
      val characterIndex = currentCharacter - 'A'

      if (firstUppercase[characterIndex] == -1) {
        firstUppercase[characterIndex] = index
      }
    }
  }

  var specialCharacterCount = 0

  for (characterIndex in 0 until 26) {
    val lowercasePosition = lastLowercase[characterIndex]
    val uppercasePosition = firstUppercase[characterIndex]

    if (
      lowercasePosition != -1 &&
      uppercasePosition != -1 &&
      lowercasePosition < uppercasePosition
    ) {
      specialCharacterCount += 1
    }
  }

  return specialCharacterCount
}
