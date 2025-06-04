package problems

// --- O(n) helper: index of the lexicographically largest suffix ---
private fun maxSuffixPos(s: String, from: Int = 0): Int {
    var i = from           // best so far
    var j = from + 1       // challenger
    val n = s.length
    while (j < n) {
        var k = 0
        while (j + k < n && s[i + k] == s[j + k]) k++
        if (j + k == n) break               // challenger ran out of chars
        if (s[i + k] < s[j + k]) {          // challenger is better
            i = j
            j = i + 1
        } else {                            // current best stays
            j += k + 1
        }
    }
    return i
}

fun answerString(word: String, numFriends: Int): String {
    val n = word.length

    // --- Case 1: only one friend ---
    if (numFriends == 1) return word        // the whole string is the only piece

    // --- Case 2: exactly two friends -> must sit on an edge ---
    if (numFriends == 2) {
        val bestPrefix = word.substring(0, n - 1)            // longest legal prefix
        val start      = if (n == 2) 1 else maxSuffixPos(word, 1) // best proper suffix
        val bestSuffix = word.substring(start)
        return if (bestPrefix >= bestSuffix) bestPrefix else bestSuffix
    }

    // --- Case 3: three or more friends ---
    val maxLen = n - (numFriends - 1)                         // allowed length
    val start  = maxSuffixPos(word)                           // best suffix overall
    val take   = minOf(maxLen, n - start)                     // trim to the rule
    return word.substring(start, start + take)
}
