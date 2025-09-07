package problems.sumzero

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class SumZeroTest {
  @Test
  fun testEven() {
    val result = Solution().sumZero(4)
    assertContentEquals(intArrayOf(1, -1, 2, -2), result)
    assertEquals(0, result.sum())
  }

  @Test
  fun testOdd() {
    val result = Solution().sumZero(5)
    assertContentEquals(intArrayOf(1, -1, 2, -2, 0), result)
    assertEquals(0, result.sum())
  }
}

