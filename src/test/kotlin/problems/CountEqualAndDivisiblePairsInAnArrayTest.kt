package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountEqualAndDivisiblePairsInAnArrayTest {
  @Test
  fun example1() {
    val nums = intArrayOf(3,1,2,2,2,1,3)
    val k = 2
    assertEquals(4, countPairs(nums, k))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(1,2,3,4)
    val k = 1
    assertEquals(0, countPairs(nums, k)) // No pairs with equal value
  }

  @Test
  fun customCase() {
    val nums = intArrayOf(1,1,1,1)
    val k = 2
    // All pairs with nums[i]==nums[j]: (0,1), (0,2), (0,3), (1,2), (1,3), (2,3)
    // (0,2): 0*2=0 %2==0 ✔️
    // (0,3): 0*3=0 %2==0 ✔️
    // (1,2): 1*2=2 %2==0 ✔️
    // (1,3): 1*3=3 %2==1
    // (2,3): 2*3=6 %2==0 ✔️
    // (0,1): 0*1=0 %2==0 ✔️
    // Total: 5 pairs
    assertEquals(5, countPairs(nums, k))
  }
}
