package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class LastNonEmptyStringTest {

  @Test
  fun testLastNonEmptyStringExample1() {
    // "aabcbbca" -> last occurrences: a:7, b:6, c:5
    // Max last index = 7, chars with last occurrence at or before 7: a,b,c
    // Result should be "abc"
    assertEquals("abc", lastNonEmptyString("aabcbbca"))
  }

  @Test
  fun testLastNonEmptyStringExample2() {
    // "abcd" -> last occurrences: a:0, b:1, c:2, d:3
    // Max last index = 3
    // Result: "abcd"
    assertEquals("abcd", lastNonEmptyString("abcd"))
  }

  @Test
  fun testLastNonEmptyStringSingleChar() {
    assertEquals("a", lastNonEmptyString("a"))
  }

  @Test
  fun testLastNonEmptyStringAllSame() {
    // "aaaa" -> last occurrence of a: 3
    // Result: "a"
    assertEquals("a", lastNonEmptyString("aaaa"))
  }

  @Test
  fun testLastNonEmptyStringAlternating() {
    // "abab" -> last a: 2, last b: 3
    // Max = 3, chars: a, b
    // Result: "ab"
    assertEquals("ab", lastNonEmptyString("abab"))
  }

  @Test
  fun testLastNonEmptyStringComplex() {
    // "zzaazz" -> last z: 5, last a: 4
    // Max = 5, chars with last occurrence <= 5: z (idx 5), a (idx 4)
    // Result: "az"
    assertEquals("az", lastNonEmptyString("zzaazz"))
  }

  @Test
  fun testLastNonEmptyStringMultipleOccurrences() {
    // "abcabc" -> last a:3, b:4, c:5
    // Max = 5, result: "abc"
    assertEquals("abc", lastNonEmptyString("abcabc"))
  }
}
