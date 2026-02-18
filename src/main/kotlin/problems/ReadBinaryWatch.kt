fun readBinaryWatch(turnedOn: Int): List<String> {
  val possibleTimes = mutableListOf<String>()

  for (hour in 0..11) {
    val hourBitCount = Integer.bitCount(hour)

    for (minute in 0..59) {
      val minuteBitCount = Integer.bitCount(minute)

      if (hourBitCount + minuteBitCount == turnedOn) {
        val formattedMinute = if (minute < 10) "0$minute" else minute.toString()
        possibleTimes.add("$hour:$formattedMinute")
      }
    }
  }

  return possibleTimes
}
