package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaxFreqSumTest {
  @Test
  fun testMaxFreqSum() {
    assertEquals(4, maxFreqSum("aabbcc"))
    assertEquals(4, maxFreqSum("aaaa"))
    assertEquals(1, maxFreqSum("bcdfg"))
    assertEquals(2, maxFreqSum("aeiouxyz"))
  }
}
