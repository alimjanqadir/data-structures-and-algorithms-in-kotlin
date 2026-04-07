package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimizeStringLengthTest {

  @Test
  fun testMinimizedStringLengthExample1() {
    assertEquals(3, minimizedStringLength("aaabc"))
  }

  @Test
  fun testMinimizedStringLengthExample2() {
    assertEquals(3, minimizedStringLength("cbbd"))
  }

  @Test
  fun testMinimizedStringLengthExample3() {
    assertEquals(1, minimizedStringLength("dddaaa"))
  }

  @Test
  fun testMinimizedStringLengthSingleChar() {
    assertEquals(1, minimizedStringLength("a"))
  }

  @Test
  fun testMinimizedStringLengthAllDistinct() {
    assertEquals(5, minimizedStringLength("abcde"))
  }

  @Test
  fun testMinimizedStringLengthAllSame() {
    assertEquals(1, minimizedStringLength("aaaaa"))
  }

  @Test
  fun testMinimizedStringLengthAll26Letters() {
    assertEquals(26, minimizedStringLength("abcdefghijklmnopqrstuvwxyz"))
  }
}
