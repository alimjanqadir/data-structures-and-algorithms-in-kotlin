package problems.findclosest

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindClosestTest {
  private val solution = Solution()

  @Test
  fun testPerson1Closer() {
    assertEquals(1, solution.findClosest(1, 4, 2))
  }

  @Test
  fun testPerson2Closer() {
    assertEquals(2, solution.findClosest(5, 1, 2))
  }

  @Test
  fun testBothSameDistance() {
    assertEquals(0, solution.findClosest(2, 4, 3))
  }
}
