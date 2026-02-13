package problems

fun longestBalancedSubstringII(s: String): Int {
  val n = s.length

  var maxSingleCharRun = 1
  var currentSingleCharRun = 1

  for (index in 1 until n) {
    if (s[index] == s[index - 1]) {
      currentSingleCharRun += 1
      maxSingleCharRun = maxOf(maxSingleCharRun, currentSingleCharRun)
    } else {
      currentSingleCharRun = 1
    }
  }

  fun processSegment(
    left: Int,
    right: Int,
    positiveChar: Char,
    negativeChar: Char,
    s: String
  ): Int {
    if (left > right) return 0

    var bestLength = 0
    var balance = 0
    val firstSeenBalanceIndex = mutableMapOf<Int, Int>()

    firstSeenBalanceIndex[0] = left - 1

    for (index in left..right) {
      if (s[index] == positiveChar) {
        balance += 1
      } else if (s[index] == negativeChar) {
        balance -= 1
      }

      val previousIndex = firstSeenBalanceIndex[balance]
      if (previousIndex != null) {
        bestLength = maxOf(bestLength, index - previousIndex)
      } else {
        firstSeenBalanceIndex[balance] = index
      }
    }

    return bestLength
  }

  fun computeTwoCharacters(
    firstChar: Char,
    secondChar: Char,
    forbiddenChar: Char
  ): Int {
    var bestLength = 0
    var segmentStart = 0

    for (index in 0 until n) {
      if (s[index] == forbiddenChar) {
        if (segmentStart < index) {
          bestLength = maxOf(
            bestLength,
            processSegment(segmentStart, index - 1, firstChar, secondChar, s)
          )
        }
        segmentStart = index + 1
      }
    }

    if (segmentStart < n) {
      bestLength = maxOf(
        bestLength,
        processSegment(segmentStart, n - 1, firstChar, secondChar, s)
      )
    }

    return bestLength
  }

  val maxAB = computeTwoCharacters('a', 'b', 'c')
  val maxAC = computeTwoCharacters('a', 'c', 'b')
  val maxBC = computeTwoCharacters('b', 'c', 'a')
  val maxTwoCharacters = maxOf(maxAB, maxAC, maxBC)

  var maxThreeCharacters = 0
  var balanceAB = 0
  var balanceAC = 0

  val firstSeenBalancePairIndex = mutableMapOf<Pair<Int, Int>, Int>()
  firstSeenBalancePairIndex[Pair(0, 0)] = -1

  for (index in 0 until n) {
    when (s[index]) {
      'a' -> {
        balanceAB += 1
        balanceAC += 1
      }
      'b' -> balanceAB -= 1
      'c' -> balanceAC -= 1
    }

    val balanceState = Pair(balanceAB, balanceAC)
    val previousIndex = firstSeenBalancePairIndex[balanceState]

    if (previousIndex != null) {
      maxThreeCharacters = maxOf(maxThreeCharacters, index - previousIndex)
    } else {
      firstSeenBalancePairIndex[balanceState] = index
    }
  }

  return maxOf(maxSingleCharRun, maxTwoCharacters, maxThreeCharacters)
}
