package problems

fun findLexSmallestString(s: String, a: Int, b: Int): String {
  val n = s.length
  val stepCount = n / gcd(n, b)
  var best = s

  var offset = 0
  repeat(stepCount) {
    val rotated = rotateRight(s, offset)
    for (oddTimes in 0..9) {
      val oddInc = (oddTimes * a) % 10
      if (b % 2 == 0) {
        val candidate = applyIncrements(rotated, evenInc = 0, oddInc = oddInc)
        if (candidate < best) best = candidate
      } else {
        for (evenTimes in 0..9) {
          val evenInc = (evenTimes * a) % 10
          val candidate = applyIncrements(rotated, evenInc, oddInc)
          if (candidate < best) best = candidate
        }
      }
    }
    offset = (offset + b) % n
  }

  return best
}

private fun applyIncrements(str: String, evenInc: Int, oddInc: Int): String {
  val n = str.length
  val chars = CharArray(n)
  for (index in 0 until n) {
    val digit = str[index] - '0'
    val inc = if (index % 2 == 0) evenInc else oddInc
    val newDigit = (digit + inc) % 10
    chars[index] = ('0'.code + newDigit).toChar()
  }
  return String(chars)
}

private fun rotateRight(str: String, k: Int): String {
  if (k == 0) return str
  val n = str.length
  val r = k % n
  return str.substring(n - r) + str.substring(0, n - r)
}

private fun gcd(x: Int, y: Int): Int {
  var aVar = x
  var bVar = y
  while (bVar != 0) {
    val t = aVar % bVar
    aVar = bVar
    bVar = t
  }
  return aVar
}
