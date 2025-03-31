package problems

/**
 * Problem: Given a string s and a character letter, return the percentage of characters in s that equal letter
 * rounded down to the nearest whole percent.
 * 
 * Example 1:
 * Input: s = "foobar", letter = "o"
 * Output: 33
 * Explanation: The percentage of characters in s that equal the letter 'o' is 2/6 * 100% = 33% when rounded down.
 * 
 * Example 2:
 * Input: s = "jjjj", letter = "k"
 * Output: 0
 * Explanation: The percentage of characters in s that equal the letter 'k' is 0%.
 */
fun percentageLetter(s: String, letter: Char): Int {
    if (s.isEmpty()) return 0
    
    val count = s.count { it == letter }
    return (count * 100 / s.length)
}

fun main() {
    // Example 1
    val s1 = "foobar"
    val letter1 = 'o'
    println("Example 1: ${percentageLetter(s1, letter1)}") // Expected: 33
    
    // Example 2
    val s2 = "jjjj"
    val letter2 = 'k'
    println("Example 2: ${percentageLetter(s2, letter2)}") // Expected: 0
    
    // Additional example
    val s3 = "leetcode"
    val letter3 = 'e'
    println("Example 3: ${percentageLetter(s3, letter3)}") // Expected: 37
}
