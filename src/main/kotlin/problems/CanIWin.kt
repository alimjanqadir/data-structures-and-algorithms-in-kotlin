package problems

fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {
    // If target already reached
    if (desiredTotal <= 0) return true

    // If total sum is not enough
    val maxSum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2
    if (maxSum < desiredTotal) return false

    val memo = HashMap<Int, Boolean>()

    fun canCurrentPlayerWin(usedMask: Int, remaining: Int): Boolean {
        if (memo.containsKey(usedMask)) {
            return memo[usedMask]!!
        }

        for (num in 1..maxChoosableInteger) {
            val bit = 1 shl (num - 1)

            // if number already used, skip
            if ((usedMask and bit) != 0) continue

            // choose this number
            if (num >= remaining) {
                memo[usedMask] = true
                return true
            }

            val nextMask = usedMask or bit

            // if opponent loses, we win
            val opponentWins = canCurrentPlayerWin(nextMask, remaining - num)

            if (!opponentWins) {
                memo[usedMask] = true
                return true
            }
        }

        memo[usedMask] = false
        return false
    }

    return canCurrentPlayerWin(0, desiredTotal)
}
