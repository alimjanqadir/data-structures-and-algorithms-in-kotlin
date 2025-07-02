package problems

private const val MOD = 1_000_000_007L

fun possibleStringCount(word: String, k: Int): Int {
  val runLengths = mutableListOf<Int>()
  var currentRun = 1
  for (index in 1 until word.length) {
    if (word[index] == word[index - 1]) {
      currentRun += 1
    } else {
      runLengths.add(currentRun)
      currentRun = 1
    }
  }
  runLengths.add(currentRun)

  val runCount = runLengths.size
  if (k > word.length) return 0

  var totalCombinations = 1L
  for (length in runLengths) {
    totalCombinations = (totalCombinations * length) % MOD
  }

  val extraTarget = k - runCount
  if (extraTarget <= 0) return totalCombinations.toInt()

  val dp = LongArray(extraTarget)
  dp[0] = 1L

  for (length in runLengths) {
    val maxExtraInThisRun = length - 1
    var windowSum = 0L
    val next = LongArray(extraTarget)

    for (extraSum in 0 until extraTarget) {
      windowSum = (windowSum + dp[extraSum]) % MOD
      val slidingOutIndex = extraSum - maxExtraInThisRun - 1
      if (slidingOutIndex >= 0) {
        windowSum = (windowSum - dp[slidingOutIndex] + MOD) % MOD
      }
      next[extraSum] = windowSum
    }
    System.arraycopy(next, 0, dp, 0, extraTarget)
  }

  var shortCombinations = 0L
  for (count in dp) shortCombinations = (shortCombinations + count) % MOD

  val answer = (totalCombinations - shortCombinations + MOD) % MOD
  return answer.toInt()
}
