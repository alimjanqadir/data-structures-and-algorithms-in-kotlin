private const val MOD = 1_000_000_007L
private const val ALPHABET = 26

fun lengthAfterTransformations(source: String, rounds: Int): Int {
    if (rounds == 0) return source.length  // nothing to do

    // 1. Build the initial 1×26 row vector of letter counts.
    val initialCounts = LongArray(ALPHABET)
    for (ch in source) initialCounts[ch - 'a']++

    // 2. Build the 26×26 transformation matrix M.
    val transform = Array(ALPHABET) { LongArray(ALPHABET) }
    for (letter in 0 until ALPHABET - 1)     // 'a'..'y'
        transform[letter][letter + 1] = 1L   // shift right
    transform[25][0] = 1L                    // 'z' → 'a'
    transform[25][1] = 1L                    // 'z' → 'b'


    // 3. Compute M^rounds.
    val powered = matrixPower(transform, rounds.toLong())

    // 4. Multiply initialCounts by M^rounds to get the final counts.
    val finalCounts = LongArray(ALPHABET)
    for (col in 0 until ALPHABET)
        for (k in 0 until ALPHABET)
            finalCounts[col] = (finalCounts[col] + initialCounts[k] * powered[k][col]) % MOD

    // 5. Sum the 26 entries for the answer.
    var total = 0L
    for (count in finalCounts) total = (total + count) % MOD
    return total.toInt()
}

private fun matrixMultiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    val product = Array(ALPHABET) { LongArray(ALPHABET) }
    for (row in 0 until ALPHABET)
        for (mid in 0 until ALPHABET)
            if (a[row][mid] != 0L)
                for (col in 0 until ALPHABET)
                    product[row][col] =
                        (product[row][col] + a[row][mid] * b[mid][col]) % MOD
    return product
}

private fun matrixPower(base: Array<LongArray>, exponent: Long): Array<LongArray> {
    // initialise result as the 26×26 identity matrix
    var result = Array(ALPHABET) { row ->
        LongArray(ALPHABET) { col -> if (row == col) 1L else 0L }
    }
    var power = base
    var exp = exponent
    while (exp > 0) {
        if (exp and 1L == 1L) result = matrixMultiply(result, power)
        power = matrixMultiply(power, power)
        exp = exp shr 1
    }
    return result
}
