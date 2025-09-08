package problems.nozerointegers

class Solution {
  fun getNoZeroIntegers(n: Int): IntArray {
    fun hasZeroDigit(value: Int): Boolean {
      var number = value
      while (number > 0) {
        val lastDigit = number % 10
        if (lastDigit == 0) return true
        number /= 10
      }
      return false
    }

    var candidateA = 1
    while (candidateA < n) {
      val candidateB = n - candidateA
      if (!hasZeroDigit(candidateA) && !hasZeroDigit(candidateB)) {
        return intArrayOf(candidateA, candidateB)
      }
      candidateA += 1
    }
    // Problem guarantees a solution exists; this is just a fallback.
    return intArrayOf(1, n - 1)
  }
}

