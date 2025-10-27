package problems

fun numberOfBeams(bank: Array<String>): Int {
  var totalBeams = 0L
  var previousRowDevices = 0

  for (row in bank) {
    val deviceCount = row.count { it == '1' }
    if (deviceCount > 0) {
      totalBeams += previousRowDevices.toLong() * deviceCount
      previousRowDevices = deviceCount
    }
  }

  return totalBeams.toInt()
}
