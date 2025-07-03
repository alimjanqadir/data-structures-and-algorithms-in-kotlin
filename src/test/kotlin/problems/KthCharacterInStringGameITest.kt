package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class KthCharacterInStringGameITest {
  @Test
  fun testExamples() {
    assertEquals('b', kthCharacter(5))
    assertEquals('c', kthCharacter(10))
  }

  @Test
  fun testAdditionalCases() {
    assertEquals('a', kthCharacter(1))
    assertEquals('b', kthCharacter(2))
    assertEquals('b', kthCharacter(3))
    assertEquals('c', kthCharacter(4))
  }
}
