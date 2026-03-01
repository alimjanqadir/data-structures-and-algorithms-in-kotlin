fun minPartitions(numberString: String): Int {
  var largestDigit = 0

  for (digitCharacter in numberString) {
    val digitValue = digitCharacter - '0'
    largestDigit = maxOf(largestDigit, digitValue)
  }

  return largestDigit
}
