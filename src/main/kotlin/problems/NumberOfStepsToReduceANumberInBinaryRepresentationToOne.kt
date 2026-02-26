package problems

fun numSteps(binaryNumber: String): Int {
  var stepsCount = 0
  var carryValue = 0

  for (index in binaryNumber.length - 1 downTo 1) {
    val currentBit =
      (binaryNumber[index] - '0') + carryValue

    if (currentBit == 1) {
      stepsCount += 2
      carryValue = 1
    } else {
      stepsCount += 1
    }
  }

  return stepsCount + carryValue
}
