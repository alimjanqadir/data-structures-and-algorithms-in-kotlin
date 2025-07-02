package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindTheOriginalTypedStringIITest {
  @Test
  fun example1() {
    assertEquals(5, possibleStringCount("aabbccdd", 7))
  }

  @Test
  fun example2() {
    assertEquals(1, possibleStringCount("aabbccdd", 8))
  }

  @Test
  fun example3() {
    assertEquals(8, possibleStringCount("aaabbb", 3))
  }
}
