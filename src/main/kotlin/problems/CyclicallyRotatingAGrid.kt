package problems

fun rotateGrid(grid: Array<IntArray>, k: Int): Array<IntArray> {
  val rowCount = grid.size
  val columnCount = grid[0].size
  val layerCount = minOf(rowCount, columnCount) / 2

  for (layer in 0 until layerCount) {
    val top = layer
    val bottom = rowCount - 1 - layer
    val left = layer
    val right = columnCount - 1 - layer
    val layerValues = collectLayerValues(grid, top, bottom, left, right)
    val rotation = k % layerValues.size
    writeLayerValues(grid, top, bottom, left, right, layerValues, rotation)
  }

  return grid
}

private fun collectLayerValues(
  grid: Array<IntArray>,
  top: Int,
  bottom: Int,
  left: Int,
  right: Int,
): List<Int> {
  val layerValues = mutableListOf<Int>()

  for (column in left..right) {
    layerValues.add(grid[top][column])
  }

  for (row in top + 1 until bottom) {
    layerValues.add(grid[row][right])
  }

  for (column in right downTo left) {
    layerValues.add(grid[bottom][column])
  }

  for (row in bottom - 1 downTo top + 1) {
    layerValues.add(grid[row][left])
  }

  return layerValues
}

private fun writeLayerValues(
  grid: Array<IntArray>,
  top: Int,
  bottom: Int,
  left: Int,
  right: Int,
  layerValues: List<Int>,
  rotation: Int,
) {
  var valueIndex = 0

  for (column in left..right) {
    grid[top][column] = layerValues[(valueIndex + rotation) % layerValues.size]
    valueIndex += 1
  }

  for (row in top + 1 until bottom) {
    grid[row][right] = layerValues[(valueIndex + rotation) % layerValues.size]
    valueIndex += 1
  }

  for (column in right downTo left) {
    grid[bottom][column] = layerValues[(valueIndex + rotation) % layerValues.size]
    valueIndex += 1
  }

  for (row in bottom - 1 downTo top + 1) {
    grid[row][left] = layerValues[(valueIndex + rotation) % layerValues.size]
    valueIndex += 1
  }
}
