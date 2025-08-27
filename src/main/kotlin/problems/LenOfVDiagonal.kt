package problems

fun lenOfVDiagonal(grid: Array<IntArray>): Int {
  // Indices: 0=SE, 1=SW, 2=NW, 3=NE
  val rowStep = intArrayOf(1, 1, -1, -1)
  val colStep = intArrayOf(1, -1, -1, 1)
  // Clockwise: SE->SW->NW->NE->SE
  val clockwiseTurn = intArrayOf(1, 2, 3, 0)

  val rowCount = grid.size
  val colCount = grid[0].size

  val alt2 = Array(4) { Array(rowCount) { IntArray(colCount) } }
  val alt0 = Array(4) { Array(rowCount) { IntArray(colCount) } }

  fun computeAlt(r: Int, c: Int, dir: Int) {
    val nr = r + rowStep[dir]
    val nc = c + colStep[dir]
    val hasNext = nr in grid.indices && nc in grid[0].indices

    if (grid[r][c] == 2) {
      alt2[dir][r][c] = 1 + if (hasNext) alt0[dir][nr][nc] else 0
    } else {
      alt2[dir][r][c] = 0
    }

    if (grid[r][c] == 0) {
      alt0[dir][r][c] = 1 + if (hasNext) alt2[dir][nr][nc] else 0
    } else {
      alt0[dir][r][c] = 0
    }
  }

  for (dir in 0 until 4) {
    when (dir) {
      0 -> {
        for (r in rowCount - 1 downTo 0) for (c in colCount - 1 downTo 0)
          computeAlt(r, c, dir)
      }
      1 -> {
        for (r in rowCount - 1 downTo 0) for (c in 0 until colCount)
          computeAlt(r, c, dir)
      }
      2 -> {
        for (r in 0 until rowCount) for (c in 0 until colCount)
          computeAlt(r, c, dir)
      }
      else -> {
        for (r in 0 until rowCount) for (c in colCount - 1 downTo 0)
          computeAlt(r, c, dir)
      }
    }
  }

  fun updateAndTurn(r: Int, c: Int, dir: Int, straightEnd: Array<IntArray>): Int {
    val pr = r - rowStep[dir]
    val pc = c - colStep[dir]
    val hasPrev = pr in grid.indices && pc in grid[0].indices
    val prevLen = if (hasPrev) straightEnd[pr][pc] else 0

    val straightHere = when {
      grid[r][c] == 1 -> 1
      prevLen > 0 -> {
        val need = if (prevLen % 2 == 1) 2 else 0
        if (grid[r][c] == need) prevLen + 1 else 0
      }
      else -> 0
    }
    straightEnd[r][c] = straightHere

    var bestAtCell = straightHere
    if (straightHere > 0) {
      val turnDir = clockwiseTurn[dir]
      val nr = r + rowStep[turnDir]
      val nc = c + colStep[turnDir]
      if (nr in grid.indices && nc in grid[0].indices) {
        val need = if (straightHere % 2 == 1) 2 else 0
        val cont = if (need == 2) alt2[turnDir][nr][nc] else alt0[turnDir][nr][nc]
        bestAtCell = maxOf(bestAtCell, straightHere + cont)
      }
    }

    return bestAtCell
  }

  var best = 0

  for (dir in 0 until 4) {
    val straightEnd = Array(rowCount) { IntArray(colCount) }
    when (dir) {
      0 -> {
        for (r in 0 until rowCount) for (c in 0 until colCount)
          best = maxOf(best, updateAndTurn(r, c, dir, straightEnd))
      }
      1 -> {
        for (r in 0 until rowCount) for (c in colCount - 1 downTo 0)
          best = maxOf(best, updateAndTurn(r, c, dir, straightEnd))
      }
      2 -> {
        for (r in rowCount - 1 downTo 0) for (c in colCount - 1 downTo 0)
          best = maxOf(best, updateAndTurn(r, c, dir, straightEnd))
      }
      else -> {
        for (r in rowCount - 1 downTo 0) for (c in 0 until colCount)
          best = maxOf(best, updateAndTurn(r, c, dir, straightEnd))
      }
    }
  }

  return best
}

