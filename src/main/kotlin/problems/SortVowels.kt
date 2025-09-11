package problems

fun sortVowels(s: String): String {
  fun isVowel(ch: Char): Boolean {
    return when (ch) {
      'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true
      else -> false
    }
  }

  val vowels = mutableListOf<Char>()
  for (character in s) {
    if (isVowel(character)) vowels.add(character)
  }
  vowels.sort()

  val resultChars = CharArray(s.length)
  var vowelIndex = 0
  for (position in s.indices) {
    val ch = s[position]
    if (isVowel(ch)) {
      resultChars[position] = vowels[vowelIndex]
      vowelIndex += 1
    } else {
      resultChars[position] = ch
    }
  }
  return String(resultChars)
}

