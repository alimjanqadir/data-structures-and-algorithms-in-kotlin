package problems.fractiontorecurringdecimal

class Solution {
  fun fractionToDecimal(numerator: Int, denominator: Int): String {
    if (numerator == 0) return "0"

    // Work in 64-bit to avoid overflow on abs(Int.MIN_VALUE)
    val numeratorLong = numerator.toLong()
    val denominatorLong = denominator.toLong()

    val negativeResult = (numeratorLong < 0) xor (denominatorLong < 0)
    val absoluteNumerator = kotlin.math.abs(numeratorLong)
    val absoluteDenominator = kotlin.math.abs(denominatorLong)

    val integerQuotient = absoluteNumerator / absoluteDenominator
    var remainder = absoluteNumerator % absoluteDenominator

    val decimalBuilder = StringBuilder()
    if (negativeResult) decimalBuilder.append('-')
    decimalBuilder.append(integerQuotient)

    // No fractional part
    if (remainder == 0L) return decimalBuilder.toString()

    decimalBuilder.append('.')

    // Map: remainder -> index in decimalBuilder where the quotient digit for this remainder was placed
    val remainderToIndexMap = HashMap<Long, Int>()

    while (remainder != 0L) {
      // A repeat starts where we first saw this remainder
      val previousIndex = remainderToIndexMap[remainder]
      if (previousIndex != null) {
        decimalBuilder.insert(previousIndex, '(')
        decimalBuilder.append(')')
        return decimalBuilder.toString()
      }

      // Remember where the digit generated from this remainder will start
      remainderToIndexMap[remainder] = decimalBuilder.length

      // Long division step
      remainder *= 10
      val nextDigit = remainder / absoluteDenominator
      decimalBuilder.append(nextDigit)
      remainder %= absoluteDenominator
    }

    // Terminating decimal
    return decimalBuilder.toString()
  }
}
