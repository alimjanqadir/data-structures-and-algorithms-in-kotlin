import kotlin.math.min

/**
 * Computes the minimum path sum from top to bottom of a triangle of integers.
 *
 * The function uses bottom-up dynamic programming to accumulate the minimum
 * path sums for each position starting from the last row. An auxiliary array
 * stores the best sums from the row below, enabling an in-place update as we
 * traverse upwards. The first element of this array after processing all rows
 * represents the minimum total path sum.
 */
fun minimumTotal(triangle: List<List<Int>>): Int {
  val rowCount = triangle.size
  val minPathFromBelow = IntArray(rowCount + 1)

  var currentRow = rowCount - 1
  while (currentRow >= 0) {
    val columnCount = triangle[currentRow].size
    var currentColumn = 0
    while (currentColumn < columnCount) {
      val bestChildSum = min(
        minPathFromBelow[currentColumn],
        minPathFromBelow[currentColumn + 1]
      )
      minPathFromBelow[currentColumn] =
        triangle[currentRow][currentColumn] + bestChildSum
      currentColumn += 1
    }
    currentRow -= 1
  }
  return minPathFromBelow[0]
}
