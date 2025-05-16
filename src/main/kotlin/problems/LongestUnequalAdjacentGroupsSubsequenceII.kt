package problems

/**
 * LeetCode 2901. Longest Unequal Adjacent Groups Subsequence II
 * Returns the longest subsequence where adjacent words differ by exactly one character and belong to different groups.
 * @param words Array of words
 * @param groups Array of group ids
 * @return List<String> - the longest valid subsequence
 */
fun getWordsInLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
    if (words.isEmpty()) return emptyList()
    
    val n = words.size
    val dp = IntArray(n) { 1 }
    val prev = IntArray(n) { -1 }

    fun isOneHamming(s1: String, s2: String): Boolean =
        s1.length == s2.length && s1.zip(s2).count { it.first != it.second } == 1

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (groups[j] != groups[i] && isOneHamming(words[j], words[i])) {
                if (dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1
                    prev[i] = j
                }
            }
        }
    }


    var maxI = 0
    for (i in 1 until n) {
        if (dp[i] > dp[maxI]) maxI = i
    }


    val indices = mutableListOf<Int>()
    var curr = maxI
    while (curr != -1) {
        indices.add(curr)
        curr = prev[curr]
    }
    indices.reverse()

    return indices.map { words[it] }
}
