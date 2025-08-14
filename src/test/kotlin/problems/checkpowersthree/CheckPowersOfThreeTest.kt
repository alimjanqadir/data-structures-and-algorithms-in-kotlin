package problems.checkpowersthree

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckPowersOfThreeTest {
  private val solution = Solution()

  @Test
  fun testCheckPowersOfThree() {
    assertTrue(solution.checkPowersOfThree(12))
    assertTrue(solution.checkPowersOfThree(91))
    assertFalse(solution.checkPowersOfThree(21))
    assertFalse(solution.checkPowersOfThree(2))
  }
}
