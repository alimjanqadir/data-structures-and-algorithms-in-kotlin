package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals

class LexicographicalNumbersTest {
  @Test
  fun testSmallValues() {
    assertContentEquals(listOf(1), lexicalOrder(1))
    assertContentEquals(listOf(1, 2), lexicalOrder(2))
  }

  @Test
  fun testExample() {
    val expected = listOf(1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9)
    assertContentEquals(expected, lexicalOrder(13))
  }
}
