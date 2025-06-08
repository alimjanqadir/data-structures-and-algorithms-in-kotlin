package problems

/**
 * Counts the number of symmetric integers in the range [low, high].
 * A symmetric integer has an even number of digits and the sum of the first half equals the sum of the second half.
 */
fun countSymmetricIntegers(low: Int, high: Int): Int {
  var count = 0

  for (number in low..high) {
    val digits = number.toString()
    val length = digits.length

    if (length % 2 != 0) continue

    val half = length / 2
    var sum = 0

    for (index in 0 until half) {
      sum += digits[index] - '0'
      sum -= digits[length - 1 - index] - '0'
    }

    if (sum == 0) count++
  }

  return count
}
