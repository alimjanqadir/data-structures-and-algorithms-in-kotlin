package problems

import java.util.PriorityQueue
import kotlin.math.max

private data class CellState(val timeSoFar: Int, val row: Int, val col: Int)

fun swimInWater(grid: Array<IntArray>): Int {
  val size = grid.size
  val bestTime = Array(size) { IntArray(size) { Int.MAX_VALUE } }

  val queue = PriorityQueue(compareBy<CellState> { it.timeSoFar })

  bestTime[0][0] = grid[0][0]
  queue.add(CellState(grid[0][0], 0, 0))

  val directions = arrayOf(
    intArrayOf(1, 0),
    intArrayOf(-1, 0),
    intArrayOf(0, 1),
    intArrayOf(0, -1)
  )

  while (queue.isNotEmpty()) {
    val current = queue.poll()
    val currentRow = current.row
    val currentCol = current.col
    val currentTime = current.timeSoFar

    if (currentRow == size - 1 && currentCol == size - 1) {
      return currentTime
    }

    if (currentTime != bestTime[currentRow][currentCol]) {
      continue
    }

    for (delta in directions) {
      val nextRow = currentRow + delta[0]
      val nextCol = currentCol + delta[1]
      if (nextRow in 0 until size && nextCol in 0 until size) {
        val candidateTime = max(currentTime, grid[nextRow][nextCol])
        if (candidateTime < bestTime[nextRow][nextCol]) {
          bestTime[nextRow][nextCol] = candidateTime
          queue.add(CellState(candidateTime, nextRow, nextCol))
        }
      }
    }
  }

  return -1
}
