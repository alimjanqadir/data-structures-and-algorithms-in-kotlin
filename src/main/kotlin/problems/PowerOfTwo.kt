package problems

fun isPowerOfTwo(n: Int): Boolean {
  // A power of two has exactly one bit set: n > 0 and n & (n-1) == 0
  return n > 0 && (n and (n - 1)) == 0
}
