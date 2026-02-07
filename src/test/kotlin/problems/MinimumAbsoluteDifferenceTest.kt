package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class MinimumAbsoluteDifferenceTest {
  @Test
  fun basicExample() {
    val arr = intArrayOf(4, 2, 1, 3)
    val expected = listOf(
      listOf(1, 2),
      listOf(2, 3),
      listOf(3, 4),
    )
    assertContentEquals(expected, minimumAbsDifference(arr))
  }

  @Test
  fun increasingArray() {
    val arr = intArrayOf(1, 3, 6, 10, 15)
    val expected = listOf(listOf(1, 3))
    assertContentEquals(expected, minimumAbsDifference(arr))
  }
}

