package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaximumNumberOfJumpsToReachTheLastIndexTest {
  @Test
  fun example1() {
    assertEquals(3, maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 2))
  }

  @Test
  fun example2() {
    assertEquals(5, maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 3))
  }

  @Test
  fun example3() {
    assertEquals(-1, maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 0))
  }

  @Test
  fun handlesDuplicateValues() {
    assertEquals(2, maximumJumps(intArrayOf(0, 5, 0), 5))
  }

  @Test
  fun handlesLargeValueBounds() {
    assertEquals(1, maximumJumps(intArrayOf(Int.MIN_VALUE, -1), Int.MAX_VALUE))
  }
}
