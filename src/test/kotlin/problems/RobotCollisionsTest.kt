package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class RobotCollisionsTest {

  @Test
  fun testSurvivedRobotsHealthsExample1() {
    // Example 1 from LeetCode
    val positions = intArrayOf(5, 4, 3, 2, 1)
    val healths = intArrayOf(2, 17, 9, 15, 10)
    val directions = "RRRRR"

    // All moving right, no collisions
    assertEquals(listOf(2, 17, 9, 15, 10), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsExample2() {
    // Example 2 from LeetCode
    val positions = intArrayOf(3, 5, 2, 6)
    val healths = intArrayOf(10, 10, 15, 12)
    val directions = "RLRL"

    // Robot 1 (pos 5, R, health 10) collides with Robot 2 (pos 2, L, health 15)
    // After sorting by position: 2(L), 3(R), 5(R), 6(L)
    // Actually positions: 3(R), 5(R), 2(L), 6(L)
    // Sorted: 2(L-15), 3(R-10), 5(R-10), 6(L-12)
    // 3(R) meets 2(L): 10 vs 15, 3 dies, 2 becomes 14
    // Then 5(R) meets 2(L): 10 vs 14, 5 dies, 2 becomes 13
    // Then 6(L) is processed - no R robots in stack
    // Result: robot 2 (health 13) survives
    assertEquals(listOf(14), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsExample3() {
    // Example 3 from LeetCode
    val positions = intArrayOf(1, 2, 5, 6)
    val healths = intArrayOf(10, 10, 11, 11)
    val directions = "RLRL"

    // Sorted: 1(R-10), 2(L-10), 5(R-11), 6(L-11)
    // 1(R) meets 2(L): both 10, both die
    // 5(R) meets 6(L): both 11, both die
    // No survivors
    assertEquals(emptyList(), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsAllLeft() {
    // All moving left, no collisions
    val positions = intArrayOf(1, 2, 3, 4, 5)
    val healths = intArrayOf(10, 20, 30, 40, 50)
    val directions = "LLLLL"

    assertEquals(listOf(10, 20, 30, 40, 50), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsSingleRobot() {
    // Single robot
    val positions = intArrayOf(5)
    val healths = intArrayOf(10)
    val directions = "R"

    assertEquals(listOf(10), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsTwoRobotsCollideSameHealth() {
    // Two robots with same health collide
    val positions = intArrayOf(1, 2)
    val healths = intArrayOf(5, 5)
    val directions = "RL"

    assertEquals(emptyList(), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsTwoRobotsCollideDifferentHealth() {
    // Two robots with different health collide
    val positions = intArrayOf(1, 2)
    val healths = intArrayOf(5, 3)
    val directions = "RL"

    // Robot 0 wins with health 4
    assertEquals(listOf(4), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsChainCollision() {
    // Multiple collisions in chain
    val positions = intArrayOf(1, 3, 5)
    val healths = intArrayOf(10, 2, 5)
    val directions = "RRL"

    // Sorted: 1(R-10), 3(R-2), 5(L-5)
    // 3(R) and 5(L): 2 < 5, so 3 dies, 5 becomes 4
    // 1(R) and 5(L): 10 > 4, so 5 dies, 1 becomes 9
    // Result: robot 0 with health 9
    assertEquals(listOf(9), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsUnsortedPositions() {
    // Unsorted positions
    val positions = intArrayOf(10, 5, 15, 3)
    val healths = intArrayOf(5, 10, 8, 12)
    val directions = "RLRL"

    // Sorted: 3(R-12), 5(L-10), 10(R-5), 15(L-8)
    // 3(R) meets 5(L): 12 > 10, 5 dies, 3 becomes 11
    // 10(R) meets nothing (no L in stack after processing 15)
    // Actually 10(R) stays, then 15(L) comes
    // 10(R) meets 15(L): 5 < 8, 10 dies, 15 becomes 7
    // But 3(R) is still in stack... let me trace again
    // Stack after 3(R): [3]
    // 5(L) collides with 3: 3 wins with 11, stack: [3(11)]
    // 10(R) added: [3(11), 10]
    // 15(L) collides with 10: 5 < 8, 10 dies, 15 becomes 7
    // 15(L) collides with 3(11): 7 < 11, 15 dies, 3 becomes 10
    // Result: robot 3 (original index 3) with health 10
    assertEquals(listOf(10), survivedRobotsHealths(positions, healths, directions))
  }

  @Test
  fun testSurvivedRobotsHealthsNoSurvivors() {
    // All robots destroy each other
    val positions = intArrayOf(1, 2, 3, 4)
    val healths = intArrayOf(1, 1, 1, 1)
    val directions = "RLRL"

    // 1(R) meets 2(L): both die
    // 3(R) meets 4(L): both die
    assertEquals(emptyList(), survivedRobotsHealths(positions, healths, directions))
  }
}
