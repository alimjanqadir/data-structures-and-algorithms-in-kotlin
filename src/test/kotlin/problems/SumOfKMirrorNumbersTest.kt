package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SumOfKMirrorNumbersTest {
  @Test
  fun example1() {
    assertEquals(25L, kMirror(2, 5))
  }

  @Test
  fun example2() {
    assertEquals(499L, kMirror(3, 7))
  }

  @Test
  fun example3() {
    assertEquals(20379000L, kMirror(7, 17))
  }
}
