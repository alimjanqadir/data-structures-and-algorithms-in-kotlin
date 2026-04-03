package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MaxWallsDestroyedByRobotsTest {

  @Test
  fun testMaxWallsBasicCase() {
    // Basic test with 2 robots and walls in range
    val robots = intArrayOf(0, 10)
    val distance = intArrayOf(5, 5)
    val walls = intArrayOf(2, 5, 8, 12, 15)

    // Robot at 0 can reach 2, 5 (distance 5)
    // Robot at 10 can reach 8 (distance 5 to left), or 12, 15 (distance 5 to right)
    // Max walls: 3 (2, 5 from left robot, 8 from right robot shooting left, OR 12, 15 from right shooting right)
    assertEquals(3, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsSamePosition() {
    // Wall at same position as robot
    val robots = intArrayOf(5)
    val distance = intArrayOf(3)
    val walls = intArrayOf(5, 6, 7)

    // Wall at 5 is automatically destroyed (same position)
    // Robot can destroy 6, 7 (distance 3)
    assertEquals(3, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsNoWalls() {
    // No walls to destroy
    val robots = intArrayOf(1, 2, 3)
    val distance = intArrayOf(5, 5, 5)
    val walls = intArrayOf()

    assertEquals(0, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsOutOfRange() {
    // All walls out of range
    val robots = intArrayOf(0)
    val distance = intArrayOf(5)
    val walls = intArrayOf(10, 20, 30)

    assertEquals(0, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsSingleRobot() {
    // Single robot
    val robots = intArrayOf(5)
    val distance = intArrayOf(10)
    val walls = intArrayOf(0, 3, 7, 10, 15)

    // Can destroy walls at 0, 3, 7, 10 (within distance 10)
    // 15 is out of range (distance 10 from 5 = 15, but need 5+10=15, wall at 15 is at boundary)
    assertEquals(4, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsMultipleRobotsNonOverlapping() {
    // Multiple robots with non-overlapping ranges
    val robots = intArrayOf(0, 20)
    val distance = intArrayOf(5, 5)
    val walls = intArrayOf(3, 4, 5, 15, 18, 25)

    // Robot at 0 can reach 3, 4, 5
    // Robot at 20 can reach 15, 18, 25 (to left: 15, 18; to right: 25)
    // Best: left robot shoots right (3 walls), right robot shoots left (2 walls: 15, 18) OR right (1 wall: 25)
    // Total: 3 + 2 = 5
    assertEquals(5, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsBulletBlockedByRobot() {
    // Bullet stops at another robot
    val robots = intArrayOf(0, 5)
    val distance = intArrayOf(10, 10)
    val walls = intArrayOf(3, 7, 8, 9)

    // Robot at 0 shooting right can reach 3 (but stops at robot at 5)
    // Actually bullet stops at robot at 5, so can only reach 3
    // Robot at 5 shooting right can reach 7, 8, 9
    // Robot at 5 shooting left can reach 3 (but stops at robot at 0)
    // Robot at 0 shooting left: nothing
    assertEquals(4, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsAllRobotsAtSameWallPosition() {
    // Multiple robots at same position as wall
    val robots = intArrayOf(5, 5, 10)
    val distance = intArrayOf(3, 3, 3)
    val walls = intArrayOf(5, 6, 7, 8, 10)

    // Wall at 5 automatically destroyed (count once even if multiple robots there)
    // Wall at 10 automatically destroyed
    assertEquals(5, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsOptimalDirectionChoice() {
    // Test that robots choose optimal firing direction
    val robots = intArrayOf(0, 10)
    val distance = intArrayOf(10, 10)
    val walls = intArrayOf(5, 8, 12, 15, 18)

    // Robot at 0: can hit 5, 8 (right) or nothing (left)
    // Robot at 10: can hit 5, 8 (left) or 12, 15, 18 (right)
    // If both shoot toward middle: 5, 8 counted once = 2 walls
    // If left shoots right, right shoots right: 5, 8, 12, 15, 18 = 5 walls
    assertEquals(5, maxWalls(robots, distance, walls))
  }

  @Test
  fun testMaxWallsAdjacentRobots() {
    // Adjacent robots
    val robots = intArrayOf(1, 2)
    val distance = intArrayOf(5, 5)
    val walls = intArrayOf(0, 3, 4, 5, 6, 7)

    // Robots at 1 and 2
    // Robot 1 left: 0; right: 3, 4, 5, 6 (stops at robot 2 at position 2... wait 2 is position of robot 2)
    // Actually robot at 2 blocks bullets from robot at 1 going right at position 2
    // So robot 1 right: nothing (robot 2 at position 2 blocks)
    // Robot 1 left: 0
    // Robot 2 left: nothing (robot 1 at 1 blocks)
    // Robot 2 right: 3, 4, 5, 6, 7
    assertEquals(6, maxWalls(robots, distance, walls))
  }
}
