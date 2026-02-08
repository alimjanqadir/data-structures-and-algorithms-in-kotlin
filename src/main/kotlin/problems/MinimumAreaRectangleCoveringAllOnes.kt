package problems.minimumarearectanglecoveringallones

class Solution {
  fun minimumArea(grid: Array<IntArray>): Int {
    var top = Int.MAX_VALUE
    var bottom = Int.MIN_VALUE
    var left = Int.MAX_VALUE
    var right = Int.MIN_VALUE

    // Find the boundaries of 1's in the grid
    for (i in grid.indices) {
      for (j in grid[i].indices) {
        if (grid[i][j] == 1) {
          top = minOf(top, i)
          bottom = maxOf(bottom, i)
          left = minOf(left, j)
          right = maxOf(right, j)
        }
      }
    }

    // Calculate the area of the rectangle
    val height = bottom - top + 1
    val width = right - left + 1
    return height * width
  }
}

