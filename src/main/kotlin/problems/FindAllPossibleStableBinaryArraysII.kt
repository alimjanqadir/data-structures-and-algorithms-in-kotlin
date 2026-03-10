package problems

/**
 * 3130. Find All Possible Stable Binary Arrays II
 *
 * You are given 3 positive integers zero, one, and limit.
 * A binary array arr is called stable if:
 * - The number of occurrences of 0 in arr is exactly zero.
 * - The number of occurrences of 1 in arr is exactly one.
 * - Each subarray of arr with a size greater than limit must contain both 0 and 1.
 *
 * Return the total number of stable binary arrays. Since the answer may be very large,
 * return it modulo 10^9 + 7.
 */

// Helper function to compute modular inverse using Fermat's Little Theorem
private fun modInverse(a: Long, mod: Int): Long {
    return fastPow(a, mod - 2, mod)
}

private fun fastPow(base: Long, exp: Int, mod: Int): Long {
    var result = 1L
    var b = base % mod
    var e = exp
    
    while (e > 0) {
        if (e % 2 == 1) {
            result = (result * b) % mod
        }
        b = (b * b) % mod
        e /= 2
    }
    
    return result
}
fun numberOfStableArraysII(zero: Int, one: Int, limit: Int): Int {
    
    val MOD = 1_000_000_007

    // Special case: when limit = 0, there are no restrictions
    // All permutations of zeros and ones are valid
    if (limit == 0) {
        val total = zero + one
        var result = 1L
        // Calculate combinations: (total)! / (zero! * one!)
        for (i in 1..total) {
            result = (result * i) % MOD
        }
        for (i in 1..zero) {
            result = (result * modInverse(i.toLong(), MOD)) % MOD
        }
        for (i in 1..one) {
            result = (result * modInverse(i.toLong(), MOD)) % MOD
        }
        return result.toInt()
    }

    val endWithZero = Array(zero + 1) { LongArray(one + 1) }
    val endWithOne = Array(zero + 1) { LongArray(one + 1) }

    val prefixZero = Array(zero + 1) { LongArray(one + 1) }
    val prefixOne = Array(zero + 1) { LongArray(one + 1) }

    for (z in 1..minOf(zero, limit)) {
        endWithZero[z][0] = 1
    }

    for (o in 1..minOf(one, limit)) {
        endWithOne[0][o] = 1
    }

    for (z in 0..zero) {
        for (o in 0..one) {

            if (z > 0) {
                val left = z - 1
                val right = maxOf(0, z - limit)

                val sum = prefixOne[left][o] -
                        if (right > 0) prefixOne[right - 1][o] else 0

                endWithZero[z][o] =
                    (endWithZero[z][o] + sum + MOD) % MOD
            }

            if (o > 0) {
                val left = o - 1
                val right = maxOf(0, o - limit)

                val sum = prefixZero[z][left] -
                        if (right > 0) prefixZero[z][right - 1] else 0

                endWithOne[z][o] =
                    (endWithOne[z][o] + sum + MOD) % MOD
            }

            prefixZero[z][o] =
                ((if (o > 0) prefixZero[z][o - 1] else 0) + endWithZero[z][o]) % MOD

            prefixOne[z][o] =
                ((if (z > 0) prefixOne[z - 1][o] else 0) + endWithOne[z][o]) % MOD
        }
    }

    return ((endWithZero[zero][one] + endWithOne[zero][one]) % MOD).toInt()
}
