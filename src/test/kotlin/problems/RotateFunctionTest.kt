package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RotateFunctionTest {
  @Test
  fun example1() {
    assertEquals(26, maxRotateFunction(intArrayOf(4, 3, 2, 6)))
  }

  @Test
  fun singleElement() {
    assertEquals(0, maxRotateFunction(intArrayOf(100)))
  }

  @Test
  fun allNegative() {
    assertEquals(-5, maxRotateFunction(intArrayOf(-1, -2, -3)))
  }
}
