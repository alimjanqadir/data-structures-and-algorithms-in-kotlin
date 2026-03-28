package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class FindTheStringTest {

  @Test
  fun testFindTheStringExample1() {
    // Example 1: lcp = [[4,0,2,0],[0,3,0,1],[2,0,2,0],[0,1,0,1]]
    // Expected: "abab"
    val lcp = arrayOf(
      intArrayOf(4, 0, 2, 0),
      intArrayOf(0, 3, 0, 1),
      intArrayOf(2, 0, 2, 0),
      intArrayOf(0, 1, 0, 1)
    )
    assertEquals("abab", findTheString(lcp))
  }

  @Test
  fun testFindTheStringExample2() {
    // Example 2: lcp = [[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,1]]
    // Expected: "aaaa"
    val lcp = arrayOf(
      intArrayOf(4, 3, 2, 1),
      intArrayOf(3, 3, 2, 1),
      intArrayOf(2, 2, 2, 1),
      intArrayOf(1, 1, 1, 1)
    )
    assertEquals("aaaa", findTheString(lcp))
  }

  @Test
  fun testFindTheStringExample3() {
    // Example 3: lcp = [[4,3,2,1],[3,3,2,1],[2,2,2,1],[1,1,1,3]]
    // Expected: "" (impossible)
    val lcp = arrayOf(
      intArrayOf(4, 3, 2, 1),
      intArrayOf(3, 3, 2, 1),
      intArrayOf(2, 2, 2, 1),
      intArrayOf(1, 1, 1, 3)
    )
    assertEquals("", findTheString(lcp))
  }

  @Test
  fun testFindTheStringSingleCharacter() {
    // Single character: lcp = [[1]]
    // Expected: "a"
    val lcp = arrayOf(intArrayOf(1))
    assertEquals("a", findTheString(lcp))
  }

  @Test
  fun testFindTheStringTwoDifferentCharacters() {
    // Two different characters: lcp = [[2,0],[0,1]]
    // Expected: "ab"
    val lcp = arrayOf(
      intArrayOf(2, 0),
      intArrayOf(0, 1)
    )
    assertEquals("ab", findTheString(lcp))
  }

  @Test
  fun testFindTheStringTwoSameCharacters() {
    // Two same characters: lcp = [[2,1],[1,1]]
    // Expected: "aa"
    val lcp = arrayOf(
      intArrayOf(2, 1),
      intArrayOf(1, 1)
    )
    assertEquals("aa", findTheString(lcp))
  }

  @Test
  fun testFindTheStringInvalidDiagonal() {
    // Invalid diagonal: lcp[0][0] should be 3 for n=3, but it's 2
    val lcp = arrayOf(
      intArrayOf(2, 0, 0),
      intArrayOf(0, 2, 0),
      intArrayOf(0, 0, 1)
    )
    assertEquals("", findTheString(lcp))
  }
}
