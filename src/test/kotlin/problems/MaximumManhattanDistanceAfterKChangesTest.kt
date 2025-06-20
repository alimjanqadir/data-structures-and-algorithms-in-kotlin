package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumManhattanDistanceAfterKChangesTest {
  @Test
  fun singleMoveNoEdit() {
    assertEquals(1, maxDistance("N", 0))
  }

  @Test
  fun twoMovesOneEdit() {
    assertEquals(2, maxDistance("NS", 1))
  }

  @Test
  fun fourMovesOneEdit() {
    assertEquals(3, maxDistance("NESW", 1))
  }

  @Test
  fun allNorthTwoEdits() {
    assertEquals(4, maxDistance("NNNN", 2))
  }
}
