package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSubarraysWhereMaxElementAppearsAtLeastKTimesTest {
  @Test
  fun example1() {
    val nums = intArrayOf(1,3,2,3,3)
    val k = 2
    val expected = 6L
    assertEquals(expected, countSubarraysWhereMaxElementAppearsAtLeastKTimes(nums, k))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(1,4,2,1)
    val k = 3
    val expected = 0L
    assertEquals(expected, countSubarraysWhereMaxElementAppearsAtLeastKTimes(nums, k))
  }

  @Test
  fun singleElement() {
    val nums = intArrayOf(5)
    val k = 1
    val expected = 1L
    assertEquals(expected, countSubarraysWhereMaxElementAppearsAtLeastKTimes(nums, k))
  }

  @Test
  fun allSame() {
    val nums = intArrayOf(2,2,2,2)
    val k = 2
    val expected = 6L // subarrays of length >=2: [2,2], [2,2,2], [2,2,2,2] and their positions
    assertEquals(expected, countSubarraysWhereMaxElementAppearsAtLeastKTimes(nums, k))
  }

  @Test
  fun kGreaterThanCount() {
    val nums = intArrayOf(1,2,3,4)
    val k = 5
    val expected = 0L
    assertEquals(expected, countSubarraysWhereMaxElementAppearsAtLeastKTimes(nums, k))
  }
}
