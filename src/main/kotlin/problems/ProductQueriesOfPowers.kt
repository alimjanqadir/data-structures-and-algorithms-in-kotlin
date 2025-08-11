package problems

fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
  val modulus = 1_000_000_007

  // 1) Collect exponents for set bits of n, in ascending order
  val bitExponents = ArrayList<Int>(32)
  var remaining = n
  var bitIndex = 0
  while (remaining != 0) {
    if ((remaining and 1) == 1) bitExponents.add(bitIndex)
    bitIndex += 1
    remaining = remaining ushr 1
  }

  // 2) Prefix sums of exponents for O(1) range-sum
  val prefixExponentSum = IntArray(bitExponents.size + 1)
  for (position in bitExponents.indices) {
    prefixExponentSum[position + 1] = prefixExponentSum[position] + bitExponents[position]
  }

  // 3) Precompute pow2[k] = 2^k mod M up to the maximum needed exponent sum
  val maxExponentSum = prefixExponentSum[prefixExponentSum.lastIndex]
  val pow2 = IntArray(maxExponentSum + 1)
  pow2[0] = 1
  for (exp in 1..maxExponentSum) {
    pow2[exp] = ((pow2[exp - 1].toLong() * 2L) % modulus).toInt()
  }

  // 4) Answer queries in O(1)
  val results = IntArray(queries.size)
  for (queryIndex in queries.indices) {
    val left = queries[queryIndex][0]
    val right = queries[queryIndex][1]
    val sumOfExponents = prefixExponentSum[right + 1] - prefixExponentSum[left]
    results[queryIndex] = pow2[sumOfExponents]
  }
  return results
}

