package problems

/**
 * 2751. Robot Collisions
 * LeetCode problem: Hard
 *
 * Determines the health of robots that survive collisions.
 * Uses a stack-based approach to simulate collisions between robots moving in opposite directions.
 *
 * Time Complexity: O(n log n) due to sorting, where n is the number of robots
 * Space Complexity: O(n) for the stack and result storage
 *
 * @param positions Array of robot positions
 * @param healths Array of robot healths
 * @param directions String containing 'L' or 'R' for each robot's direction
 * @return List of healths of surviving robots in original order
 */
fun survivedRobotsHealths(
  positions: IntArray,
  healths: IntArray,
  directions: String
): List<Int> {
  val robotCount = positions.size

  data class Robot(
    val position: Int,
    val originalIndex: Int,
    var health: Int,
    val direction: Char
  )

  val robots = ArrayList<Robot>(robotCount)
  for (robotIndex in 0 until robotCount) {
    robots.add(
      Robot(
        position = positions[robotIndex],
        originalIndex = robotIndex,
        health = healths[robotIndex],
        direction = directions[robotIndex]
      )
    )
  }

  robots.sortBy { it.position }

  val rightMovingStack = ArrayDeque<Robot>()

  for (currentRobot in robots) {
    if (currentRobot.direction == 'R') {
      rightMovingStack.addLast(currentRobot)
      continue
    }

    var currentHealth = currentRobot.health
    var currentRobotAlive = true

    while (currentRobotAlive && rightMovingStack.isNotEmpty()) {
      val previousRobot = rightMovingStack.last()

      when {
        previousRobot.health < currentHealth -> {
          rightMovingStack.removeLast()
          currentHealth -= 1
          previousRobot.health = 0
        }
        previousRobot.health == currentHealth -> {
          rightMovingStack.removeLast()
          previousRobot.health = 0
          currentHealth = 0
          currentRobotAlive = false
        }
        else -> {
          previousRobot.health -= 1
          currentHealth = 0
          currentRobotAlive = false
        }
      }
    }

    if (currentRobotAlive) {
      currentRobot.health = currentHealth
    } else {
      currentRobot.health = 0
    }
  }

  val survivorsByOriginalOrder = IntArray(robotCount)
  for (robot in robots) {
    survivorsByOriginalOrder[robot.originalIndex] = robot.health
  }

  val result = ArrayList<Int>()
  for (robotIndex in 0 until robotCount) {
    if (survivorsByOriginalOrder[robotIndex] > 0) {
      result.add(survivorsByOriginalOrder[robotIndex])
    }
  }

  return result
}
