package problems
import kotlin.math.pow

/**
 * 2081. Sum of k-Mirror Numbers
 *
 * Returns the sum of the n smallest numbers that are palindromic in base 10
 * and in the given base.
 */
fun kMirror(base: Int, countNeeded: Int): Long {
  var sum = 0L
  var found = 0
  var palindromeLength = 1

  while (found < countNeeded) {
    val halfLength = (palindromeLength + 1) / 2
    val startLeftHalf = 10.0.pow(halfLength - 1).toInt()
    val endLeftHalf = 10.0.pow(halfLength).toInt() - 1

    for (leftHalf in startLeftHalf..endLeftHalf) {
      val candidate = buildPalindrome(leftHalf, palindromeLength % 2 == 1)
      if (isPalindromeInBase(candidate, base)) {
        sum += candidate
        found += 1
        if (found == countNeeded) return sum
      }
    }
    palindromeLength += 1
  }
  return sum
}

/** Builds a full palindrome from its left half. */
private fun buildPalindrome(leftHalf: Int, skipMiddle: Boolean): Long {
  var result = leftHalf.toLong()
  var temp = if (skipMiddle) leftHalf / 10 else leftHalf
  while (temp > 0) {
    result = result * 10 + (temp % 10)
    temp /= 10
  }
  return result
}

/** Checks if x is a palindrome when written in the given base. */
private fun isPalindromeInBase(x: Long, base: Int): Boolean {
  val digits = StringBuilder()
  var num = x
  while (num > 0) {
    digits.append((num % base).toInt())
    num /= base
  }
  val str = digits.toString()
  return str == str.reversed()
}
