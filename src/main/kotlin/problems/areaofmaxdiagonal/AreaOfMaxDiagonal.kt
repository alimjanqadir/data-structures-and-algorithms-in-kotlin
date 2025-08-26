package problems.areaofmaxdiagonal

class Solution {
  fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
    var bestDiagonalSquared = -1
    var bestArea = 0

    for (sizePair in dimensions) {
      val length = sizePair[0]
      val width = sizePair[1]

      val diagonalSquared = length * length + width * width
      val area = length * width

      if (diagonalSquared > bestDiagonalSquared ||
        (diagonalSquared == bestDiagonalSquared && area > bestArea)
      ) {
        bestDiagonalSquared = diagonalSquared
        bestArea = area
      }
    }
    return bestArea
  }
}
