package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class JumpGameIXTest {
  @Test
  fun splitsWhenThereIsNoCrossingInversion() {
    val nums = intArrayOf(2, 1, 3, 5, 4)

    assertContentEquals(intArrayOf(2, 2, 3, 5, 5), maxValue(nums))
  }

  @Test
  fun connectsAcrossEveryCutWithDescendingValues() {
    val nums = intArrayOf(5, 4, 3, 2, 1)

    assertContentEquals(intArrayOf(5, 5, 5, 5, 5), maxValue(nums))
  }

  @Test
  fun keepsNonDecreasingValuesAsSingleIndexComponents() {
    val nums = intArrayOf(1, 1, 2, 3, 3)

    assertContentEquals(intArrayOf(1, 1, 2, 3, 3), maxValue(nums))
  }

  @Test
  fun mergesMultipleOverlappingInversionRanges() {
    val nums = intArrayOf(3, 1, 4, 2, 5)

    assertContentEquals(intArrayOf(4, 4, 4, 4, 5), maxValue(nums))
  }
}
