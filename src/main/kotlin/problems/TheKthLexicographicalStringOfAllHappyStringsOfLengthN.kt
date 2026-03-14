package problems

/**
 * LeetCode 1415. The k-th Lexicographical String of All Happy Strings of Length n
 *
 * A happy string is a string that:
 * - consists only of letters of the set ['a', 'b', 'c']
 * - s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed)
 *
 * Given two integers n and k, consider a list of all happy strings of length n sorted
 * in lexicographical order. Return the kth string of this list or return an empty string
 * if there are less than k happy strings of length n.
 */
fun getHappyString(length: Int, targetIndex: Int): String {
    val totalStrings = 3 * (1 shl (length - 1))
    if (targetIndex > totalStrings) {
        return ""
    }

    var remainingIndex = targetIndex
    val resultBuilder = StringBuilder()
    var previousCharacter: Char? = null

    for (position in 0 until length) {
        for (candidateCharacter in charArrayOf('a', 'b', 'c')) {
            if (candidateCharacter == previousCharacter) {
                continue
            }

            val remainingPositions = length - position - 1
            val blockSize = 1 shl remainingPositions

            if (remainingIndex > blockSize) {
                remainingIndex -= blockSize
            } else {
                resultBuilder.append(candidateCharacter)
                previousCharacter = candidateCharacter
                break
            }
        }
    }

    return resultBuilder.toString()
}
