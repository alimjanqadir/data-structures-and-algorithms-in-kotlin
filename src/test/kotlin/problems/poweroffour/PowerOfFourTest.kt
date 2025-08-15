package problems.poweroffour

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PowerOfFourTest {
  private val solution = Solution()

  @Test
  fun testIsPowerOfFour() {
    assertTrue(solution.isPowerOfFour(1))
    assertTrue(solution.isPowerOfFour(16))
    assertFalse(solution.isPowerOfFour(8))
    assertFalse(solution.isPowerOfFour(0))
    assertFalse(solution.isPowerOfFour(-4))
  }
}
