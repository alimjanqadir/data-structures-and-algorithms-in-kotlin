package problems

fun maxJumps(arr: IntArray, d: Int): Int {
  val n = arr.size
  val memo = IntArray(n)

  fun dfs(currentIndex: Int): Int {
    if (memo[currentIndex] != 0) {
      return memo[currentIndex]
    }

    var best = 1
    val currentValue = arr[currentIndex]

    var nextIndex = currentIndex - 1
    while (nextIndex >= 0 && currentIndex - nextIndex <= d) {
      if (arr[nextIndex] >= currentValue) {
        break
      }
      best = maxOf(best, 1 + dfs(nextIndex))
      nextIndex--
    }

    nextIndex = currentIndex + 1
    while (nextIndex < n && nextIndex - currentIndex <= d) {
      if (arr[nextIndex] >= currentValue) {
        break
      }
      best = maxOf(best, 1 + dfs(nextIndex))
      nextIndex++
    }

    memo[currentIndex] = best
    return best
  }

  var answer = 0
  for (currentIndex in 0 until n) {
    answer = maxOf(answer, dfs(currentIndex))
  }

  return answer
}
