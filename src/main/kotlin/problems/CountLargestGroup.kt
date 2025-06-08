package problems

// Returns the number of groups with the largest size, where each group contains numbers with the same sum of digits
fun countLargestGroup(n: Int): Int {
  fun sumDigits(value: Int): Int {
    var x = value
    var total = 0
    while (x > 0) {
      total += x % 10
      x /= 10
    }
    return total
  }

  val counts = IntArray(37)
  for (number in 1..n) {
    val bucket = sumDigits(number)
    counts[bucket]++
  }

  val maxSize = counts.maxOrNull() ?: 0
  return counts.count { it == maxSize }
}

