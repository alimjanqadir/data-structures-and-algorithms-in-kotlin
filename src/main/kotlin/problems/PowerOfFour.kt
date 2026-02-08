package problems.poweroffour

class Solution {
  fun isPowerOfFour(n: Int): Boolean {
    if (n <= 0) return false
    val isSingleBit = (n and (n - 1)) == 0 // power of two
    val isEvenBitPosition = (n and 0x55555555.toInt()) != 0
    return isSingleBit && isEvenBitPosition
  }
}
