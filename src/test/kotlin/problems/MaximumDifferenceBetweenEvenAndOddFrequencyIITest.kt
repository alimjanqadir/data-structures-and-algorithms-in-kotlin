package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumDifferenceBetweenEvenAndOddFrequencyIITest {
  @Test
  fun testMaxDifference() {
    assertEquals(-1, maxDifference("abcba", 3))
    assertEquals(1, maxDifference("aaabb", 5))
  }
}
