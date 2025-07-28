package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountMaxOrSubsetsTest {
  @Test
  fun example1() {
    val nums = intArrayOf(3, 1)
    assertEquals(2, countMaxOrSubsets(nums))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(2, 2, 2)
    assertEquals(7, countMaxOrSubsets(nums))
  }

  @Test
  fun example3() {
    val nums = intArrayOf(3, 2, 1, 5)
    assertEquals(6, countMaxOrSubsets(nums))
  }

  @Test
  fun singleElement() {
    val nums = intArrayOf(5)
    assertEquals(1, countMaxOrSubsets(nums))
  }
}
