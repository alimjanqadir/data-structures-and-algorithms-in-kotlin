package problems.push

fun smallestNumber(n: Int): Int {
  val bitLength = 32 - Integer.numberOfLeadingZeros(n)
  return (1 shl bitLength) - 1
}
