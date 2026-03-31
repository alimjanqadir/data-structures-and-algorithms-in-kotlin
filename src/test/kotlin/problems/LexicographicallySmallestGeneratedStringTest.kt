package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LexicographicallySmallestGeneratedStringTest {

    @Test
    fun testExample1() {
        // LeetCode Example 1: str1="TFTF", str2="ab" → "ababa"
        assertEquals("ababa", generateString("TFTF", "ab"))
    }

    @Test
    fun testExample2() {
        // LeetCode Example 2: str1="TFTF", str2="abc" → ""
        assertEquals("", generateString("TFTF", "abc"))
    }

    @Test
    fun testExample3() {
        // LeetCode Example 3: str1="F", str2="d" → "a"
        assertEquals("a", generateString("F", "d"))
    }

    @Test
    fun testAllTrue() {
        // All positions are 'T', result is exactly str2
        assertEquals("abc", generateString("T", "abc"))
    }

    @Test
    fun testAllFalse() {
        // All positions are 'F', n=2, m=2, resultLength=3
        // Start: "aaa", F at 0 matches "aa", change pos 1 to 'b' → "aba"
        // F at 1: substring "ba" != "aa", no change needed
        assertEquals("aba", generateString("FF", "aa"))
    }

    @Test
    fun testSingleT() {
        // Single 'T' with longer str2
        assertEquals("abc", generateString("T", "abc"))
    }

    @Test
    fun testSingleF() {
        // Single 'F', n=1, m=2, resultLength=2
        // Start: "aa", F at 0 matches "aa", change pos 1 to 'b' → "ab"
        assertEquals("ab", generateString("F", "aa"))
    }

    @Test
    fun testTTOverlapping() {
        // Two T's that overlap, n=2, m=2, resultLength=3
        // T at 0: "aa_", T at 1: "_aa" → both apply, result "aaa"
        assertEquals("aaa", generateString("TT", "aa"))
    }

    @Test
    fun testTFConflict() {
        // T at 0 forces "aa" at positions 0,1 (locked)
        // F at 1: substring positions 1-2 is "aa" initially, matches str2
        // Need to change rightmost unfixed in range [1,2]: position 2 is unfixed
        // Change position 2 to 'b' → "aab"
        assertEquals("aab", generateString("TF", "aa"))
    }

    @Test
    fun testMultipleF() {
        // Multiple F's, n=3, m=2, resultLength=4
        // T at 0: "ab__" (positions 0,1 locked)
        // F at 1: substring "ba" != "ab", no change needed
        // F at 2: substring "aa" != "ab", no change needed  
        // Result: "abaa"
        assertEquals("abaa", generateString("TFF", "ab"))
    }
}
