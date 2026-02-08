package problems.sumzero

class Solution {
  fun sumZero(n: Int): IntArray {
    val result = IntArray(n)
    var indexPosition = 0
    val pairCount = n / 2
    var currentValue = 1
    while (currentValue <= pairCount) {
      result[indexPosition] = currentValue
      indexPosition += 1
      result[indexPosition] = -currentValue
      indexPosition += 1
      currentValue += 1
    }
    if (n % 2 == 1) {
      result[indexPosition] = 0
    }
    return result
  }
}

