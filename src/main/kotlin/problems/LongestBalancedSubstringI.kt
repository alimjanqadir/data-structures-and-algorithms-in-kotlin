package problems

fun longestBalancedSubstringI(text: String): Int {
  val textLength = text.length
  var longestLength = 0

  for (windowStart in 0 until textLength) {

    val characterFrequency = IntArray(26)
    val frequencyTypeCount = IntArray(textLength + 1)

    var distinctCharacters = 0
    var nonZeroFrequencyTypes = 0

    for (windowEnd in windowStart until textLength) {

      val characterIndex = text[windowEnd] - 'a'
      val previousFrequency = characterFrequency[characterIndex]

      if (previousFrequency > 0) {
        frequencyTypeCount[previousFrequency]--
        if (frequencyTypeCount[previousFrequency] == 0) {
          nonZeroFrequencyTypes--
        }
      }

      characterFrequency[characterIndex]++
      val currentFrequency = characterFrequency[characterIndex]

      if (frequencyTypeCount[currentFrequency] == 0) {
        nonZeroFrequencyTypes++
      }
      frequencyTypeCount[currentFrequency]++

      if (previousFrequency == 0) {
        distinctCharacters++
      }

      if (nonZeroFrequencyTypes == 1) {
        val windowLength = windowEnd - windowStart + 1
        if (windowLength > longestLength) {
          longestLength = windowLength
        }
      }
    }
  }

  return longestLength
}
