import java.util.ArrayDeque
import java.util.Deque
import java.util.TreeSet

fun minOperations(binaryString: String, windowSize: Int): Int {
  val stringLength = binaryString.length
  val initialZeroCount = binaryString.count { character ->
    character == '0'
  }

  if (initialZeroCount == 0) {
    return 0
  }

  val unvisitedZeroCountsByParity = Array(2) {_ ->
    TreeSet<Int>()
  }

  for (zeroCount in 0..stringLength) {
    unvisitedZeroCountsByParity[zeroCount % 2].add(zeroCount)
  }

  val breadthFirstQueue: Deque<Int> = ArrayDeque<Int>()
  val distanceToZeroCount = IntArray(stringLength + 1) { -1 }

  breadthFirstQueue.offer(initialZeroCount)
  distanceToZeroCount[initialZeroCount] = 0
  unvisitedZeroCountsByParity[initialZeroCount % 2]
    .remove(initialZeroCount)

  while (breadthFirstQueue.isNotEmpty()) {

    val currentZeroCount = breadthFirstQueue.poll()
    val currentDistance =
      distanceToZeroCount[currentZeroCount]

    val minimumFlippedZeros =
      maxOf(0, windowSize - (stringLength - currentZeroCount))

    val maximumFlippedZeros =
      minOf(windowSize, currentZeroCount)

    val smallestNextZeroCount =
      currentZeroCount + windowSize - 2 * maximumFlippedZeros.toInt()

    val largestNextZeroCount =
      currentZeroCount + windowSize - 2 * minimumFlippedZeros.toInt()

    val requiredParity =
      (currentZeroCount + windowSize) % 2

    val candidateZeroCounts =
      unvisitedZeroCountsByParity[requiredParity]

    var nextZeroCount =
      candidateZeroCounts.ceiling(smallestNextZeroCount)

    while (
      nextZeroCount != null &&
      nextZeroCount <= largestNextZeroCount.toInt()
    ) {
      distanceToZeroCount[nextZeroCount] =
        currentDistance + 1

      if (nextZeroCount == 0) {
        return distanceToZeroCount[nextZeroCount]
      }

      breadthFirstQueue.offer(nextZeroCount)
      candidateZeroCounts.remove(nextZeroCount)

      nextZeroCount =
        candidateZeroCounts.ceiling(smallestNextZeroCount)
    }
  }

  return -1
}
