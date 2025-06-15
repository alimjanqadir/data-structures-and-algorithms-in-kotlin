package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MaxDifferenceYouCanGetFromChangingAnIntegerTest {
  @Test
  fun providedExamples() {
    assertEquals(888, maxDiff(555))
    assertEquals(8, maxDiff(9))
  }

  @Test
  fun additionalCases() {
    assertEquals(820000, maxDiff(123456))
    assertEquals(80000, maxDiff(10000))
  }
}
