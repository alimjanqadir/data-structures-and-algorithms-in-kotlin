package problems.powerofthree

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PowerOfThreeTest {
  private val solution = Solution()

  @Test
  fun testIsPowerOfThree() {
    assertTrue(solution.isPowerOfThree(1))
    assertTrue(solution.isPowerOfThree(27))
    assertFalse(solution.isPowerOfThree(0))
    assertFalse(solution.isPowerOfThree(45))
  }
}
