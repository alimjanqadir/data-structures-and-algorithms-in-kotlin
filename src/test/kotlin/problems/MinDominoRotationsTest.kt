package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinDominoRotationsTest {
  @Test
  fun testExample1() {
    val tops = intArrayOf(2, 1, 2, 4, 2, 2)
    val bottoms = intArrayOf(5, 2, 6, 2, 3, 2)
    assertEquals(2, minDominoRotations(tops, bottoms))
  }

  @Test
  fun testExample2() {
    val tops = intArrayOf(3, 5, 1, 2, 3)
    val bottoms = intArrayOf(3, 6, 3, 3, 4)
    assertEquals(-1, minDominoRotations(tops, bottoms))
  }

  @Test
  fun testAllSame() {
    val tops = intArrayOf(1, 1, 1, 1)
    val bottoms = intArrayOf(1, 1, 1, 1)
    assertEquals(0, minDominoRotations(tops, bottoms))
  }

  @Test
  fun testImpossibleCase() {
    val tops = intArrayOf(1, 2, 3, 4)
    val bottoms = intArrayOf(5, 6, 7, 8)
    assertEquals(-1, minDominoRotations(tops, bottoms))
  }
}
