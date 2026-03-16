package problems

import kotlin.test.Test
import kotlin.test.assertTrue

class GetBiggestThreeTest {

  @Test
  fun testExample1() {
    val grid = arrayOf(
      intArrayOf(3, 4, 5, 1, 3),
      intArrayOf(3, 3, 4, 2, 3),
      intArrayOf(20, 30, 200, 40, 10),
      intArrayOf(1, 5, 5, 4, 1),
      intArrayOf(4, 3, 2, 2, 5)
    )
    val result = getBiggestThree(grid)
    assertTrue(result.contentEquals(intArrayOf(228, 216, 211)))
  }

  @Test
  fun testExample2() {
    val grid = arrayOf(
      intArrayOf(1, 2, 3),
      intArrayOf(4, 5, 6),
      intArrayOf(7, 8, 9)
    )
    val result = getBiggestThree(grid)
    println("Ex2 Actual: ${result.contentToString()}, Expected: [20, 9, 8]")
    assertTrue(result.contentEquals(intArrayOf(20, 9, 8)))
  }

  @Test
  fun testExample3() {
    val grid = arrayOf(
      intArrayOf(7, 7, 7)
    )
    val result = getBiggestThree(grid)
    println("Ex3 Actual: ${result.contentToString()}, Expected: [7]")
    assertTrue(result.contentEquals(intArrayOf(7)))
  }
}
