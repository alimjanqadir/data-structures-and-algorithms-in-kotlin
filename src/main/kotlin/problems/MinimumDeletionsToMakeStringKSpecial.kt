package problems

fun minimumDeletions(word: String, k: Int): Int {

  /* ------------------------------------------------------------
   * 1. Count occurrences of every lowercase letter.
   * ------------------------------------------------------------ */
  val characterFrequencies = IntArray(26)
  for (character in word) {
    characterFrequencies[character - 'a']++
  }

  /* Quick exit: already k-special */
  val nonZeroFrequencies = characterFrequencies.filter { it > 0 }
  val currentMaximum = nonZeroFrequencies.maxOrNull() ?: 0
  val currentMinimum = nonZeroFrequencies.minOrNull() ?: 0
  if (currentMaximum - currentMinimum <= k) return 0

  val highestOriginalFrequency = currentMaximum
  var minimalDeletionCount = word.length          // upper bound: delete everything

  /* ------------------------------------------------------------
   * 2. Enumerate every possible smallest kept frequency L.
   * ------------------------------------------------------------ */
  for (minimumAllowedFrequency in 1..highestOriginalFrequency) {

    var candidateDeletionCount = 0

    for (frequency in characterFrequencies) {
      if (frequency == 0) continue   // skip absent letters

      when {
        frequency < minimumAllowedFrequency ->
          candidateDeletionCount += frequency      // delete all copies

        frequency > minimumAllowedFrequency + k ->
          candidateDeletionCount +=
            frequency - (minimumAllowedFrequency + k) // trim to the upper bound
        /* otherwise: frequency is already within [L, L + k]  → cost 0 */
      }

      // Early break: no need to continue if already worse
      if (candidateDeletionCount >= minimalDeletionCount) break
    }

    minimalDeletionCount = minOf(minimalDeletionCount, candidateDeletionCount)
  }

  return minimalDeletionCount
}
