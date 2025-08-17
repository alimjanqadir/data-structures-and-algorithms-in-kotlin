package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class New21GameTest {
  @Test
  fun sample1() {
    assertEquals(1.0, new21Game(10, 1, 10), 1e-6)
  }

  @Test
  fun sample2() {
    assertEquals(0.6, new21Game(6, 1, 10), 1e-6)
  }

  @Test
  fun sample3() {
    assertEquals(0.73278, new21Game(21, 17, 10), 1e-5)
  }
}
