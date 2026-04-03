package problems

/**
 * 3661. Maximum Walls Destroyed by Robots
 * LeetCode problem: Hard
 *
 * Returns the maximum number of unique walls that can be destroyed by robots.
 * Uses dynamic programming to determine optimal firing directions.
 *
 * Time Complexity: O((n + m) log n) where n is number of robots and m is number of walls
 * Space Complexity: O(n + m)
 *
 * @param robots Array of robot positions
 * @param distance Array of maximum bullet travel distances for each robot
 * @param walls Array of wall positions
 * @return Maximum number of walls that can be destroyed
 */
fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
  val n = robots.size

  val order = robots.indices.sortedBy { robots[it] }
  val positions = LongArray(n)
  val ranges = LongArray(n)
  for (index in order.indices) {
    val originalIndex = order[index]
    positions[index] = robots[originalIndex].toLong()
    ranges[index] = distance[originalIndex].toLong()
  }

  val robotPositions = HashSet<Long>()
  for (position in positions) {
    robotPositions.add(position)
  }

  val remainingWallsList = ArrayList<Long>()
  var fixedWalls = 0
  for (wall in walls) {
    val wallPosition = wall.toLong()
    if (robotPositions.contains(wallPosition)) {
      fixedWalls += 1
    } else {
      remainingWallsList.add(wallPosition)
    }
  }

  remainingWallsList.sort()
  val remainingWalls = LongArray(remainingWallsList.size)
  for (index in remainingWallsList.indices) {
    remainingWalls[index] = remainingWallsList[index]
  }

  fun lowerBound(array: LongArray, target: Long): Int {
    var left = 0
    var right = array.size
    while (left < right) {
      val middle = (left + right) ushr 1
      if (array[middle] < target) {
        left = middle + 1
      } else {
        right = middle
      }
    }
    return left
  }

  fun countInRange(array: LongArray, leftValue: Long, rightValue: Long): Int {
    if (leftValue > rightValue) {
      return 0
    }
    val start = lowerBound(array, leftValue)
    val end = lowerBound(array, rightValue + 1L)
    return end - start
  }

  val outerLeft = countInRange(
    remainingWalls,
    positions[0] - ranges[0],
    positions[0] - 1L
  )

  val outerRight = countInRange(
    remainingWalls,
    positions[n - 1] + 1L,
    positions[n - 1] + ranges[n - 1]
  )

  var dp = IntArray(2) { Int.MIN_VALUE / 4 }
  dp[0] = outerLeft
  dp[1] = 0

  for (index in 0 until n - 1) {
    val leftRobotPosition = positions[index]
    val rightRobotPosition = positions[index + 1]
    val leftRobotRange = ranges[index]
    val rightRobotRange = ranges[index + 1]

    val leftReach = countInRange(
      remainingWalls,
      leftRobotPosition + 1L,
      minOf(leftRobotPosition + leftRobotRange, rightRobotPosition - 1L)
    )

    val rightReach = countInRange(
      remainingWalls,
      maxOf(rightRobotPosition - rightRobotRange, leftRobotPosition + 1L),
      rightRobotPosition - 1L
    )

    val overlap = countInRange(
      remainingWalls,
      maxOf(leftRobotPosition + 1L, rightRobotPosition - rightRobotRange),
      minOf(leftRobotPosition + leftRobotRange, rightRobotPosition - 1L)
    )

    val nextDp = IntArray(2) { Int.MIN_VALUE / 4 }

    // current = left (0), next = left (0)
    nextDp[0] = maxOf(nextDp[0], dp[0] + rightReach)

    // current = left (0), next = right (1)
    nextDp[1] = maxOf(nextDp[1], dp[0])

    // current = right (1), next = left (0)
    nextDp[0] = maxOf(nextDp[0], dp[1] + leftReach + rightReach - overlap)

    // current = right (1), next = right (1)
    nextDp[1] = maxOf(nextDp[1], dp[1] + leftReach)

    dp = nextDp
  }

  val bestWithoutFixedWalls = maxOf(dp[0], dp[1] + outerRight)
  return fixedWalls + bestWithoutFixedWalls
}
