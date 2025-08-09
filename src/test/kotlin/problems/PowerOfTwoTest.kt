package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PowerOfTwoTest {
  @Test
  fun testIsPowerOfTwo() {
    assertTrue(isPowerOfTwo(1))
    assertTrue(isPowerOfTwo(1024))
    assertFalse(isPowerOfTwo(0))
    assertFalse(isPowerOfTwo(3))
    assertFalse(isPowerOfTwo(-2))
  }
}
