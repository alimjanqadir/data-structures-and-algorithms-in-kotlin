package problems

private const val MOD = 1_000_000_007L

/* ---------- modular helpers ---------- */

private fun modPow(base: Long, exp: Long): Long {
  var b = base % MOD
  var e = exp
  var res = 1L
  while (e > 0) {
    if (e and 1L == 1L) res = (res * b) % MOD
    b = (b * b) % MOD
    e = e shr 1
  }
  return res
}

private fun modInverse(x: Long) = modPow(x, MOD - 2)

/* ---------- nCr pre-computation ---------- */

private lateinit var factorial: LongArray
private lateinit var invFactorial: LongArray

private fun buildFactorials(limit: Int) {
  factorial = LongArray(limit + 1)
  invFactorial = LongArray(limit + 1)
  factorial[0] = 1
  for (i in 1..limit) factorial[i] = factorial[i - 1] * i % MOD
  invFactorial[limit] = modInverse(factorial[limit])
  for (i in limit - 1 downTo 0) {
    invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD
  }
}

private fun nCr(n: Int, r: Int): Long {
  if (r < 0 || r > n) return 0
  return factorial[n] * invFactorial[r] % MOD * invFactorial[n - r] % MOD
}

/* ---------- public API ---------- */

fun countGoodArrays(n: Int, m: Int, k: Int): Int {
  if (k !in 0 until n) return 0
  buildFactorials(n - 1)

  val choose = nCr(n - 1, k)
  val unequalWays = modPow((m - 1).toLong(), (n - 1 - k).toLong())
  val result = m.toLong() * choose % MOD * unequalWays % MOD
  return result.toInt()
}
