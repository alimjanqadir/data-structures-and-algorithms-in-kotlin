package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MakeTheIntegerZeroTest {
  @Test
  fun examples() {
    assertEquals(1, makeTheIntegerZero(5, 3))
    assertEquals(2, makeTheIntegerZero(10, 3))
    assertEquals(3, makeTheIntegerZero(15, 2))
  }

  @Test
  fun noSolution() {
    assertEquals(-1, makeTheIntegerZero(1, 1))
    assertEquals(-1, makeTheIntegerZero(5, 2))
  }
}

