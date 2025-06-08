import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountInterestingSubarraysTest {
  @Test
  fun testExample1() {
    val nums = listOf(3,1,9,6)
    val modulo = 3
    val k = 0
    val expected = 2L // Only [1] and [3,1,9,6] are interesting
    assertEquals(expected, countInterestingSubarrays(nums, modulo, k))
  }

  @Test
  fun testExample2() {
    val nums = listOf(2,2,2,2)
    val modulo = 2
    val k = 1
    val expected = 0L // No subarray has odd count of v % 2 == 1
    assertEquals(expected, countInterestingSubarrays(nums, modulo, k))
  }

  @Test
  fun testEdgeCaseEmpty() {
    val nums = emptyList<Int>()
    val modulo = 1
    val k = 0
    val expected = 0L
    assertEquals(expected, countInterestingSubarrays(nums, modulo, k))
  }

  @Test
  fun testEdgeCaseAllMatch() {
    val nums = listOf(1,1,1,1)
    val modulo = 1
    val k = 0
    val expected = 10L // all subarrays
    assertEquals(expected, countInterestingSubarrays(nums, modulo, k))
  }
}
