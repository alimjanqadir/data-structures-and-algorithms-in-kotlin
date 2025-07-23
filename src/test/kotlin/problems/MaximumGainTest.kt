package problems

import problems.maximumGain
import kotlin.test.Test
import kotlin.test.assertEquals

class MaximumGainTest {
  @Test
  fun example1() {
    assertEquals(19, maximumGain("cdbcbbaaabab", 4, 5))
  }

  @Test
  fun example2() {
    assertEquals(20, maximumGain("aabbaaxybbaabb", 5, 4))
  }

  @Test
  fun single() {
    assertEquals(1, maximumGain("abcde", 1, 1))
  }
}
