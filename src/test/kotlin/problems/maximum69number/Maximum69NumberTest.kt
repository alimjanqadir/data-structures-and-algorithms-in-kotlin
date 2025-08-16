package problems.maximum69number

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Maximum69NumberTest {
  private val solution = Solution()

  @Test
  fun providedExample() {
    assertEquals(9969, solution.maximum69Number(9669))
  }

  @Test
  fun alreadyMax() {
    assertEquals(9999, solution.maximum69Number(9999))
  }

  @Test
  fun singleDigit() {
    assertEquals(9, solution.maximum69Number(6))
  }
}
