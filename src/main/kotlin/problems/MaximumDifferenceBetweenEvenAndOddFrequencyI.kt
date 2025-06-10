package problems

fun maxDifference(s: String): Int {
  val frequencyMap = IntArray(26)
  for (character in s) {
    frequencyMap[character - 'a'] += 1
  }

  var maxOdd = Int.MIN_VALUE
  var minEven = Int.MAX_VALUE

  for (frequency in frequencyMap) {
    if (frequency == 0) continue
    if (frequency % 2 == 1) {
      maxOdd = maxOf(maxOdd, frequency)
    } else {
      minEven = minOf(minEven, frequency)
    }
  }

  return if (maxOdd == Int.MIN_VALUE || minEven == Int.MAX_VALUE) {
    -1
  } else {
    maxOdd - minEven
  }
}
