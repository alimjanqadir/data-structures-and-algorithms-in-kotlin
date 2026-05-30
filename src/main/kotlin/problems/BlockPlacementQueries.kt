package problems

import java.util.TreeSet
import kotlin.math.max

fun getResults(queries: Array<IntArray>): List<Boolean> {
  var maxCoordinate = 0
  for (query in queries) {
    maxCoordinate = max(maxCoordinate, query[1])
  }

  val obstaclePositions = TreeSet<Int>()
  obstaclePositions.add(0)

  val segmentTree = BlockPlacementSegmentTree(maxCoordinate)
  val answers = ArrayList<Boolean>()

  for (query in queries) {
    if (query[0] == 1) {
      val obstaclePosition = query[1]
      val previousObstacle = obstaclePositions.lower(obstaclePosition) ?: 0
      val nextObstacle = obstaclePositions.higher(obstaclePosition)

      obstaclePositions.add(obstaclePosition)
      segmentTree.updatePoint(obstaclePosition, obstaclePosition - previousObstacle)

      if (nextObstacle != null) {
        segmentTree.updatePoint(nextObstacle, nextObstacle - obstaclePosition)
      }
    } else {
      val rightBoundary = query[1]
      val blockSize = query[2]
      val previousObstacle = obstaclePositions.floor(rightBoundary) ?: 0
      val tailGap = rightBoundary - previousObstacle
      val bestGapEndingAtObstacle = segmentTree.queryPrefixMaximum(rightBoundary)

      answers.add(max(bestGapEndingAtObstacle, tailGap) >= blockSize)
    }
  }

  return answers
}

private class BlockPlacementSegmentTree(maxCoordinate: Int) {
  private val size: Int
  private val tree: IntArray

  init {
    var treeSize = 1
    while (treeSize <= maxCoordinate + 2) {
      treeSize *= 2
    }
    size = treeSize
    tree = IntArray(size * 2)
  }

  fun updatePoint(position: Int, value: Int) {
    var index = position + size
    tree[index] = value
    index /= 2

    while (index >= 1) {
      tree[index] = max(tree[index * 2], tree[index * 2 + 1])
      index /= 2
    }
  }

  fun queryPrefixMaximum(rightBoundary: Int): Int {
    if (rightBoundary <= 0) {
      return 0
    }

    var leftIndex = size + 1
    var rightIndex = size + rightBoundary
    var bestValue = 0

    while (leftIndex <= rightIndex) {
      if ((leftIndex and 1) == 1) {
        bestValue = max(bestValue, tree[leftIndex])
        leftIndex += 1
      }
      if ((rightIndex and 1) == 0) {
        bestValue = max(bestValue, tree[rightIndex])
        rightIndex -= 1
      }
      leftIndex /= 2
      rightIndex /= 2
    }

    return bestValue
  }
}
