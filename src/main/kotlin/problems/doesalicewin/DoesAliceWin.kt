package problems

fun doesAliceWin(s: String): Boolean {
    fun isVowel(character: Char): Boolean {
      return character == 'a' || character == 'e' || character == 'i' ||
        character == 'o' || character == 'u'
    }
    for (character in s) {
      if (isVowel(character)) return true
    }
    return false
}
