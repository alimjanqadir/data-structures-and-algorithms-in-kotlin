package problems.nozerointegers

import kotlin.test.assertContentEquals
import org.junit.jupiter.api.Test

class GetNoZeroIntegersTest {
  private val solution = Solution()

  @Test
  fun providedExamples() {
    assertContentEquals(intArrayOf(1, 1), solution.getNoZeroIntegers(2))
    assertContentEquals(intArrayOf(2, 9), solution.getNoZeroIntegers(11))
    assertContentEquals(intArrayOf(1, 9999), solution.getNoZeroIntegers(10000))
  }
}

