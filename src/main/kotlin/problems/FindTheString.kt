package problems

fun findTheString(lcp: Array<IntArray>): String {
  val n = lcp.size

  // Step 1: Validate diagonal
  for (i in 0 until n) {
    if (lcp[i][i] != n - i) return ""
  }

  val result = CharArray(n) { '?' }
  var currentChar = 'a'

  // Step 2: Assign characters
  for (i in 0 until n) {
    if (result[i] != '?') continue

    if (currentChar > 'z') return ""

    for (j in i until n) {
      if (lcp[i][j] > 0) {
        result[j] = currentChar
      }
    }
    currentChar++
  }

  val word = String(result)

  // Step 3: Validate LCP
  val computed = Array(n) { IntArray(n) }

  for (i in n - 1 downTo 0) {
    for (j in n - 1 downTo 0) {
      if (word[i] == word[j]) {
        if (i + 1 < n && j + 1 < n) {
          computed[i][j] = 1 + computed[i + 1][j + 1]
        } else {
          computed[i][j] = 1
        }
      } else {
        computed[i][j] = 0
      }
    }
  }

  // Compare matrices
  for (i in 0 until n) {
    for (j in 0 until n) {
      if (computed[i][j] != lcp[i][j]) {
        return ""
      }
    }
  }

  return word
}
