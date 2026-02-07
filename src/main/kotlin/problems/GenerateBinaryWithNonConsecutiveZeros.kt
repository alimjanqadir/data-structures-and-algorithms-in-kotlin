package problems

// Solution 1: Functional approach using sequences
fun generateStrings(n: Int): List<String> {
  // For n=1, return both possible digits
  if (n == 1) return listOf("0", "1")

  // Generate sequences using functional approach
  return generateSequence(Pair(listOf("0", "1"), 1)) { (strings, length) ->
    if (length >= n) null
    else Pair(
      strings.flatMap { str ->
        when (str.last()) {
          '0' -> listOf(str + "1")  // After 0, can only add 1
          '1' -> listOf(str + "0", str + "1")  // After 1, can add both
          else -> emptyList()
        }
      },
      length + 1
    )
  }.last().first
}

// Solution 2: Recursive backtracking with StringBuilder for better performance
fun generateStringsBacktrack(n: Int): List<String> {
  val result = mutableListOf<String>()
  val current = StringBuilder()

  fun backtrack(pos: Int, lastChar: Char?) {
    if (pos == n) {
      result.add(current.toString())
      return
    }

    // We can always add '1'
    current.append('1')
    backtrack(pos + 1, '1')
    current.setLength(current.length - 1)

    // We can add '0' only if last char wasn't '0'
    if (lastChar != '0') {
      current.append('0')
      backtrack(pos + 1, '0')
      current.setLength(current.length - 1)
    }
  }

  backtrack(0, null)
  return result
}

// Solution 3: Dynamic Programming approach
fun generateStringsDP(n: Int): List<String> {
  if (n == 1) return listOf("0", "1")

  // dp[i][j] contains all valid strings of length i ending with j
  val dp = Array<Array<MutableList<String>>>(n + 1) { Array(2) { mutableListOf() } }

  // Base cases
  dp[1][0] = mutableListOf("0")
  dp[1][1] = mutableListOf("1")

  // Build up solutions
  for (len in 2..n) {
    // Strings ending in 0 can only come from strings ending in 1
    dp[len][0] = dp[len - 1][1].map { it + "0" }.toMutableList()
    // Strings ending in 1 can come from both
    dp[len][1] = (dp[len - 1][0] + dp[len - 1][1]).map { it + "1" }.toMutableList()
  }

  return dp[n][0] + dp[n][1]
}

