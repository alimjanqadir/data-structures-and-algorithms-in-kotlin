import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import problems.canReach

class JumpGameIIITest {
  @Test
  fun `can reach zero from start`() {
    assertTrue(canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
    assertTrue(canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 0))
  }

  @Test
  fun `cannot reach zero from start`() {
    assertFalse(canReach(intArrayOf(3, 0, 2, 1, 2), 2))
  }
}
