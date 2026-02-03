package problems

fun maxRunTime(n: Int, batteries: IntArray): Long {
  var left = 0L
  var right = 0L
  for (b in batteries) right += b.toLong()
  right /= n   // safe upper bound
  right += 1   // just in case

  while (left < right) {
    val mid = (left + right + 1) ushr 1   // upper mid
    var total = 0L
    for (b in batteries) {
      total += minOf(b.toLong(), mid)
      if (total >= mid * n) break      // early exit
    }
    if (total >= mid * n) {
      left = mid
    } else {
      right = mid - 1
    }
  }
  return left
}
