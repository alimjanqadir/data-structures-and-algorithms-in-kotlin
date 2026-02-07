package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindClosestTest {

  @Test
  fun testPerson1Closer() {
    assertEquals(1, findClosest(1, 4, 2))
  }

  @Test
  fun testPerson2Closer() {
    assertEquals(2, findClosest(5, 1, 2))
  }

  @Test
  fun testBothSameDistance() {
    assertEquals(0, findClosest(2, 4, 3))
  }
}
