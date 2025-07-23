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

