package problems

fun totalWaviness(num1: Int, num2: Int): Int {
  var totalWaviness = 0
  var currentNumber = num1

  while (currentNumber <= num2) {
    totalWaviness += wavinessOfNumber(currentNumber)
    currentNumber += 1
  }

  return totalWaviness
}

private fun wavinessOfNumber(number: Int): Int {
  val digits = number.toString()
  if (digits.length < MINIMUM_WAVY_DIGITS) {
    return 0
  }

  var waviness = 0
  var digitIndex = 1
  while (digitIndex < digits.length - 1) {
    val leftDigit = digits[digitIndex - 1] - '0'
    val currentDigit = digits[digitIndex] - '0'
    val rightDigit = digits[digitIndex + 1] - '0'

    val isPeak = currentDigit > leftDigit && currentDigit > rightDigit
    val isValley = currentDigit < leftDigit && currentDigit < rightDigit

    if (isPeak || isValley) {
      waviness += 1
    }

    digitIndex += 1
  }

  return waviness
}

private const val MINIMUM_WAVY_DIGITS = 3
