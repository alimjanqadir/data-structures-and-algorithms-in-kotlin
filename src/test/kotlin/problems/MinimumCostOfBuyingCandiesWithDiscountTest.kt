package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumCostOfBuyingCandiesWithDiscountTest {
  @Test
  fun exampleOne() {
    assertEquals(5, minimumCost(intArrayOf(1, 2, 3)))
  }

  @Test
  fun exampleTwo() {
    assertEquals(23, minimumCost(intArrayOf(6, 5, 7, 9, 2, 2)))
  }

  @Test
  fun exampleThree() {
    assertEquals(10, minimumCost(intArrayOf(5, 5)))
  }
}
