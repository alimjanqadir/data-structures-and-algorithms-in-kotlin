private const val MOD = 1_000_000_007L

fun idealArrays(n: Int, maxValue: Int): Int {
    // 1. factorial table for nCr
    val maxE = 14                 // max exponent for 10 000
    val limit = n + maxE          // covers (e + n - 1)
    val fact = LongArray(limit + 1)
    val invFact = LongArray(limit + 1)
    fact[0] = 1
    for (i in 1..limit) fact[i] = fact[i - 1] * i % MOD
    invFact[limit] = modPow(fact[limit], MOD - 2)
    for (i in limit downTo 1) invFact[i - 1] = invFact[i] * i % MOD

    fun nCr(n_: Int, r_: Int): Long =
        if (r_ !in 0..n_) 0L
        else fact[n_] * invFact[r_] % MOD * invFact[n_ - r_] % MOD

    // 2. sieve for smallest prime factors
    val spf = IntArray(maxValue + 1) { it }
    for (p in 2..maxValue) if (spf[p] == p) {
        if (p.toLong() * p <= maxValue) {
            var m = p * p
            while (m <= maxValue) {
                if (spf[m] == m) spf[m] = p
                m += p
            }
        }
    }

    // 3. iterate over all starting values
    var answer = 0L
    for (v in 1..maxValue) {
        var x = v
        var waysForV = 1L
        while (x > 1) {
            val p = spf[x]
            var exp = 0
            while (x % p == 0) {
                x /= p
                exp++
            }
            waysForV = waysForV * nCr(exp + n - 1, n - 1) % MOD
        }
        answer = (answer + waysForV) % MOD
    }
    return answer.toInt()
}

// fast modular exponentiation
private fun modPow(base: Long, exp: Long): Long {
    var b = base
    var e = exp
    var res = 1L
    while (e > 0) {
        if (e and 1L == 1L) res = res * b % MOD
        b = b * b % MOD
        e = e shr 1
    }
    return res
}
