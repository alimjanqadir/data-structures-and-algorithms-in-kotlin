package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindTheOriginalTypedStringITest {
  @Test
  fun example1() {
    assertEquals(5L, possibleStringCount("abbcccc"))
  }

  @Test
  fun example2() {
    assertEquals(1L, possibleStringCount("abcd"))
  }

  @Test
  fun example3() {
    assertEquals(4L, possibleStringCount("aaaa"))
  }
}
