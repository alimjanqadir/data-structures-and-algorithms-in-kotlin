package problems

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
  val rowCount = heights.size
  val colCount = heights[0].size

  // Visited markers for each ocean
  val visitedPacific = Array(rowCount) { BooleanArray(colCount) }
  val visitedAtlantic = Array(rowCount) { BooleanArray(colCount) }

  // Directions: up, down, left, right
  val neighborSteps = listOf(
    intArrayOf(-1, 0),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(0, 1)
  )

  // Collect border cells for each ocean
  val pacificStarts = ArrayDeque<Pair<Int, Int>>()
  val atlanticStarts = ArrayDeque<Pair<Int, Int>>()

  // Top and bottom rows
  for (column in 0 until colCount) {
    pacificStarts.addLast(0 to column)
    atlanticStarts.addLast((rowCount - 1) to column)
  }
  // Left and right columns
  for (row in 0 until rowCount) {
    pacificStarts.addLast(row to 0)
    atlanticStarts.addLast(row to (colCount - 1))
  }

  // BFS that walks "uphill" (reverse flow)
  fun bfs(startQueue: ArrayDeque<Pair<Int, Int>>, visited: Array<BooleanArray>) {
    while (startQueue.isNotEmpty()) {
      val (row, column) = startQueue.removeFirst()
      if (visited[row][column]) {
        continue
      }
      visited[row][column] = true

      val currentHeight = heights[row][column]
      for (step in neighborSteps) {
        val nextRow = row + step[0]
        val nextCol = column + step[1]
        val insideRows = nextRow >= 0 && nextRow < rowCount
        val insideCols = nextCol >= 0 && nextCol < colCount
        if (!insideRows || !insideCols) {
          continue
        }
        if (visited[nextRow][nextCol]) {
          continue
        }
        // Reverse rule: can move if neighbor is >= current
        if (heights[nextRow][nextCol] >= currentHeight) {
          startQueue.addLast(nextRow to nextCol)
        }
      }
    }
  }

  bfs(pacificStarts, visitedPacific)
  bfs(atlanticStarts, visitedAtlantic)

  val reachableBoth = ArrayList<List<Int>>()
  for (row in 0 until rowCount) {
    for (column in 0 until colCount) {
      if (visitedPacific[row][column] && visitedAtlantic[row][column]) {
        reachableBoth.add(listOf(row, column))
      }
    }
  }
  return reachableBoth
}
