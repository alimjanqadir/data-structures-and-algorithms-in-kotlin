package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CountTheNumberOfArraysWithKMatchingAdjacentElementsTest {
  @Test
  fun example1() {
    assertEquals(4, countGoodArrays(3, 2, 1))
  }

  @Test
  fun example2() {
    assertEquals(6, countGoodArrays(4, 2, 2))
  }

  @Test
  fun example3() {
    assertEquals(2, countGoodArrays(5, 2, 0))
  }
}
