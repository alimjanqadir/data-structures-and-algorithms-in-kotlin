package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TotalFruitTest {
  @Test
  fun example1() {
    val fruits = intArrayOf(1, 2, 1)
    assertEquals(3, totalFruit(fruits))
  }

  @Test
  fun example2() {
    val fruits = intArrayOf(0, 1, 2, 2)
    assertEquals(3, totalFruit(fruits))
  }

  @Test
  fun example3() {
    val fruits = intArrayOf(1, 2, 3, 2, 2)
    assertEquals(4, totalFruit(fruits))
  }

  @Test
  fun singleFruit() {
    val fruits = intArrayOf(0)
    assertEquals(1, totalFruit(fruits))
  }
}
