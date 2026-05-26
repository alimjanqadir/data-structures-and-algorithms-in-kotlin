package problems

fun numberOfSpecialChars(word: String): Int {
  val lowercaseLetters = mutableSetOf<Char>()
  val uppercaseLetters = mutableSetOf<Char>()

  for (character in word) {
    if (character.isLowerCase()) {
      lowercaseLetters.add(character)
    } else {
      uppercaseLetters.add(character)
    }
  }

  var specialCharacterCount = 0

  for (character in 'a'..'z') {
    val uppercaseCharacter = character.uppercaseChar()

    if (character in lowercaseLetters && uppercaseCharacter in uppercaseLetters) {
      specialCharacterCount++
    }
  }

  return specialCharacterCount
}
