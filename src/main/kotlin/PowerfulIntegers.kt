// No math imports needed

// Helper function for integer exponentiation (base^exp)
// Returns Long.MAX_VALUE if overflow occurs.
private fun integerPower(base: Long, exp: Int): Long {
  if (exp < 0) return 0L 
  if (exp == 0) return 1L
  var result = 1L
  var currentBase = base
  var exponent = exp 

  if (base == 0L) return 0L 
  if (base == 1L) return 1L 

  try {
    while (exponent > 0) {
      if (exponent % 2 == 1) {
        result = Math.multiplyExact(result, currentBase) 
      }
      exponent /= 2
      if (exponent > 0) {
        currentBase = Math.multiplyExact(currentBase, currentBase) 
      }
    }
  } catch (e: ArithmeticException) {
    return Long.MAX_VALUE // Indicate overflow
  }
  return result
}

/**
 * Calculates a count related to powerful integers up to N (represented by nStr), 
 * using the specific logic provided by the user.
 *
 * @param nStr The string representation of the upper limit number N.
 * @param s The required suffix string.
 * @param limit The maximum allowed digit value.
 * @return A count calculated based on the provided logic.
 */
private fun getCount(nStr: String, s: String, limit: Int): Long {
  val nLen = nStr.length
  val sLen = s.length

  if (nLen < sLen) return 0L
  if (nLen == sLen) return try { if (nStr.toLong() >= s.toLong()) 1L else 0L } catch (e: NumberFormatException) { 0L }

  val prefixLen = nLen - sLen 
  var count = 0L
  var isPrefixOfNValid = true 

  for (i in 0 until prefixLen) {
    val digit = nStr[i].digitToIntOrNull()
    if (digit == null) return 0L 

    val remainingPrefixDigits = prefixLen - 1 - i
    val waysToFillRemaining = integerPower((limit + 1).toLong(), remainingPrefixDigits)

    if (waysToFillRemaining == Long.MAX_VALUE) {
      count = Long.MAX_VALUE 
      isPrefixOfNValid = false
      break 
    }

    if (digit > limit) {
      isPrefixOfNValid = false 
      val waysToFillAllRemaining = integerPower((limit + 1).toLong(), prefixLen - i)
            
      if (waysToFillAllRemaining == Long.MAX_VALUE || count > Long.MAX_VALUE - waysToFillAllRemaining) {
        count = Long.MAX_VALUE
      } else {
        count += waysToFillAllRemaining
      }
      break
    } else {
      // --- Correction starts here ---
      // Use the original logic: multiply by 'digit' itself
      val termBase = digit.toLong() 
      if (termBase > 0) { // Only add if digit > 0
        val term = try {
          Math.multiplyExact(termBase, waysToFillRemaining)
        } catch (e: ArithmeticException) {
          Long.MAX_VALUE // Overflow
        }
                 
        if (term == Long.MAX_VALUE || count > Long.MAX_VALUE - term) {
          count = Long.MAX_VALUE
          isPrefixOfNValid = false 
          break 
        } else {
          count += term
        }
      }
      // --- Correction ends here ---
    }
  }

  if (isPrefixOfNValid && count != Long.MAX_VALUE) {
    val suffixOfN = nStr.substring(nLen - sLen)
    try {
      if (suffixOfN.toLong() >= s.toLong()) {
        if (count < Long.MAX_VALUE) {
          count += 1
        }
      }
    } catch (e: NumberFormatException) { /* Ignore */ }
  }

  return if (count < 0) Long.MAX_VALUE else count
}

/**
 * Counts the number of powerful integers within the range [start, finish].
 * A powerful integer ends with suffix 's' and has all digits <= 'limit'.
 * Uses the range subtraction principle with the user-provided getCount logic.
 */
fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
  // Calculate count up to 'finish' using the getCount helper
  val countFinish = getCount(finish.toString(), s, limit)

  // Calculate count up to 'start - 1' using the getCount helper
  val countStartMinus1 = if (start == 1L) 0L else getCount((start - 1).toString(), s, limit)

  // Handle potential overflow results from getCount
  if (countFinish == Long.MAX_VALUE) {
    // Return MAX_VALUE if upper bound calculation overflowed
    return Long.MAX_VALUE 
  }
  if (countStartMinus1 == Long.MAX_VALUE) {
    // This case (lower bound overflows but upper doesn't) is unlikely
    return 0L // Or handle as error
  }

  // Calculate the difference. Result cannot be negative.
  val result = countFinish - countStartMinus1
  return if (result < 0) 0L else result
} 