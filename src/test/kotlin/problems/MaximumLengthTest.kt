package problems

import problems.maximumLength
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumLengthTest {

  @Test
  fun testExamples() {
    assertEquals(3, maximumLength(intArrayOf(1, 2, 3)))
    assertEquals(5, maximumLength(intArrayOf(2, 4, 6, 8, 10)))
    assertEquals(7, maximumLength(intArrayOf(1, 2, 1, 2, 1, 2, 1)))
  }
}
