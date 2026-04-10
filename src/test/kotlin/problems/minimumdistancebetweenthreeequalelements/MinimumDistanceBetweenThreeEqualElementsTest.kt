package problems.minimumdistancebetweenthreeequalelements

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumDistanceBetweenThreeEqualElementsTest {

  @Test
  fun testExample1() {
    val solution = Solution()
    val nums = intArrayOf(1, 2, 1, 1, 3)
    assertEquals(6, solution.minimumDistance(nums))
  }

  @Test
  fun testExample2() {
    val solution = Solution()
    val nums = intArrayOf(1, 1, 2, 3, 2, 1, 2)
    assertEquals(8, solution.minimumDistance(nums))
  }

  @Test
  fun testExample3() {
    val solution = Solution()
    val nums = intArrayOf(1)
    assertEquals(-1, solution.minimumDistance(nums))
  }

  @Test
  fun testNoGoodTuple() {
    val solution = Solution()
    val nums = intArrayOf(1, 2, 3, 4, 5)
    assertEquals(-1, solution.minimumDistance(nums))
  }

  @Test
  fun testMinimumArray() {
    val solution = Solution()
    val nums = intArrayOf(1, 1, 1)
    assertEquals(4, solution.minimumDistance(nums))
  }

  @Test
  fun testTwoOccurrences() {
    val solution = Solution()
    val nums = intArrayOf(1, 2, 1, 2)
    assertEquals(-1, solution.minimumDistance(nums))
  }

  @Test
  fun testAllSame() {
    val solution = Solution()
    val nums = intArrayOf(7, 7, 7, 7, 7, 7, 7)
    assertEquals(4, solution.minimumDistance(nums))
  }
}
