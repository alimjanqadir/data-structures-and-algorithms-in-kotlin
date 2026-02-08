package problems.minoperations

class Solution {
  fun minOperations(queries: Array<IntArray>): Long {
    // Precompute powers of 4 up to > 1e9 and the block sums.
    val maxK = 16 // enough since 4^15 > 1e9
    val pow4 = LongArray(maxK + 1)
    pow4[0] = 1L
    for (digitCount in 1..maxK) {
      pow4[digitCount] = pow4[digitCount - 1] * 4L
    }
    // prefixBlockSum[k] = sum_{j=1..k} j * (4^j - 4^{j-1})
    val prefixBlockSum = LongArray(maxK + 1)
    for (digitCount in 1..maxK) {
      val blockSize = pow4[digitCount] - pow4[digitCount - 1]
      prefixBlockSum[digitCount] = prefixBlockSum[digitCount - 1] + digitCount.toLong() * blockSize
    }

    fun digitsBase4(n: Long): Int {
      if (n <= 0L) return 0
      var d = 1
      while (d < maxK && pow4[d] <= n) d += 1
      return d // smallest d with 4^(d-1) <= n < 4^d
    }

    fun prefixSumDigits(n: Long): Long {
      if (n <= 0L) return 0L
      val d = digitsBase4(n) // K(n)
      val startOfBlock = pow4[d - 1]
      // sum complete blocks up to d-1, then partial of block d
      return prefixBlockSum[d - 1] + d.toLong() * (n - startOfBlock + 1L)
    }

    fun rangeSumDigits(left: Long, right: Long): Long {
      return prefixSumDigits(right) - prefixSumDigits(left - 1L)
    }

    var totalOperations = 0L
    for (query in queries) {
      val left = query[0].toLong()
      val right = query[1].toLong()

      val sumNeeds = rangeSumDigits(left, right)                 // S(l, r)
      val maxNeed = digitsBase4(right).toLong()                  // f(r)
      val pairBound = (sumNeeds + 1L) / 2L                       // ceil(S/2)
      val opsForThisQuery = if (pairBound > maxNeed) pairBound else maxNeed
      totalOperations += opsForThisQuery
    }
    return totalOperations
  }
}
