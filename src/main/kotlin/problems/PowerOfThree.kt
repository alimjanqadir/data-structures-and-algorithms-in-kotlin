package problems.powerofthree

class Solution {
  fun isPowerOfThree(n: Int): Boolean {
    // 1162261467 = 3^19, the largest power of 3 in 32-bit signed int
    return n > 0 && 1162261467 % n == 0
  }
}
