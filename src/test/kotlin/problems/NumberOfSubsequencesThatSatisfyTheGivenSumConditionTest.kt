package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfSubsequencesThatSatisfyTheGivenSumConditionTest {
  @Test
  fun example1() {
    val nums = intArrayOf(3,5,6,7)
    val target = 9
    assertEquals(4, numSubseq(nums, target))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(3,3,6,8)
    val target = 10
    assertEquals(6, numSubseq(nums, target))
  }

  @Test
  fun example3() {
    val nums = intArrayOf(2,3,3,4,6,7)
    val target = 12
    assertEquals(61, numSubseq(nums, target))
  }
}
