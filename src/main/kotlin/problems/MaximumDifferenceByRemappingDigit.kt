package problems

/**
 * Returns the difference between the maximum and minimum values that can be
 * obtained by remapping exactly one digit in [num].
 *
 * A digit can be remapped to itself and all occurrences of the chosen digit
 * will be replaced. Leading zeroes in the resulting number are allowed.
 */
fun minMaxDifference(num: Int): Int {
  val digits = num.toString()

  // Build the maximum value by replacing the first non-'9' digit with '9'
  val firstNotNine = digits.firstOrNull { it != '9' }
  val maxValue = if (firstNotNine == null) {
    num
  } else {
    digits.replace(firstNotNine, '9').toInt()
  }

  // Build the minimum value by replacing the first non-'0' digit with '0'
  val firstNotZero = digits.firstOrNull { it != '0' }
  val minValue = if (firstNotZero == null) {
    num
  } else {
    digits.replace(firstNotZero, '0').toInt()
  }

  return maxValue - minValue
}
