package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCompleteSubarraysTest {
  @Test
  fun testExample1() {
    val nums = intArrayOf(1,3,1,2,2)
    assertEquals(4, countCompleteSubarrays(nums))
  }

  @Test
  fun testExample2() {
    val nums = intArrayOf(5,5,5,5)
    assertEquals(10, countCompleteSubarrays(nums))
  }

  @Test
  fun testAllDistinct() {
    val nums = intArrayOf(1,2,3,4)
    assertEquals(1, countCompleteSubarrays(nums))
  }

  @Test
  fun testSingleElement() {
    val nums = intArrayOf(7)
    assertEquals(1, countCompleteSubarrays(nums))
  }
}
