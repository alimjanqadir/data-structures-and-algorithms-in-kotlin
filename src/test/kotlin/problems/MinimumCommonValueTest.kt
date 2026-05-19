package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class MinimumCommonValueTest {

  @Test
  fun testGetCommon() {
    assertEquals(2, getCommon(intArrayOf(1, 2, 3, 6), intArrayOf(2, 3, 4, 5)))
    assertEquals(2, getCommon(intArrayOf(1, 2, 3), intArrayOf(2, 4)))
    assertEquals(3, getCommon(intArrayOf(1, 2, 3), intArrayOf(3, 4, 5)))
    assertEquals(-1, getCommon(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)))
    assertEquals(1, getCommon(intArrayOf(1, 1, 2), intArrayOf(1, 3, 4)))
  }
}
