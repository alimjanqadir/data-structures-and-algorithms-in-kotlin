package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumCostHomecomingOfARobotInAGridTest {

  @Test
  fun testMinCostExample1() {
    // Example 1 from LeetCode
    val startPos = intArrayOf(1, 0)
    val homePos = intArrayOf(2, 3)
    val rowCosts = intArrayOf(5, 4, 3)
    val colCosts = intArrayOf(8, 2, 6, 7)

    // Move from row 1 to row 2: cost = rowCosts[2] = 3
    // Move from col 0 to col 3: cost = colCosts[1] + colCosts[2] + colCosts[3] = 2 + 6 + 7 = 15
    // Total: 3 + 15 = 18
    assertEquals(18, minCost(startPos, homePos, rowCosts, colCosts))
  }

  @Test
  fun testMinCostExample2() {
    // Example 2 from LeetCode
    val startPos = intArrayOf(0, 0)
    val homePos = intArrayOf(0, 0)
    val rowCosts = intArrayOf(5)
    val colCosts = intArrayOf(26)

    // Already at home
    assertEquals(0, minCost(startPos, homePos, rowCosts, colCosts))
  }

  @Test
  fun testMinCostMoveRight() {
    val startPos = intArrayOf(0, 0)
    val homePos = intArrayOf(0, 2)
    val rowCosts = intArrayOf(1)
    val colCosts = intArrayOf(1, 2, 3)

    // Move from col 0 to col 2: cost = colCosts[1] + colCosts[2] = 2 + 3 = 5
    assertEquals(5, minCost(startPos, homePos, rowCosts, colCosts))
  }

  @Test
  fun testMinCostMoveLeft() {
    val startPos = intArrayOf(0, 2)
    val homePos = intArrayOf(0, 0)
    val rowCosts = intArrayOf(1)
    val colCosts = intArrayOf(1, 2, 3)

    // Move from col 2 to col 0: cost = colCosts[0] + colCosts[1] = 1 + 2 = 3
    assertEquals(3, minCost(startPos, homePos, rowCosts, colCosts))
  }

  @Test
  fun testMinCostMoveDown() {
    val startPos = intArrayOf(0, 0)
    val homePos = intArrayOf(2, 0)
    val rowCosts = intArrayOf(1, 2, 3)
    val colCosts = intArrayOf(1)

    // Move from row 0 to row 2: cost = rowCosts[1] + rowCosts[2] = 2 + 3 = 5
    assertEquals(5, minCost(startPos, homePos, rowCosts, colCosts))
  }

  @Test
  fun testMinCostMoveUp() {
    val startPos = intArrayOf(2, 0)
    val homePos = intArrayOf(0, 0)
    val rowCosts = intArrayOf(1, 2, 3)
    val colCosts = intArrayOf(1)

    // Move from row 2 to row 0: cost = rowCosts[0] + rowCosts[1] = 1 + 2 = 3
    assertEquals(3, minCost(startPos, homePos, rowCosts, colCosts))
  }

  @Test
  fun testMinCostDiagonalMove() {
    val startPos = intArrayOf(1, 1)
    val homePos = intArrayOf(3, 3)
    val rowCosts = intArrayOf(1, 2, 3, 4)
    val colCosts = intArrayOf(1, 2, 3, 4)

    // Move from row 1 to row 3: cost = rowCosts[2] + rowCosts[3] = 3 + 4 = 7
    // Move from col 1 to col 3: cost = colCosts[2] + colCosts[3] = 3 + 4 = 7
    // Total: 7 + 7 = 14
    assertEquals(14, minCost(startPos, homePos, rowCosts, colCosts))
  }

  @Test
  fun testMinCostReverseDiagonal() {
    val startPos = intArrayOf(3, 3)
    val homePos = intArrayOf(0, 0)
    val rowCosts = intArrayOf(1, 2, 3, 4)
    val colCosts = intArrayOf(1, 2, 3, 4)

    // Move from row 3 to row 0: cost = rowCosts[0] + rowCosts[1] + rowCosts[2] = 1 + 2 + 3 = 6
    // Move from col 3 to col 0: cost = colCosts[0] + colCosts[1] + colCosts[2] = 1 + 2 + 3 = 6
    // Total: 6 + 6 = 12
    assertEquals(12, minCost(startPos, homePos, rowCosts, colCosts))
  }
}
