package problems

fun maxFreqSum(s: String): Int {
  val letterCounts = IntArray(26)
  for (symbol in s) {
    val position = symbol - 'a'
    letterCounts[position] = letterCounts[position] + 1
  }

  fun isVowel(letter: Char): Boolean {
    return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'
  }

  var maxVowelFrequency = 0
  var maxConsonantFrequency = 0

  for (alphabetIndex in 0 until 26) {
    val frequency = letterCounts[alphabetIndex]
    if (frequency == 0) continue
    val letter = ('a'.code + alphabetIndex).toChar()

    if (isVowel(letter)) {
      if (frequency > maxVowelFrequency) {
        maxVowelFrequency = frequency
      }
    } else {
      if (frequency > maxConsonantFrequency) {
        maxConsonantFrequency = frequency
      }
    }
  }
  return maxVowelFrequency + maxConsonantFrequency
}
