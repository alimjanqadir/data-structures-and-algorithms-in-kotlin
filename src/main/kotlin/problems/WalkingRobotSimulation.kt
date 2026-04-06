package problems

/**
 * 874. Walking Robot Simulation
 * LeetCode problem: Medium
 *
 * Simulates a robot walking on an infinite XY-plane with obstacles.
 * Returns the maximum squared Euclidean distance from origin.
 *
 * Time Complexity: O(N + M) where N is number of commands and M is number of obstacles
 * Space Complexity: O(M) for the obstacle set
 *
 * @param commands Array of commands: -2=left, -1=right, 1-9=move forward
 * @param obstacles Array of obstacle positions [x, y]
 * @return Maximum squared distance from origin
 */
fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
  val obstacleSet = HashSet<Long>()

  for (obstacle in obstacles) {
    val encoded = obstacle[0].toLong() * 60001 + obstacle[1]
    obstacleSet.add(encoded)
  }

  val directions = arrayOf(
    intArrayOf(0, 1),   // North
    intArrayOf(1, 0),   // East
    intArrayOf(0, -1),  // South
    intArrayOf(-1, 0)   // West
  )

  var currentX = 0
  var currentY = 0
  var directionIndex = 0
  var maxDistanceSquared = 0

  for (command in commands) {
    if (command == -1) {
      directionIndex = (directionIndex + 1) % 4
    } else if (command == -2) {
      directionIndex = (directionIndex + 3) % 4
    } else {
      repeat(command) {
        val nextX = currentX + directions[directionIndex][0]
        val nextY = currentY + directions[directionIndex][1]

        val encoded = nextX.toLong() * 60001 + nextY
        if (obstacleSet.contains(encoded)) {
          return@repeat
        }

        currentX = nextX
        currentY = nextY

        val distanceSquared = currentX * currentX + currentY * currentY
        if (distanceSquared > maxDistanceSquared) {
          maxDistanceSquared = distanceSquared
        }
      }
    }
  }

  return maxDistanceSquared
}
