package problems

fun makeFancyString(original: String): String {
  val fancyBuilder = StringBuilder()

  for (currentCharacter in original) {
    val lengthSoFar = fancyBuilder.length
    val shouldDeleteCurrent =
      lengthSoFar >= 2 &&
        currentCharacter == fancyBuilder[lengthSoFar - 1] &&
        currentCharacter == fancyBuilder[lengthSoFar - 2]

    if (!shouldDeleteCurrent) {
      fancyBuilder.append(currentCharacter)
    }
  }

  return fancyBuilder.toString()
}


