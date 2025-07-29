package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SmallestSubarraysWithMaximumBitwiseOrTest {
  @Test
  fun example1() {
    val nums = intArrayOf(1, 0, 2, 1, 3)
    val expected = intArrayOf(3, 3, 2, 2, 1)
    assertContentEquals(expected, smallestSubarrays(nums))
  }

  @Test
  fun example2() {
    val nums = intArrayOf(1, 2)
    val expected = intArrayOf(2, 1)
    assertContentEquals(expected, smallestSubarrays(nums))
  }

  @Test
  fun singleElement() {
    val nums = intArrayOf(8)
    val expected = intArrayOf(1)
    assertContentEquals(expected, smallestSubarrays(nums))
  }
}

