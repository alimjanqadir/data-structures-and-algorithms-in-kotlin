package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ClearStarsTest {
  @Test
  fun `basic examples`() {
    assertEquals("d", clearStars("abc*d**"))
    assertEquals("", clearStars("a*b*c*"))
    assertEquals("def", clearStars("abc*de*f*"))
    assertEquals("", clearStars("*"))
    assertEquals("c", clearStars("cb*a*"))
  }
}
