package problems

private const val NO_DIGIT = 10
private const val UNVISITED = -1L

fun totalWaviness(num1: Long, num2: Long): Long = totalWavinessUpTo(num2) - totalWavinessUpTo(num1 - 1)

private fun totalWavinessUpTo(bound: Long): Long {
  if (bound < 0L) return 0L

  val digits = bound.toString().map { digit -> digit - '0' }
  val memoWays = Array(digits.size + 1) {
    Array(2) {
      Array(11) { LongArray(11) { UNVISITED } }
    }
  }
  val memoWaviness = Array(digits.size + 1) {
    Array(2) {
      Array(11) { LongArray(11) { UNVISITED } }
    }
  }

  fun dfs(
    position: Int,
    isTight: Boolean,
    hasStarted: Boolean,
    lastOne: Int,
    lastTwo: Int,
  ): Pair<Long, Long> {
    if (position == digits.size) return 1L to 0L

    val startedIndex = if (hasStarted) 1 else 0
    if (!isTight && memoWays[position][startedIndex][lastOne][lastTwo] != UNVISITED) {
      return memoWays[position][startedIndex][lastOne][lastTwo] to
        memoWaviness[position][startedIndex][lastOne][lastTwo]
    }

    val limit = if (isTight) digits[position] else 9
    var totalWays = 0L
    var totalWaviness = 0L

    for (digit in 0..limit) {
      val nextTight = isTight && digit == limit
      var nextHasStarted = hasStarted
      var nextLastOne = lastOne
      var nextLastTwo = lastTwo
      var extra = 0L

      if (!hasStarted) {
        if (digit == 0) {
          nextHasStarted = false
          nextLastOne = NO_DIGIT
          nextLastTwo = NO_DIGIT
        } else {
          nextHasStarted = true
          nextLastOne = digit
          nextLastTwo = NO_DIGIT
        }
      } else {
        nextHasStarted = true
        nextLastTwo = lastOne
        nextLastOne = digit

        if (lastTwo != NO_DIGIT && isPeakOrValley(lastTwo, lastOne, digit)) {
          extra = 1L
        }
      }

      val (childWays, childWaviness) = dfs(
        position = position + 1,
        isTight = nextTight,
        hasStarted = nextHasStarted,
        lastOne = nextLastOne,
        lastTwo = nextLastTwo,
      )
      totalWays += childWays
      totalWaviness += childWaviness + extra * childWays
    }

    if (!isTight) {
      memoWays[position][startedIndex][lastOne][lastTwo] = totalWays
      memoWaviness[position][startedIndex][lastOne][lastTwo] = totalWaviness
    }

    return totalWays to totalWaviness
  }

  return dfs(
    position = 0,
    isTight = true,
    hasStarted = false,
    lastOne = NO_DIGIT,
    lastTwo = NO_DIGIT,
  ).second
}

private fun isPeakOrValley(left: Int, middle: Int, right: Int): Boolean =
  (middle > left && middle > right) || (middle < left && middle < right)
