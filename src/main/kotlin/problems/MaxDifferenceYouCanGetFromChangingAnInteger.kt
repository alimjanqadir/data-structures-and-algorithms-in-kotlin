package problems

/**
 * Returns the maximum possible difference A - B obtained
 * by two single-digit remappings on the decimal representation of [number].
 */
fun maxDiff(number: Int): Int {
  val original = number.toString().toCharArray()

  // ---------- Build the maximal value ----------
  val digitsForMax = original.clone()
  val digitToNines = digitsForMax.firstOrNull { it != '9' }
  if (digitToNines != null) {
    for (index in digitsForMax.indices) {
      if (digitsForMax[index] == digitToNines) digitsForMax[index] = '9'
    }
  }
  val maxValue = String(digitsForMax).toInt()

  // ---------- Build the minimal value ----------
  val digitsForMin = original.clone()
  if (digitsForMin[0] != '1') {
    val digitToOnes = digitsForMin[0]
    for (index in digitsForMin.indices) {
      if (digitsForMin[index] == digitToOnes) digitsForMin[index] = '1'
    }
  } else {
    val digitToZeros = digitsForMin.drop(1).firstOrNull { it != '0' && it != '1' }
    if (digitToZeros != null) {
      for (index in digitsForMin.indices) {
        if (digitsForMin[index] == digitToZeros) digitsForMin[index] = '0'
      }
    }
  }
  val minValue = String(digitsForMin).toInt()

  return maxValue - minValue
}
