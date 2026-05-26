package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountTheNumberOfSpecialCharactersITest {
  @Test
  fun testNumberOfSpecialChars() {
    assertEquals(3, numberOfSpecialChars("aaAbcBC"))
    assertEquals(0, numberOfSpecialChars("abc"))
    assertEquals(1, numberOfSpecialChars("abBC"))
    assertEquals(26, numberOfSpecialChars("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"))
  }
}
