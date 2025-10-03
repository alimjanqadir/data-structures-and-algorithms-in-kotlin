package problems

import java.util.PriorityQueue

private data class Cell(val row: Int, val col: Int, val height: Int)

fun trapRainWater(heightMap: Array<IntArray>): Int {
  val rowCount = heightMap.size
  if (rowCount == 0) return 0

  val colCount = heightMap[0].size
  if (rowCount < 3 || colCount < 3) return 0

  val visited = Array(rowCount) { BooleanArray(colCount) }
  val minHeap = PriorityQueue<Cell> { a, b -> a.height.compareTo(b.height) }

  for (row in 0 until rowCount) {
    minHeap.add(Cell(row, 0, heightMap[row][0]))
    visited[row][0] = true

    val lastCol = colCount - 1
    minHeap.add(Cell(row, lastCol, heightMap[row][lastCol]))
    visited[row][lastCol] = true
  }

  for (col in 0 until colCount) {
    minHeap.add(Cell(0, col, heightMap[0][col]))
    visited[0][col] = true

    val lastRow = rowCount - 1
    minHeap.add(Cell(lastRow, col, heightMap[lastRow][col]))
    visited[lastRow][col] = true
  }

  val directions = intArrayOf(1, 0, -1, 0, 1)
  var trappedWater = 0

  while (minHeap.isNotEmpty()) {
    val boundary = minHeap.poll()

    for (dirIndex in 0 until 4) {
      val nextRow = boundary.row + directions[dirIndex]
      val nextCol = boundary.col + directions[dirIndex + 1]
      if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount) continue
      if (visited[nextRow][nextCol]) continue

      visited[nextRow][nextCol] = true

      val neighborHeight = heightMap[nextRow][nextCol]
      if (neighborHeight < boundary.height) {
        trappedWater += boundary.height - neighborHeight
      }

      val raisedHeight = maxOf(neighborHeight, boundary.height)
      minHeap.add(Cell(nextRow, nextCol, raisedHeight))
    }
  }

  return trappedWater
}
