package problems

fun reorderedPowerOf2(n: Int): Boolean {
  val targetKey = digitCountKey(n)

  // Precompute all power-of-two signatures up to 1e9
  val seen = HashSet<Long>()
  var value = 1
  while (value <= 1_000_000_000) {
    seen.add(digitCountKey(value))
    value = value shl 1
  }

  return targetKey in seen
}

// Packs counts of digits 0..9 into a single Long using base-11.
// Example: counts = [c0,c1,...,c9] -> (((c0)*11 + c1)*11 + ...)*11 + c9
private fun digitCountKey(x: Int): Long {
  var number = x
  val counts = IntArray(10)
  if (number == 0) {
    counts[0] = 1
  } else {
    while (number > 0) {
      val digit = number % 10
      counts[digit] = counts[digit] + 1
      number /= 10
    }
  }
  var key = 0L
  for (digit in 0..9) {
    key = key * 11 + counts[digit]
  }
  return key
}
