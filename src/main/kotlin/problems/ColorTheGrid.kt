fun colorTheGrid(m: Int, n: Int): Int {
    val MOD = 1000000007
    
    // Step 1: Generate all possible column states
    val pow3 = pow(3, m)
    val validStates = mutableListOf<IntArray>()
    for (state in 0 until pow3) {
        val digits = IntArray(m)
        var temp = state
        var isValid = true
        for (i in 0 until m) {
            digits[i] = temp % 3  // Colors: 0, 1, 2
            if (i > 0 && digits[i] == digits[i - 1]) {
                isValid = false  // Adjacent vertical cells same color
                break
            }
            temp /= 3
        }
        if (isValid) {
            validStates.add(digits)
        }
    }
    val numStates = validStates.size

    // Step 2: Precompute compatible states
    val compatList = Array(numStates) { mutableListOf<Int>() }
    for (a in 0 until numStates) {
        for (b in 0 until numStates) {
            val allDifferent = (0 until m).all { validStates[a][it] != validStates[b][it] }
            if (allDifferent) {
                compatList[b].add(a)  // a can precede b
            }
        }
    }


    // Step 3: DP with rolling arrays
    var prev = LongArray(numStates) { 1L }  // First column: each state has 1 way
    for (k in 1 until n) {
        val curr = LongArray(numStates)
        for (s in 0 until numStates) {
            var ways = 0L
            for (sPrev in compatList[s]) {
                ways = (ways + prev[sPrev]) % MOD
            }
            curr[s] = ways
        }
        prev = curr
    }

    // Step 4: Sum all ways for the last column
    var answer = 0L
    for (s in 0 until numStates) {
        answer = (answer + prev[s]) % MOD
    }
    return answer.toInt()
}

private fun pow(base: Int, exp: Int): Int {
    var result = 1
    repeat(exp) { result *= base }
    return result
}
