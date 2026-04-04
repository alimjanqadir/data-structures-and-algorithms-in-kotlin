package problems

/**
 * 2087. Minimum Cost Homecoming of a Robot in a Grid
 * LeetCode problem: Medium
 *
 * Calculates the minimum total cost for a robot to return home in a grid.
 * The robot can move up, down, left, or right with different costs for each row/column.
 *
 * Time Complexity: O(m + n) where m is the number of rows and n is the number of columns
 * Space Complexity: O(1)
 *
 * @param startPos Starting position [row, col]
 * @param homePos Home position [row, col]
 * @param rowCosts Cost array for each row movement
 * @param colCosts Cost array for each column movement
 * @return Minimum total cost to return home
 */
fun minCost(
  startPos: IntArray,
  homePos: IntArray,
  rowCosts: IntArray,
  colCosts: IntArray
): Int {
  var totalCost = 0

  val startRow = startPos[0]
  val startCol = startPos[1]
  val homeRow = homePos[0]
  val homeCol = homePos[1]

  // Move vertically
  if (startRow < homeRow) {
    for (rowIndex in startRow + 1..homeRow) {
      totalCost += rowCosts[rowIndex]
    }
  } else {
    for (rowIndex in homeRow until startRow) {
      totalCost += rowCosts[rowIndex]
    }
  }

  // Move horizontally
  if (startCol < homeCol) {
    for (colIndex in startCol + 1..homeCol) {
      totalCost += colCosts[colIndex]
    }
  } else {
    for (colIndex in homeCol until startCol) {
      totalCost += colCosts[colIndex]
    }
  }

  return totalCost
}
