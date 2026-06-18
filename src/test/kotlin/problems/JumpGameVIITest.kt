import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JumpGameVIITest {
  @Test
  fun exampleOne() {
    assertTrue(canReachJumpGameVII("011010", 2, 3))
  }

  @Test
  fun exampleTwo() {
    assertFalse(canReachJumpGameVII("01101110", 2, 3))
  }

  @Test
  fun singleCharacterReachable() {
    assertTrue(canReachJumpGameVII("0", 1, 1))
  }

  @Test
  fun blockedLastCharacter() {
    assertFalse(canReachJumpGameVII("0101", 1, 2))
  }
}
