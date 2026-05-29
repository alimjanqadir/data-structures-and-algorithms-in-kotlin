package problems

fun minElement(nums: IntArray): Int {
  var minimumDigitSum = Int.MAX_VALUE

  for (number in nums) {
    var currentNumber = number
    var digitSum = 0

    while (currentNumber > 0) {
      digitSum += currentNumber % 10
      currentNumber /= 10
    }

    if (digitSum < minimumDigitSum) {
      minimumDigitSum = digitSum
    }
  }

  return minimumDigitSum
}

