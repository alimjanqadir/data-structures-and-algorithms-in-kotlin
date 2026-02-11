package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class AnswerStringTest {
    
  @Test
  fun testAnswerString() {
    // Test case 1: Only 1 friend, should return the entire string
    assertEquals(
      "abcde",
      answerString("abcde", 1),
      "With 1 friend, should return the entire string"
    )

    // Test case 2: 2 friends, simple case
    assertEquals(
      "b",
      answerString("ab", 2),
      "With 2 friends and 2-char string, should return the last character"
    )

    // Test case 3: 2 friends, longer string
    assertEquals(
      "zz",
      answerString("abzz", 2),
      "Should return the lexicographically largest suffix of length at least 1"
    )

    // Test case 4: 3 friends, longer string
    assertEquals(
      "zz",
      answerString("abzz", 3),
      "With 3 friends, should return the lexicographically largest substring of length n-2"
    )

    // Test case 5: All characters the same
    assertEquals(
      "aaa",
      answerString("aaaaa", 3),
      "With all characters the same, should return first n-2 characters"
    )

    // Test case 6: Edge case with minimum length string
    assertEquals(
      "a",
      answerString("a", 1),
      "Single character with 1 friend should return the character itself"
    )

    // Test case 7: Multiple friends, string with increasing order
    assertEquals(
      "e",
      answerString("abcde", 3),
      "With increasing order string and 3 friends, should return last character"
    )

    // Test case 8: Multiple friends, string with decreasing order
    // The function seems to return the entire remaining string for decreasing order
    assertEquals(
      "edc",
      answerString("edcba", 3),
      "With decreasing order string and 3 friends, should return first n-1 characters"
    )
  }

  @Test
  fun testMaxSuffixPos() {
    // Test helper function maxSuffixPos
    // For "abc", the largest suffix is "c" starting at index 2
    assertEquals(2, maxSuffixPos("abc"))
        
    // For "abca", the largest suffix is "ca" starting at index 2
    assertEquals(2, maxSuffixPos("abca"))
        
    // For "abzz", the largest suffix is "zz" starting at index 2
    assertEquals(2, maxSuffixPos("abzz"))
        
    // For "zzzz", all characters are the same, should return start position
    assertEquals(0, maxSuffixPos("zzzz"))
        
    // For "abcde", the largest suffix is "e" starting at index 4
    assertEquals(4, maxSuffixPos("abcde"))
        
    // For "edcba", the largest suffix is the string itself (decreasing order)
    assertEquals(0, maxSuffixPos("edcba"))
        
    // Test with start position
    // For "abcabc" starting at 1, the implementation finds the first occurrence of 'c' at position 2
    assertEquals(2, maxSuffixPos("abcabc", 1))
  }
}
