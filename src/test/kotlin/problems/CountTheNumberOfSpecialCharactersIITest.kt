package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountTheNumberOfSpecialCharactersIITest {
  @Test
  fun example1() {
    assertEquals(3, numberOfSpecialChars("aaAbcBC"))
  }

  @Test
  fun example2() {
    assertEquals(0, numberOfSpecialChars("abc"))
  }

  @Test
  fun uppercaseBeforeLowercaseShouldNotCount() {
    assertEquals(0, numberOfSpecialChars("Aa"))
  }

  @Test
  fun mixedValidAndInvalid() {
    assertEquals(1, numberOfSpecialChars("AbBCab"))
  }
}
