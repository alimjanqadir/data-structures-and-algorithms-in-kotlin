package problems

fun findKthBit(n: Int, k: Int): Char {
  if (n == 1) {
    return '0'
  }

  val middlePosition = 1 shl (n - 1)
  val totalLength = (1 shl n) - 1

  if (k == middlePosition) {
    return '1'
  }

  if (k < middlePosition) {
    return findKthBit(n - 1, k)
  }

  val mirroredIndex = totalLength - k + 1
  val mirroredResult = findKthBit(n - 1, mirroredIndex)

  return invertBit(mirroredResult)
}

private fun invertBit(bit: Char): Char {
  return if (bit == '0') '1' else '0'
}
