package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestPalindromeByConcatenatingTwoLetterWordsTest {
    @Test
    fun testLongestPalindrome() {
        // Test case 1: Example from problem
        assertEquals(6, longestPalindrome(arrayOf("lc", "cl", "gg")))
        
        // Test case 2: Another example
        assertEquals(8, longestPalindrome(arrayOf("ab", "ty", "yt", "lc", "cl", "ab")))
        
        // Test case 3: All identical pairs
        assertEquals(2, longestPalindrome(arrayOf("aa")))
        
        // Test case 4: No pairs
        assertEquals(0, longestPalindrome(arrayOf("ab")))
        
        // Test case 5: Multiple identical pairs with center
        assertEquals(10, longestPalindrome(arrayOf("aa", "aa", "bb", "cc", "dd", "ee", "ee")))
    }
}
