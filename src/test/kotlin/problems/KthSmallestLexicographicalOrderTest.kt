package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KthSmallestLexicographicalOrderTest {
  @Test
  fun testExamples() {
    assertEquals(10, findKthNumber(13, 2))
    assertEquals(1, findKthNumber(1, 1))
  }
}
