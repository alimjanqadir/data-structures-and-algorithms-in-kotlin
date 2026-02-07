package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CheckPowersOfThreeTest {

  @Test
  fun testCheckPowersOfThree() {
    assertTrue(checkPowersOfThree(12))
    assertTrue(checkPowersOfThree(91))
    assertFalse(checkPowersOfThree(21))
    assertFalse(checkPowersOfThree(2))
  }
}
