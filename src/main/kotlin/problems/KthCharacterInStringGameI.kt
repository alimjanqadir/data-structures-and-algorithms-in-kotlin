package problems

/**
 * Returns the k-th character in the infinite string game sequence.
 * The sequence starts with "a" and each operation appends the next
 * characters for every character in the current string.
 */
fun kthCharacter(k: Int): Char {
  require(k >= 1) { "k must be positive" }
  val shifts = popcount(k - 1) % 26
  return ('a'.code + shifts).toChar()
}

/** Branch-free 32-bit pop-count (Hacker's Delight, §5-2) */
private fun popcount(v: Int): Int {
  var x = v
  x = x - (x ushr 1 and 0x5555_5555.toInt())
  x = (x and 0x3333_3333) + (x ushr 2 and 0x3333_3333)
  x = (x + (x ushr 4)) and 0x0F0F_0F0F
  x += x ushr 8
  x += x ushr 16
  return x and 0x3F
}
