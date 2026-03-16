package problems

fun getBiggestThree(grid: Array<IntArray>): IntArray {
  val rowCount = grid.size
  val columnCount = grid[0].size

  val distinctSums = java.util.TreeSet<Int>()

  for (row in 0 until rowCount) {
    for (column in 0 until columnCount) {

      distinctSums.add(grid[row][column])

      var radius = 1

      while (true) {

        if (
          row - radius < 0 ||
          row + radius >= rowCount ||
          column - radius < 0 ||
          column + radius >= columnCount
        ) break

        var sum = 0

        // Top to right (down-right direction)
        var currentRow = row - radius
        var currentColumn = column
        for (step in 0 until radius) {
          sum += grid[currentRow][currentColumn]
          currentRow++
          currentColumn++
        }

        // Right to bottom (down-left direction)
        for (step in 0 until radius) {
          sum += grid[currentRow][currentColumn]
          currentRow++
          currentColumn--
        }

        // Bottom to left (up-left direction)
        for (step in 0 until radius) {
          sum += grid[currentRow][currentColumn]
          currentRow--
          currentColumn--
        }

        // Left to top (up-right direction)
        for (step in 0 until radius) {
          sum += grid[currentRow][currentColumn]
          currentRow--
          currentColumn++
        }

        distinctSums.add(sum)

        radius += 1
      }
    }
  }

  val result = IntArray(minOf(3, distinctSums.size))

  var index = 0
  val descendingIterator = distinctSums.descendingIterator()

  while (index < result.size && descendingIterator.hasNext()) {
    result[index] = descendingIterator.next()
    index += 1
  }

  return result
}
