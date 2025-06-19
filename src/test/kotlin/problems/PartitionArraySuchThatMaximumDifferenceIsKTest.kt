package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PartitionArraySuchThatMaximumDifferenceIsKTest {
  @Test
  fun example1() {
    val nums = intArrayOf(3, 6, 1, 2, 5)
    assertEquals(2, partitionArray(nums, 2))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(1, 2, 3)
    assertEquals(2, partitionArray(nums, 1))
  }

  @Test
  fun example3() {
    val nums = intArrayOf(2, 2, 4, 5)
    assertEquals(3, partitionArray(nums, 0))
  }
}
