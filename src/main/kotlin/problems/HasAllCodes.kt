package problems

fun hasAllCodes(s: String, k: Int): Boolean {
  val totalPatterns = 1 shl k
  val seenPatterns = BooleanArray(totalPatterns)

  var remainingPatterns = totalPatterns
  var currentWindowValue = 0
  val mask = totalPatterns - 1

  for (index in s.indices) {
    val currentBit = s[index] - '0'
    currentWindowValue = ((currentWindowValue shl 1) and mask) or currentBit

    if (index >= k - 1) {
      if (!seenPatterns[currentWindowValue]) {
        seenPatterns[currentWindowValue] = true
        remainingPatterns -= 1

        if (remainingPatterns == 0) {
          return true
        }
      }
    }
  }

  return false
}
