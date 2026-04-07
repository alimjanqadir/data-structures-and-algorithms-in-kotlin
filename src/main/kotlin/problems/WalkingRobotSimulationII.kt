package problems

/**
 * 2069. Walking Robot Simulation II
 * LeetCode problem: Medium
 *
 * A robot moves on a width x height grid perimeter.
 * The robot starts at (0, 0) facing East and moves along the perimeter.
 *
 * Time Complexity: O(1) for step, getPos, and getDir operations
 * Space Complexity: O(1)
 *
 * @param width Width of the grid
 * @param height Height of the grid
 */
class Robot(private val width: Int, private val height: Int) {

  private val perimeterLength = 2 * (width + height) - 4
  private var stepsTakenOnCycle = 0

  /**
   * Instructs the robot to move forward num steps.
   * The robot moves along the perimeter of the grid.
   *
   * @param num Number of steps to move
   */
  fun step(num: Int) {
    if (perimeterLength == 0) return

    stepsTakenOnCycle = (stepsTakenOnCycle + num) % perimeterLength

    // Handle full cycle case → lands at (0,0) facing South
    if (stepsTakenOnCycle == 0 && num > 0) {
      stepsTakenOnCycle = perimeterLength
    }
  }

  /**
   * Returns the current position of the robot.
   *
   * @return IntArray of [x, y] coordinates
   */
  fun getPos(): IntArray {
    var remainingSteps = stepsTakenOnCycle

    // Bottom edge (→ East)
    if (remainingSteps <= width - 1) {
      return intArrayOf(remainingSteps, 0)
    }
    remainingSteps -= (width - 1)

    // Right edge (↑ North)
    if (remainingSteps <= height - 1) {
      return intArrayOf(width - 1, remainingSteps)
    }
    remainingSteps -= (height - 1)

    // Top edge (← West)
    if (remainingSteps <= width - 1) {
      return intArrayOf(width - 1 - remainingSteps, height - 1)
    }
    remainingSteps -= (width - 1)

    // Left edge (↓ South)
    return intArrayOf(0, height - 1 - remainingSteps)
  }

  /**
   * Returns the current direction of the robot.
   *
   * @return Direction as String: "North", "East", "South", or "West"
   */
  fun getDir(): String {
    if (stepsTakenOnCycle == 0) return "East"

    var remainingSteps = stepsTakenOnCycle

    // Bottom edge
    if (remainingSteps <= width - 1) return "East"
    remainingSteps -= (width - 1)

    // Right edge
    if (remainingSteps <= height - 1) return "North"
    remainingSteps -= (height - 1)

    // Top edge
    if (remainingSteps <= width - 1) return "West"
    remainingSteps -= (width - 1)

    // Left edge
    return "South"
  }
}
