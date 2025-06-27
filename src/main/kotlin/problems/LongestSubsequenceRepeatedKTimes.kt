package problems

fun longestSubsequenceRepeatedK(inputString: String, requiredRepetitions: Int): String {
  val characterFrequencies = IntArray(26)
  for (character in inputString) {
    characterFrequencies[character - 'a'] += 1
  }

  val possibleCharacters = StringBuilder()
  val characterFrequencyLimits = IntArray(26)
  for (index in 25 downTo 0) {
    if (characterFrequencies[index] >= requiredRepetitions) {
      possibleCharacters.append('a' + index)
      characterFrequencyLimits[index] = characterFrequencies[index] / requiredRepetitions
    }
  }

  return generateBestSubsequence(
    inputString,
    requiredRepetitions,
    possibleCharacters.toString(),
    characterFrequencyLimits,
    StringBuilder(),
    ""
  )
}

private fun generateBestSubsequence(
  sourceString: String,
  repetitionCount: Int,
  possibleCharacters: String,
  characterFrequencyLimits: IntArray,
  currentSubsequenceBuilder: StringBuilder,
  bestSoFar: String
): String {
  var currentBest = bestSoFar

  if (currentSubsequenceBuilder.isNotEmpty() &&
    !isKRepeatedSubsequence(sourceString, repetitionCount, currentSubsequenceBuilder.toString())) {
    return currentBest
  }

  if (currentSubsequenceBuilder.length > currentBest.length) {
    currentBest = currentSubsequenceBuilder.toString()
  }

  for (character in possibleCharacters) {
    val characterIndex = character - 'a'
    if (countOccurrences(currentSubsequenceBuilder, character) < characterFrequencyLimits[characterIndex]) {
      currentSubsequenceBuilder.append(character)
      currentBest = generateBestSubsequence(
        sourceString,
        repetitionCount,
        possibleCharacters,
        characterFrequencyLimits,
        currentSubsequenceBuilder,
        currentBest
      )
      currentSubsequenceBuilder.deleteCharAt(currentSubsequenceBuilder.length - 1)
    }
  }

  return currentBest
}

private fun countOccurrences(stringBuilder: StringBuilder, characterToCount: Char): Int {
  var count = 0
  for (character in stringBuilder) {
    if (character == characterToCount) {
      count += 1
    }
  }
  return count
}

private fun isKRepeatedSubsequence(
  sourceString: String,
  repetitionCount: Int,
  targetSubsequence: String
): Boolean {
  var repetitionsFound = 0
  var targetIndex = 0
  var sourceIndex = 0

  while (sourceIndex < sourceString.length) {
    if (sourceString[sourceIndex] == targetSubsequence[targetIndex]) {
      targetIndex += 1
      if (targetIndex == targetSubsequence.length) {
        repetitionsFound += 1
        if (repetitionsFound == repetitionCount) {
          return true
        }
        targetIndex = 0
      }
    }
    sourceIndex += 1
  }
  return false
}

