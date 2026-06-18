package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class SeparateTheDigitsInAnArrayTest {
  @Test
  fun `separates all digits from multi-digit numbers`() {
    val nums = intArrayOf(13, 25, 83, 77)
    val expected = intArrayOf(1, 3, 2, 5, 8, 3, 7, 7)

    assertContentEquals(expected, separateDigits(nums))
  }

  @Test
  fun `keeps single-digit numbers in order`() {
    val nums = intArrayOf(7, 1, 3, 9)
    val expected = intArrayOf(7, 1, 3, 9)

    assertContentEquals(expected, separateDigits(nums))
  }

  @Test
  fun `includes zeros inside numbers`() {
    val nums = intArrayOf(100, 20, 3)
    val expected = intArrayOf(1, 0, 0, 2, 0, 3)

    assertContentEquals(expected, separateDigits(nums))
  }
}
