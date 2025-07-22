package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumErasureValueTest {
  @Test
  fun example1() {
    val nums = intArrayOf(4, 2, 4, 5, 6)
    assertEquals(17, maximumUniqueSubarray(nums))
  }

  @Test
  fun allUnique() {
    val nums = intArrayOf(1, 2, 3, 4)
    assertEquals(10, maximumUniqueSubarray(nums))
  }

  @Test
  fun repeatedValues() {
    val nums = intArrayOf(1, 1, 1, 1)
    assertEquals(1, maximumUniqueSubarray(nums))
  }
}
