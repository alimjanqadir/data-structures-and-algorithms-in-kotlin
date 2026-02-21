package problems

fun countPrimeSetBits(left: Int, right: Int): Int {
  val primeMask = 665772
  var validNumberCount = 0

  for (currentNumber in left..right) {
    val setBitCount = Integer.bitCount(currentNumber)

    if (((primeMask shr setBitCount) and 1) == 1) {
      validNumberCount += 1
    }
  }

  return validNumberCount
}
