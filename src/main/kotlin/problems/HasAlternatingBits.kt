fun hasAlternatingBits(n: Int): Boolean {
  val xorValue = n xor (n shr 1)
  return (xorValue and (xorValue + 1)) == 0
}
