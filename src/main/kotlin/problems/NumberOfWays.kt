package problems.numberofways

class Solution {
  private val modulo = 1_000_000_007

  fun numberOfWays(n: Int, x: Int): Int {
    val powerValues = mutableListOf<Int>()
    var base = 1
    while (true) {
      val value = powLimited(base, x, n)
      if (value > n) break
      powerValues.add(value)
      base += 1
    }

    val ways = IntArray(n + 1)
    ways[0] = 1

    for (power in powerValues) {
      for (sum in n downTo power) {
        val withPower = ways[sum - power]
        if (withPower != 0) {
          val updated = ways[sum] + withPower
          ways[sum] = if (updated >= modulo) updated - modulo else updated
        }
      }
    }
    return ways[n]
  }

  // Computes base^exp, but stops early if it exceeds 'limit'
  private fun powLimited(base: Int, exp: Int, limit: Int): Int {
    var result = 1L
    repeat(exp) {
      result *= base.toLong()
      if (result > limit) return limit + 1
    }
    return result.toInt()
  }
}
