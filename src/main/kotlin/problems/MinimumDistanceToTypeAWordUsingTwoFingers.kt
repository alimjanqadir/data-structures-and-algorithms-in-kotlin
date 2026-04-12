package problems

/**
 * 1320. Minimum Distance to Type a Word Using Two Fingers
 *
 * This is a DP with state compression problem where we track the positions of both fingers efficiently.
 *
 * At each character i, you type word[i]. You have two choices:
 * - Move finger 1 to type it
 * - Move finger 2 to type it
 *
 * State Definition:
 * dp[j] = minimum cost where one finger is at word[i-1] and the other finger is at character j (or unused)
 *
 * Transition:
 * 1. Move the same finger: dp[j] + dist(prev, curr)
 * 2. Move the other finger: dp[prev] = min over j of dp[j] + dist(j, curr)
 *
 * Time Complexity: O(n * 26) where n is the length of word
 * Space Complexity: O(26)
 *
 * @param word The word to type
 * @return The minimum total distance to type the word using two fingers
 */
fun minimumDistanceToTypeAWordUsingTwoFingers(word: String): Int {
    val length = word.length
    if (length <= 1) return 0

    val dp = IntArray(27) { Int.MAX_VALUE }
    dp[26] = 0

    fun getDistance(from: Int, to: Int): Int {
        if (from == 26) return 0
        val fromRow = from / 6
        val fromCol = from % 6
        val toRow = to / 6
        val toCol = to % 6
        return kotlin.math.abs(fromRow - toRow) + kotlin.math.abs(fromCol - toCol)
    }

    for (index in 1 until length) {
        val currentChar = word[index] - 'A'
        val previousChar = word[index - 1] - 'A'

        val nextDp = IntArray(27) { Int.MAX_VALUE }

        for (otherFinger in 0 until 27) {
            if (dp[otherFinger] == Int.MAX_VALUE) continue

            val costMoveSameFinger = dp[otherFinger] + getDistance(previousChar, currentChar)
            nextDp[otherFinger] = minOf(nextDp[otherFinger], costMoveSameFinger)

            val costMoveOtherFinger = dp[otherFinger] + getDistance(otherFinger, currentChar)
            nextDp[previousChar] = minOf(nextDp[previousChar], costMoveOtherFinger)
        }

        for (k in 0 until 27) {
            dp[k] = nextDp[k]
        }
    }

    return dp.minOrNull()!!
}
