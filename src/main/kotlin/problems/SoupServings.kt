package problems.soupservings

class Solution {
  private lateinit var memo: Array<DoubleArray>

  fun soupServings(n: Int): Double {
    // For large n, the probability approaches 1 within 1e-5
    if (n >= 4800) return 1.0

    val units = (n + 24) / 25  // ceil(n / 25)
    memo = Array(units + 1) { DoubleArray(units + 1) { -1.0 } }
    return probabilityAEmptiesFirst(units, units)
  }

  private fun probabilityAEmptiesFirst(aUnits: Int, bUnits: Int): Double {
    if (aUnits <= 0 && bUnits <= 0) return 0.5
    if (aUnits <= 0) return 1.0
    if (bUnits <= 0) return 0.0

    if (memo[aUnits][bUnits] >= 0.0) return memo[aUnits][bUnits]

    val result =
      0.25 * (
        probabilityAEmptiesFirst(aUnits - 4, bUnits) +
          probabilityAEmptiesFirst(aUnits - 3, bUnits - 1) +
          probabilityAEmptiesFirst(aUnits - 2, bUnits - 2) +
          probabilityAEmptiesFirst(aUnits - 1, bUnits - 3)
        )

    memo[aUnits][bUnits] = result
    return result
  }
}

