package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BlockPlacementQueriesTest {
  @Test
  fun exampleWithSingleObstacle() {
    val queries = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(2, 3, 3),
      intArrayOf(2, 3, 1),
      intArrayOf(2, 2, 2)
    )

    assertEquals(listOf(false, true, true), getResults(queries))
  }

  @Test
  fun updatesSplitExistingSegments() {
    val queries = arrayOf(
      intArrayOf(1, 7),
      intArrayOf(2, 7, 6),
      intArrayOf(1, 2),
      intArrayOf(2, 7, 5),
      intArrayOf(2, 7, 6)
    )

    assertEquals(listOf(true, true, false), getResults(queries))
  }

  @Test
  fun rightBoundaryAtObstacleDoesNotCountTailThroughObstacle() {
    val queries = arrayOf(
      intArrayOf(1, 4),
      intArrayOf(1, 7),
      intArrayOf(2, 7, 4),
      intArrayOf(2, 7, 5)
    )

    assertEquals(listOf(true, false), getResults(queries))
  }
}
