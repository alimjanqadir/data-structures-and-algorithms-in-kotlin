package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PascalTriangleTest {
  @Test
  fun testGenerate() {
    val expected = listOf(
      listOf(1),
      listOf(1, 1),
      listOf(1, 2, 1),
      listOf(1, 3, 3, 1),
      listOf(1, 4, 6, 4, 1)
    )
    assertEquals(expected, generate(5))
    assertEquals(listOf(listOf(1)), generate(1))
  }
}
