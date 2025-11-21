package problems

/**
 * Problem: [1930. Unique Length-3 Palindromic Subsequences](https://leetcode.com/problems/unique-length-3-palindromic-subsequences/)
 * 
 * This function counts the number of unique palindromic subsequences of length 3 in a given string.
 * A palindromic subsequence is a sequence of characters that reads the same forwards and backwards.
 * 
 * @param s The input string containing only lowercase English letters.
 * @return The number of unique palindromic subsequences of length 3.
 */
fun countPalindromicSubsequence(s: String): Int {
    val n = s.length
    
    // left[i]  = index of first occurrence of character i+'a'
    // right[i] = index of last  occurrence of character i+'a'
    val left  = IntArray(26) { n }
    val right = IntArray(26) { -1 }
    
    for (i in 0 until n) {
        val idx = s[i] - 'a'
        if (left[idx] == n) left[idx] = i      // first time
        right[idx] = i                         // will be the last one at the end
    }
    
    var answer = 0
    
    for (ch in 0..25) {
        if (right[ch] == -1) continue          // character does not appear
        
        // we have at least two occurrences (otherwise right == left)
        if (left[ch] == right[ch]) continue     // only one occurrence → impossible
        
        // count distinct characters strictly between left[ch] and right[ch]
        val seen = BooleanArray(26)
        var distinct = 0
        for (i in left[ch] + 1 until right[ch]) {
            val mid = s[i] - 'a'
            if (!seen[mid]) {
                seen[mid] = true
                distinct++
            }
        }
        answer += distinct
    }
    
    return answer
}
