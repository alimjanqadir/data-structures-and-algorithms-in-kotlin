package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import problems.minimumarearectanglecoveringallones.Solution

class MinimumAreaRectangleCoveringAllOnesTest {
  @Test
  fun testMinimumArea() {
    val solution = Solution()
    val grid1 = arrayOf(
      intArrayOf(0, 0, 0),
      intArrayOf(0, 1, 0),
      intArrayOf(0, 0, 0)
    )
    assertEquals(1, solution.minimumArea(grid1))

    val grid2 = arrayOf(
      intArrayOf(0, 1, 0),
      intArrayOf(1, 0, 0)
    )
    assertEquals(4, solution.minimumArea(grid2))
  }
}

