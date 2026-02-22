package problems

fun binaryGap(n: Int): Int {
  var number = n
  var currentBitIndex = 0
  var previousOneIndex = -1
  var maximumDistance = 0

  while (number > 0) {

    val currentBit = number and 1

    if (currentBit == 1) {
      if (previousOneIndex != -1) {
        val distance =
          currentBitIndex - previousOneIndex

        maximumDistance =
          maxOf(maximumDistance, distance)
      }

      previousOneIndex = currentBitIndex
    }

    number = number shr 1
    currentBitIndex += 1
  }

  return maximumDistance
}
