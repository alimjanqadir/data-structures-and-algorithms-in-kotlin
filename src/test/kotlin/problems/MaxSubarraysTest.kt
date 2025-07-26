package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaxSubarraysTest {
  @Test
  fun example1() {
    val n = 4
    val pairs = arrayOf(
      intArrayOf(2, 3),
      intArrayOf(1, 4)
    )
    assertEquals(9L, maxSubarrays(n, pairs))
  }

  @Test
  fun example2() {
    val n = 5
    val pairs = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(2, 5),
      intArrayOf(3, 5)
    )
    assertEquals(12L, maxSubarrays(n, pairs))
  }

  @Test
  fun smallCases() {
    assertEquals(3L, maxSubarrays(2, arrayOf(intArrayOf(1, 2))))
    assertEquals(4L, maxSubarrays(3, arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))))
    assertEquals(6L, maxSubarrays(3, arrayOf(intArrayOf(1, 3))))
  }
}
