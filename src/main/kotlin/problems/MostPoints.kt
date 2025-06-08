package problems

/**
 * Solves the problem of finding the maximum points that can be earned from solving questions.
 * Each question has points and brainpower, and solving a question skips the next brainpower questions.
 *
 * @param questions Array of questions where each question is represented as [points, brainpower]
 * @return Maximum points that can be earned
 */
fun mostPoints(questions: Array<IntArray>): Long {
  val n = questions.size
  val dp = LongArray(n + 1) // dp[n] = 0 by default

  for (i in n - 1 downTo 0) {
    val (points, brainpower) = questions[i]
    val nextIndex = i + brainpower + 1

    val take = points + if (nextIndex < n) dp[nextIndex] else 0
    val skip = dp[i + 1]

    dp[i] = maxOf(take, skip)
  }

  return dp[0]
}
