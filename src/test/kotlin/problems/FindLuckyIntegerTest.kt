package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FindLuckyIntegerTest {
  @Test
  fun example1() {
    val arr = intArrayOf(2, 2, 3, 4)
    assertEquals(2, findLucky(arr))
  }

  @Test
  fun example2() {
    val arr = intArrayOf(1, 2, 2, 3, 3, 3)
    assertEquals(3, findLucky(arr))
  }

  @Test
  fun example3() {
    val arr = intArrayOf(2, 2, 2, 3, 3)
    assertEquals(-1, findLucky(arr))
  }
}
