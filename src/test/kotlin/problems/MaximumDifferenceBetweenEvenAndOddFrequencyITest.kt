package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumDifferenceBetweenEvenAndOddFrequencyITest {
  @Test
  fun testMaxDifference() {
    assertEquals(3, maxDifference("aaaaabbc"))
    assertEquals(1, maxDifference("abcabcab"))
  }
}
