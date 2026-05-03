import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RotateStringTest {
  @Test
  fun testRotateString() {
    assertTrue(rotateString("abcde", "cdeab"))
    assertFalse(rotateString("abcde", "abced"))
    assertTrue(rotateString("", ""))
    assertTrue(rotateString("a", "a"))
    assertFalse(rotateString("aa", "a"))
  }
}
