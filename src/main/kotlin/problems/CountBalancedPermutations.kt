private const val MOD = 1_000_000_007L
private const val MAX_N = 80

private val fact = LongArray(MAX_N + 1)
private val invFact = LongArray(MAX_N + 1)
private var prepared = false

private fun precomputeFactorials() {
    if (prepared) return
    fact[0] = 1
    for (i in 1..MAX_N) fact[i] = fact[i - 1] * i % MOD
    invFact[MAX_N] = modPow(fact[MAX_N], MOD - 2)
    for (i in MAX_N downTo 1) invFact[i - 1] = invFact[i] * i % MOD
    prepared = true
}

private fun nCr(n: Int, r: Int): Long {
    if (r < 0 || r > n) return 0
    return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD
}

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

fun countBalancedPermutations(num: String): Int {
    val digitFreq = IntArray(10)
    var totalSum = 0
    for (ch in num) {
        val d = ch - '0'
        digitFreq[d]++
        totalSum += d
    }

    if (totalSum % 2 == 1) return 0    // impossible

    val n = num.length
    val evenSlots = (n + 1) / 2        // ceil
    val oddSlots  = n / 2              // floor
    val targetSum = totalSum / 2

    // Pre-compute factorials and modular inverses once
    precomputeFactorials()
    
    // --- DP: how many ways to choose digits for even slots ---
    val dp = Array(evenSlots + 1) {LongArray(targetSum + 1) }
    dp[0][0] = 1L

    for (digitValue in 0..9) {
        val copiesAvailable = digitFreq[digitValue]
        if (copiesAvailable == 0) continue
        val next = Array(evenSlots + 1) { dpRow -> dp[dpRow].clone() } // start with old state
        for (alreadyChosen in 0..evenSlots) {
            for (alreadySum in 0..targetSum) {
                val base = dp[alreadyChosen][alreadySum]
                if (base == 0L) continue
                for (take in 1..minOf(copiesAvailable, evenSlots - alreadyChosen)) {
                    val newCount = alreadyChosen + take
                    val newSum   = alreadySum + take * digitValue
                    if (newSum > targetSum) break
                    val add = base * nCr(copiesAvailable, take) % MOD
                    next[newCount][newSum] =
                        (next[newCount][newSum] + add) % MOD
                }
            }
        }
        for (i in 0..evenSlots) dp[i] = next[i]
    }

    val waysSplit = dp[evenSlots][targetSum]
    if (waysSplit == 0L) return 0

    // Combined factor F
    var result = waysSplit *
                 fact[evenSlots] % MOD *
                 fact[oddSlots]  % MOD

    // divide by ∏ freq[d]!
    for (count in digitFreq) {
        result = result * invFact[count] % MOD
    }
    return result.toInt()
}
