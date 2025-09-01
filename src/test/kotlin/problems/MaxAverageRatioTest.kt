package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaxAverageRatioTest {
  @Test
  fun example1() {
    val classes = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(2, 2))
    val extra = 2
    assertEquals(0.78333, maxAverageRatio(classes, extra), 1e-5)
  }

  @Test
  fun example2() {
    val classes = arrayOf(intArrayOf(2, 4), intArrayOf(3, 9), intArrayOf(4, 5), intArrayOf(2, 10))
    val extra = 4
    assertEquals(0.53485, maxAverageRatio(classes, extra), 1e-5)
  }
}

