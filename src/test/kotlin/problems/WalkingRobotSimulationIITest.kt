package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class WalkingRobotSimulationIITest {

  @Test
  fun testRobotExample1() {
    val robot = Robot(6, 3)

    robot.step(2)
    robot.step(2)
    assertContentEquals(intArrayOf(4, 0), robot.getPos())
    assertEquals("East", robot.getDir())

    robot.step(2)
    assertContentEquals(intArrayOf(4, 2), robot.getPos())
    assertEquals("North", robot.getDir())

    robot.step(1)
    assertContentEquals(intArrayOf(1, 2), robot.getPos())
    assertEquals("West", robot.getDir())

    robot.step(4)
    assertContentEquals(intArrayOf(1, 0), robot.getPos())
    assertEquals("South", robot.getDir())
  }

  @Test
  fun testRobotFullCycle() {
    val robot = Robot(2, 2)
    // Perimeter: (0,0) → (1,0) → (1,1) → (0,1) → back to (0,0)

    assertContentEquals(intArrayOf(0, 0), robot.getPos())
    assertEquals("East", robot.getDir())

    robot.step(4) // Full cycle
    assertContentEquals(intArrayOf(0, 0), robot.getPos())
    // After full cycle at origin, should face South
    assertEquals("South", robot.getDir())
  }

  @Test
  fun testRobotSingleCell() {
    val robot = Robot(1, 1)
    // Only one cell, no movement possible

    robot.step(10)
    assertContentEquals(intArrayOf(0, 0), robot.getPos())
    assertEquals("East", robot.getDir())
  }

  @Test
  fun testRobotMoveAlongBottomEdge() {
    val robot = Robot(5, 3)

    robot.step(3)
    assertContentEquals(intArrayOf(3, 0), robot.getPos())
    assertEquals("East", robot.getDir())
  }

  @Test
  fun testRobotTurnAtCorner() {
    val robot = Robot(3, 3)

    robot.step(2) // Reach corner (2, 0)
    assertContentEquals(intArrayOf(2, 0), robot.getPos())
    assertEquals("East", robot.getDir())

    robot.step(1) // Move up
    assertContentEquals(intArrayOf(2, 1), robot.getPos())
    assertEquals("North", robot.getDir())
  }

  @Test
  fun testRobotMultipleCycles() {
    val robot = Robot(3, 3)
    // Perimeter length: 2*(3+3) - 4 = 8

    robot.step(16) // Two full cycles
    assertContentEquals(intArrayOf(0, 0), robot.getPos())
    assertEquals("South", robot.getDir())
  }

  @Test
  fun testRobotLargeStep() {
    val robot = Robot(6, 3)

    robot.step(100) // Large step, should wrap around
    // Perimeter = 2*(6+3) - 4 = 14
    // 100 % 14 = 2
    assertContentEquals(intArrayOf(2, 0), robot.getPos())
    assertEquals("East", robot.getDir())
  }
}
