package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SmallestXorXPlusOneTest {
  @Test
  fun examplesFromDocumentation() {
    val input = listOf(3, 7, 15)
    val expected = intArrayOf(1, 3, 7)
    assertContentEquals(expected, smallestXorXPlusOne(input))
  }

  @Test
  fun evenNumbersHaveNoSolution() {
    val input = listOf(2, 4, 6)
    val expected = intArrayOf(-1, -1, -1)
    assertContentEquals(expected, smallestXorXPlusOne(input))
  }
}

