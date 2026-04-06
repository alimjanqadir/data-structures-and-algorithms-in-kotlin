package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class WalkingRobotSimulationTest {

  @Test
  fun testRobotSimExample1() {
    val commands = intArrayOf(4, -1, 3)
    val obstacles = arrayOf<IntArray>()

    // Robot goes north 4, turns right (east), goes east 3
    // Final position: (3, 4), distance squared = 9 + 16 = 25
    assertEquals(25, robotSim(commands, obstacles))
  }

  @Test
  fun testRobotSimExample2() {
    val commands = intArrayOf(4, -1, 4, -2, 4)
    val obstacles = arrayOf(intArrayOf(2, 4))

    // Robot goes north 4 to (0, 4), turns right (east), goes east 4
    // Hits obstacle at (2, 4), stops at (1, 4)
    // Turns left (north), goes north 4, blocked at (1, 4) same row
    // Actually after turning left from east, facing north
    // From (1, 4), goes north 4 but obstacle check for (1, 5), (1, 6), etc.
    // Wait, obstacle is at (2, 4), not in the path north
    // Let me re-trace: after turn left from east, facing north
    // Move 4 steps north: (1, 5), (1, 6), (1, 7), (1, 8)
    // Then turn left from north, facing west
    // Move 4 steps west: (0, 8), (-1, 8), (-2, 8), (-3, 8)
    // Max distance: (-3)^2 + 8^2 = 9 + 64 = 73... but expected is 65
    // Let me check: position before last command is (1, 8), dist = 1 + 64 = 65
    // After moving west 4: max is still 65
    assertEquals(65, robotSim(commands, obstacles))
  }

  @Test
  fun testRobotSimExample3() {
    val commands = intArrayOf(6, -1, -1, 6)
    val obstacles = arrayOf(intArrayOf(0, 1))

    // Robot goes north 6, but obstacle at (0, 1) blocks immediately
    // Stays at (0, 0), turns right (east), turns right (south)
    // Goes south 6: (0, -1), (0, -2), (0, -3), (0, -4), (0, -5), (0, -6)
    // Max distance: 0 + 36 = 36
    assertEquals(36, robotSim(commands, obstacles))
  }

  @Test
  fun testRobotSimNoCommands() {
    val commands = intArrayOf()
    val obstacles = arrayOf<IntArray>()

    assertEquals(0, robotSim(commands, obstacles))
  }

  @Test
  fun testRobotSimOnlyTurns() {
    val commands = intArrayOf(-1, -1, -1, -1)
    val obstacles = arrayOf<IntArray>()

    // 4 right turns = full circle, back at origin facing north
    assertEquals(0, robotSim(commands, obstacles))
  }

  @Test
  fun testRobotSimWithObstacles() {
    val commands = intArrayOf(2, 2, 2)
    val obstacles = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))

    // North 2: blocked at (0, 1), stays at (0, 0)
    // East 2: blocked at (1, 0), stays at (0, 0)
    // South 2: (0, -1), (0, -2)
    // Max distance: 0 + 4 = 4
    assertEquals(4, robotSim(commands, obstacles))
  }
}
