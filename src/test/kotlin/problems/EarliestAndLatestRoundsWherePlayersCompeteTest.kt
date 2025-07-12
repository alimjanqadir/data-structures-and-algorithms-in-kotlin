package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class EarliestAndLatestRoundsWherePlayersCompeteTest {
  @Test
  fun example1() {
    val result = earliestAndLatest(11, 2, 4)
    assertContentEquals(intArrayOf(3, 4), result)
  }

  @Test
  fun example2() {
    val result = earliestAndLatest(5, 1, 5)
    assertContentEquals(intArrayOf(1, 1), result)
  }
}
