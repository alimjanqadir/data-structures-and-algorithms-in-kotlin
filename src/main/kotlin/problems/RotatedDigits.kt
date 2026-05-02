package problems

fun rotatedDigits(n: Int): Int {
  var goodCount = 0

  for (number in 1..n) {
    if (isGoodNumber(number)) {
      goodCount += 1
    }
  }

  return goodCount
}

private fun isGoodNumber(number: Int): Boolean {
  var current = number
  var hasDifferentDigit = false

  while (current > 0) {
    val digit = current % 10

    when (digit) {
      0, 1, 8 -> {
        // remains the same
      }

      2, 5, 6, 9 -> {
        hasDifferentDigit = true
      }

      else -> {
        return false
      }
    }

    current /= 10
  }

  return hasDifferentDigit
}
