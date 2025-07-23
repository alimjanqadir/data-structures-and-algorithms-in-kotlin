package problems

fun numIslands(grid: Array<CharArray>): Int {
  if (grid.isEmpty()) return 0

  var islandCount = 0
  val rows = grid.size
  val cols = grid[0].size

  // Iterate through each cell in the grid
  for (row in 0 until rows) {
    for (col in 0 until cols) {
      if (grid[row][col] == '1') {
        // Found a new island, increment counter and explore it
        islandCount++
        exploreIsland(grid, row, col)
      }
    }
  }

  return islandCount
}

// Helper function to explore and mark all connected land cells
private fun exploreIsland(grid: Array<CharArray>, row: Int, col: Int) {
  // Check boundaries and water cells
  if (row < 0 || row >= grid.size ||
    col < 0 || col >= grid[0].size ||
    grid[row][col] != '1') {
    return
  }

  // Mark current cell as visited by changing it to '2'
  grid[row][col] = '2'

  // Recursively explore adjacent cells (up, right, down, left)
  exploreIsland(grid, row - 1, col) // up
  exploreIsland(grid, row, col + 1) // right
  exploreIsland(grid, row + 1, col) // down
  exploreIsland(grid, row, col - 1) // left
}

// Test cases
