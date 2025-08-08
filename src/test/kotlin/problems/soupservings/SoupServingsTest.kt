package problems.soupservings

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SoupServingsTest {
  @Test
  fun testSoupServings() {
    val solution = Solution()
    assertEquals(0.625, solution.soupServings(50))
    assertEquals(0.71875, solution.soupServings(100))
    assertEquals(1.0, solution.soupServings(660295675))
  }
}

