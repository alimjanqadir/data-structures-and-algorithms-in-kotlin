package problems.replacenoncoprimes

class Solution {
  fun replaceNonCoprimes(nums: IntArray): List<Int> {
    val stack = ArrayList<Long>()  // holds a coprime-adjacent sequence

    for (raw in nums) {
      var merged: Long = raw.toLong()

      while (stack.isNotEmpty()) {
        val top: Long = stack.last()
        val g: Long = gcd(top, merged)
        if (g == 1L) break

        // Merge and continue checking with the previous element
        merged = lcm(top, merged, g)
        stack.removeAt(stack.size - 1)
      }

      stack.add(merged)
    }

    // Convert back to Int as guaranteed by the problem statement
    val result = ArrayList<Int>(stack.size)
    for (value in stack) {
      result.add(value.toInt())
    }
    return result
  }

  // Euclidean algorithm
  private fun gcd(a: Long, b: Long): Long {
    var x = if (a >= 0) a else -a
    var y = if (b >= 0) b else -b
    while (y != 0L) {
      val r = x % y
      x = y
      y = r
    }
    return x
  }

  // lcm using a precomputed gcd to avoid recomputation and overflow risk
  private fun lcm(a: Long, b: Long, gcdAB: Long = gcd(a, b)): Long {
    // (a / gcd) * b fits in Long for given constraints
    return (a / gcdAB) * b
  }
}
