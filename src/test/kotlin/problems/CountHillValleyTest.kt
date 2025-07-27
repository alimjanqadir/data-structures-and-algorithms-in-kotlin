package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountHillValleyTest {
  @Test
  fun example1() {
    val nums = intArrayOf(2, 4, 1, 1, 6, 5)
    assertEquals(3, countHillValley(nums))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(6, 6, 5, 5, 4, 1)
    assertEquals(0, countHillValley(nums))
  }

  @Test
  fun singleHill() {
    val nums = intArrayOf(1, 3, 1)
    assertEquals(1, countHillValley(nums))
  }

  @Test
  fun plateau() {
    val nums = intArrayOf(2, 2, 2)
    assertEquals(0, countHillValley(nums))
  }
}
