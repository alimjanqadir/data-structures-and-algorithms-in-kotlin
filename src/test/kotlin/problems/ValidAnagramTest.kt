package problems

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidAnagramTest {
    
  @Test
  fun testIsAnagramBruteForce() {
    // Test case 1: Basic anagrams
    assertTrue(isAnagramBruteForce("anagram", "nagaram"))
    assertTrue(isAnagramBruteForce("listen", "silent"))
        
    // Test case 2: Not anagrams
    assertFalse(isAnagramBruteForce("rat", "car"))
    assertFalse(isAnagramBruteForce("hello", "world"))
        
    // Test case 3: Same strings
    assertTrue(isAnagramBruteForce("test", "test"))
        
    // Test case 4: Different lengths
    assertFalse(isAnagramBruteForce("abc", "ab"))
    assertFalse(isAnagramBruteForce("", "a"))
        
    // Test case 5: Empty strings
    assertTrue(isAnagramBruteForce("", ""))
        
    // Test case 6: Single character
    assertTrue(isAnagramBruteForce("a", "a"))
    assertFalse(isAnagramBruteForce("a", "b"))
        
    // Test case 7: Repeated characters
    assertTrue(isAnagramBruteForce("aabbcc", "abcabc"))
    assertFalse(isAnagramBruteForce("aabbcc", "abccde"))
  }
    
  @Test
  fun testIsAnagramFunctional() {
    // Test case 1: Basic anagrams
    assertTrue(isAnagramFunctional("anagram", "nagaram"))
    assertTrue(isAnagramFunctional("listen", "silent"))
        
    // Test case 2: Not anagrams
    assertFalse(isAnagramFunctional("rat", "car"))
    assertFalse(isAnagramFunctional("hello", "world"))
        
    // Test case 3: Same strings
    assertTrue(isAnagramFunctional("test", "test"))
        
    // Test case 4: Different lengths
    assertFalse(isAnagramFunctional("abc", "ab"))
    assertFalse(isAnagramFunctional("", "a"))
        
    // Test case 5: Empty strings
    assertTrue(isAnagramFunctional("", ""))
        
    // Test case 6: Single character
    assertTrue(isAnagramFunctional("a", "a"))
    assertFalse(isAnagramFunctional("a", "b"))
        
    // Test case 7: Repeated characters
    assertTrue(isAnagramFunctional("aabbcc", "abcabc"))
    assertFalse(isAnagramFunctional("aabbcc", "abccde"))
  }
}
