package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountUnguardedCellsInTheGridTest {
  @Test
  fun exampleFromLeetCode() {
    val guards = arrayOf(
      intArrayOf(0, 0),
      intArrayOf(1, 1),
      intArrayOf(2, 3),
    )
    val walls = arrayOf(
      intArrayOf(0, 1),
      intArrayOf(2, 2),
      intArrayOf(1, 4),
    )
    assertEquals(7, countUnguarded(4, 6, guards, walls))
  }

  @Test
  fun singleGuardSurroundedByWalls() {
    val guards = arrayOf(intArrayOf(1, 1))
    val walls = arrayOf(
      intArrayOf(0, 1),
      intArrayOf(1, 0),
      intArrayOf(2, 1),
      intArrayOf(1, 2),
    )
    assertEquals(4, countUnguarded(3, 3, guards, walls))
  }
}

