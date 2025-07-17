package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumLengthIITest {
  @Test
  fun testExamples() {
    assertEquals(5, maximumLength(intArrayOf(1, 2, 3, 4, 5), 2))
    assertEquals(4, maximumLength(intArrayOf(1, 4, 2, 3, 1, 4), 3))
    assertEquals(3, maximumLength(intArrayOf(5, 5, 5), 7))
  }
}
