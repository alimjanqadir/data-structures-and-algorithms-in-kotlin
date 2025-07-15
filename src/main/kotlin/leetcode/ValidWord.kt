package leetcode

fun isValid(word: String): Boolean {
  if (word.length < 3) return false

  val vowels = setOf('a', 'e', 'i', 'o', 'u')
  var hasVowel = false
  var hasConsonant = false

  for (symbol in word) {
    when {
      symbol.isDigit() -> {
        // digits are allowed but do not affect vowel/consonant flags
      }
      symbol.isLetter() -> {
        val lowerCaseSymbol = symbol.lowercaseChar()
        if (lowerCaseSymbol in vowels) {
          hasVowel = true
        } else {
          hasConsonant = true
        }
      }
      else -> return false // invalid character detected
    }
  }

  return hasVowel && hasConsonant
}

class Solution {
  fun isValid(word: String): Boolean = leetcode.isValid(word)
}
