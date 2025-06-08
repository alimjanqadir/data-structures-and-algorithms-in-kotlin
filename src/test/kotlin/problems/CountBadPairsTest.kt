package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountBadPairsTest {
  @Test
  fun example1() {
    val nums = intArrayOf(4, 1, 3, 3)
    assertEquals(5L, countBadPairs(nums))
  }

  @Test
  fun allGoodPairs() {
    val nums = intArrayOf(1, 2, 3, 4, 5)
    assertEquals(0L, countBadPairs(nums))
  }

  @Test
  fun noGoodPairs() {
    val nums = intArrayOf(1, 1, 1, 1)
    assertEquals(6L, countBadPairs(nums))
  }

  @Test
  fun singleElement() {
    val nums = intArrayOf(1)
    assertEquals(0L, countBadPairs(nums))
  }
}
