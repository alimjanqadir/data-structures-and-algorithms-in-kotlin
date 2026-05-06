package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class RotatingTheBoxTest {

  @Test
  fun testExample1() {
    val boxGrid = arrayOf(
      charArrayOf('#', '.', '#')
    )
    val expected = arrayOf(
      charArrayOf('.'),
      charArrayOf('#'),
      charArrayOf('#')
    )

    assertBoxEquals(expected, rotateTheBox(boxGrid))
  }

  @Test
  fun testExample2() {
    val boxGrid = arrayOf(
      charArrayOf('#', '.', '*', '.'),
      charArrayOf('#', '#', '*', '.')
    )
    val expected = arrayOf(
      charArrayOf('#', '.'),
      charArrayOf('#', '#'),
      charArrayOf('*', '*'),
      charArrayOf('.', '.')
    )

    assertBoxEquals(expected, rotateTheBox(boxGrid))
  }

  @Test
  fun testExample3() {
    val boxGrid = arrayOf(
      charArrayOf('#', '#', '*', '.', '*', '.'),
      charArrayOf('#', '#', '#', '*', '.', '.'),
      charArrayOf('#', '#', '#', '.', '#', '.')
    )
    val expected = arrayOf(
      charArrayOf('.', '#', '#'),
      charArrayOf('.', '#', '#'),
      charArrayOf('#', '#', '*'),
      charArrayOf('#', '*', '.'),
      charArrayOf('#', '.', '*'),
      charArrayOf('#', '.', '.')
    )

    assertBoxEquals(expected, rotateTheBox(boxGrid))
  }

  @Test
  fun testObstaclesSplitRowIntoIndependentSegments() {
    val boxGrid = arrayOf(
      charArrayOf('#', '.', '*', '#', '.', '.', '*', '#', '.')
    )
    val expected = arrayOf(
      charArrayOf('.'),
      charArrayOf('#'),
      charArrayOf('*'),
      charArrayOf('.'),
      charArrayOf('.'),
      charArrayOf('#'),
      charArrayOf('*'),
      charArrayOf('.'),
      charArrayOf('#')
    )

    assertBoxEquals(expected, rotateTheBox(boxGrid))
  }

  private fun assertBoxEquals(expected: Array<CharArray>, actual: Array<CharArray>) {
    assertEquals(expected.size, actual.size)
    for (rowIndex in expected.indices) {
      assertContentEquals(expected[rowIndex], actual[rowIndex])
    }
  }
}
