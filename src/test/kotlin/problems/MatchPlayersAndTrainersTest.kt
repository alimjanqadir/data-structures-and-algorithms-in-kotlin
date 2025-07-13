package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MatchPlayersAndTrainersTest {
  @Test
  fun example1() {
    val players = intArrayOf(4, 7, 9)
    val trainers = intArrayOf(8, 2, 5, 8)
    assertEquals(2, matchPlayersAndTrainers(players, trainers))
  }

  @Test
  fun example2() {
    val players = intArrayOf(1, 1, 1)
    val trainers = intArrayOf(10)
    assertEquals(1, matchPlayersAndTrainers(players, trainers))
  }
}
