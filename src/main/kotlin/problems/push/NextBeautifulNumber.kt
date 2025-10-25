package problems.push

fun nextBeautifulNumber(n: Int): Int {
  val candidates = generateAllBalancedUpToLen7()
  var left = 0
  var right = candidates.size - 1
  var answer = candidates.last()
  while (left <= right) {
    val mid = left + (right - left) / 2
    if (candidates[mid] > n) {
      answer = candidates[mid]
      right = mid - 1
    } else {
      left = mid + 1
    }
  }
  return answer
}

private fun generateAllBalancedUpToLen7(): List<Int> {
  val values = ArrayList<Int>()
  for (mask in 1 until (1 shl 7)) {
    var length = 0
    val counts = IntArray(10)
    for (bit in 0 until 7) {
      if ((mask and (1 shl bit)) != 0) {
        val digit = bit + 1
        counts[digit] = digit
        length += digit
      }
    }
    if (length == 0 || length > 7) continue
    backtrackBuildNumbers(counts, length, 0, 0, values)
  }
  values.sort()
  val dedup = ArrayList<Int>(values.size)
  var previous: Int? = null
  for (v in values) {
    if (previous == null || v != previous) dedup.add(v)
    previous = v
  }
  return dedup
}

private fun backtrackBuildNumbers(
  counts: IntArray,
  totalLen: Int,
  placed: Int,
  currentValue: Int,
  out: MutableList<Int>
) {
  if (placed == totalLen) {
    out.add(currentValue)
    return
  }
  for (digit in 1..9) {
    if (counts[digit] == 0) continue
    counts[digit] = counts[digit] - 1
    val nextValue = currentValue * 10 + digit
    backtrackBuildNumbers(counts, totalLen, placed + 1, nextValue, out)
    counts[digit] = counts[digit] + 1
  }
}
