package problems

private fun maxSuffixPos(s: String, from: Int = 0): Int {
    var i = from
    var j = from + 1
    val n = s.length
    while (j < n) {
        var k = 0
        while (j + k < n && s[i + k] == s[j + k]) k++
        if (j + k == n) break
        if (s[i + k] < s[j + k]) {
            i = j
            j = i + 1
        } else {
            j += k + 1
        }
    }
    return i
}

fun answerString(word: String, numFriends: Int): String {
    val n = word.length
    if (numFriends == 1) return word
    if (numFriends == 2) {
        val bestPrefix = word.substring(0, n - 1)
        val start = if (n == 2) 1 else maxSuffixPos(word, 1)
        val bestSuffix = word.substring(start)
        return if (bestPrefix >= bestSuffix) bestPrefix else bestSuffix
    }
    val maxLen = n - (numFriends - 1)
    val start = maxSuffixPos(word)
    val take = minOf(maxLen, n - start)
    return word.substring(start, start + take)
}
