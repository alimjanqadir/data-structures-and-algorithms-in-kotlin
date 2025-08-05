package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumOfUnplacedFruitsTest {
  @Test
  fun example1() {
    val fruits = intArrayOf(1, 2, 3)
    val baskets = intArrayOf(3, 2, 1)
    assertEquals(1, numOfUnplacedFruits(fruits, baskets))
  }

  @Test
  fun insufficientCapacity() {
    val fruits = intArrayOf(4, 5)
    val baskets = intArrayOf(3, 3)
    assertEquals(2, numOfUnplacedFruits(fruits, baskets))
  }

  @Test
  fun someUnplaced() {
    val fruits = intArrayOf(1, 2, 2)
    val baskets = intArrayOf(2, 3)
    assertEquals(1, numOfUnplacedFruits(fruits, baskets))
  }
}

