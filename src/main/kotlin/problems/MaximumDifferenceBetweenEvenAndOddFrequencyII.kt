package problems

fun maxDifference(text: String, windowLength: Int): Int {
  val textLength = text.length
  if (windowLength > textLength) return -1

  // 1. Compress the alphabet actually present
  val uniqueLetters = text.toSet().toList()
  val alphabetCardinality = uniqueLetters.size
  val letterToIndex = IntArray(128) { -1 }
  uniqueLetters.forEachIndexed { letterIndex, letter ->
    letterToIndex[letter.code] = letterIndex
  }

  // 2. Build prefix counts: prefixCount[ch][p] = #ch in text[0 until p]
  val prefixCount = Array(alphabetCardinality) { IntArray(textLength + 1) }
  for (position in 1..textLength) {
    val currentLetterIndex = letterToIndex[text[position - 1].code]
    for (letterIndex in 0 until alphabetCardinality) {
      prefixCount[letterIndex][position] = prefixCount[letterIndex][position - 1]
    }
    prefixCount[currentLetterIndex][position]++
  }

  // 3. Sweep every ordered pair (oddCandidate, evenCandidate)
  val sentinel = 1_000_000_000
  var globalMaximumDifference = -sentinel

  for (oddLetterIndex in 0 until alphabetCardinality) {
    for (evenLetterIndex in 0 until alphabetCardinality) {
      if (oddLetterIndex == evenLetterIndex) continue

      val totalEvenOccurrences = prefixCount[evenLetterIndex][textLength]
      if (totalEvenOccurrences < 2) continue

      val runningMinimum = Array(2) { IntArray(2) { sentinel } }
      val bestPrefixDifference = Array(2) { IntArray(totalEvenOccurrences + 1) { sentinel } }
      val highestEvenCountProcessed = IntArray(2) { -1 }
      var bestDifferenceForCurrentPair = -sentinel

      for (endPrefix in 0..textLength) {
        // add the start prefix that just became valid (length ≥ windowLength)
        if (endPrefix >= windowLength) {
          val startPrefix = endPrefix - windowLength
          val prefixDifference =
            prefixCount[oddLetterIndex][startPrefix] -
              prefixCount[evenLetterIndex][startPrefix]

          val parityOdd = prefixCount[oddLetterIndex][startPrefix] and 1
          val evenCount = prefixCount[evenLetterIndex][startPrefix]

          if (prefixDifference < bestPrefixDifference[parityOdd][evenCount]) {
            bestPrefixDifference[parityOdd][evenCount] = prefixDifference
            val parityEven = evenCount and 1
            if (evenCount <= highestEvenCountProcessed[parityEven] &&
              prefixDifference < runningMinimum[parityOdd][parityEven]
            ) {
              runningMinimum[parityOdd][parityEven] = prefixDifference
            }
          }
        }

        val evenCountSoFar = prefixCount[evenLetterIndex][endPrefix]
        val parityEvenSoFar = evenCountSoFar and 1
        val highestPropagatableEvenCount = evenCountSoFar - 2

        if (highestPropagatableEvenCount >= 0) {
          var cursor = highestEvenCountProcessed[parityEvenSoFar] + 1
          if ((cursor and 1) != parityEvenSoFar) cursor++
          while (cursor <= highestPropagatableEvenCount) {
            for (parityOdd in 0..1) {
              if (bestPrefixDifference[parityOdd][cursor] <
                runningMinimum[parityOdd][parityEvenSoFar]
              ) {
                runningMinimum[parityOdd][parityEvenSoFar] =
                  bestPrefixDifference[parityOdd][cursor]
              }
            }
            cursor += 2
          }
          highestEvenCountProcessed[parityEvenSoFar] = highestPropagatableEvenCount
        }

        if (evenCountSoFar >= 2) {
          val parityOddSoFar = prefixCount[oddLetterIndex][endPrefix] and 1
          val requiredParityOdd = 1 - parityOddSoFar
          val candidatePrefixDifference =
            runningMinimum[requiredParityOdd][parityEvenSoFar]

          if (candidatePrefixDifference != sentinel) {
            val currentDifference =
              prefixCount[oddLetterIndex][endPrefix] -
                prefixCount[evenLetterIndex][endPrefix]

            bestDifferenceForCurrentPair = maxOf(
              bestDifferenceForCurrentPair,
              currentDifference - candidatePrefixDifference
            )
          }
        }
      }
      globalMaximumDifference =
        maxOf(globalMaximumDifference, bestDifferenceForCurrentPair)
    }
  }
  return if (globalMaximumDifference == -sentinel) -1 else globalMaximumDifference
}
