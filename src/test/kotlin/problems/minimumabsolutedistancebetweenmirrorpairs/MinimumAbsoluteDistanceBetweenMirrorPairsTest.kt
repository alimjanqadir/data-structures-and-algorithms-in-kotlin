package problems.minimumabsolutedistancebetweenmirrorpairs

import kotlin.test.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDistanceBetweenMirrorPairsTest {
  private val solution = MinimumAbsoluteDistanceBetweenMirrorPairs()

  @Test
  fun example1() {
    assertEquals(1, solution.minMirrorPairDistance(intArrayOf(12, 21, 45, 33, 54)))
  }

  @Test
  fun example2() {
    assertEquals(1, solution.minMirrorPairDistance(intArrayOf(120, 21)))
  }

  @Test
  fun example3() {
    assertEquals(-1, solution.minMirrorPairDistance(intArrayOf(21, 120)))
  }
}
