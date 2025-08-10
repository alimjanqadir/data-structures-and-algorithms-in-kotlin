package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ReorderedPowerOf2Test {
  @Test
  fun testReorderedPowerOf2() {
    assertTrue(reorderedPowerOf2(1))
    assertTrue(reorderedPowerOf2(821))
    assertFalse(reorderedPowerOf2(10))
    assertFalse(reorderedPowerOf2(123))
  }
}
