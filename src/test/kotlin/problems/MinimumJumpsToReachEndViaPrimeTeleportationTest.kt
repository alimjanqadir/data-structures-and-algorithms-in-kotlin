package problems

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumJumpsToReachEndViaPrimeTeleportationTest {
  @Test
  fun returnsZeroForSingleIndex() {
    assertEquals(0, minJumps(intArrayOf(1)))
  }

  @Test
  fun teleportsFromPrimeValueToDivisibleEndIndex() {
    assertEquals(1, minJumps(intArrayOf(2, 3, 4)))
  }

  @Test
  fun usesPrimeTeleportationInShortestPath() {
    assertEquals(2, minJumps(intArrayOf(5, 10, 15, 7)))
  }

  @Test
  fun movesAdjacentWhenNoPrimeValuedTeleportHelps() {
    assertEquals(3, minJumps(intArrayOf(4, 6, 15, 35)))
  }
}
