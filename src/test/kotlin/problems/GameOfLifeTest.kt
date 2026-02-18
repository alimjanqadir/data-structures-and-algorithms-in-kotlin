package problems

import kotlin.test.Test
import kotlin.test.assertTrue

class GameOfLifeTest {

  private fun assert2DArrayContentEquals(expected: Array<IntArray>, actual: Array<IntArray>) {
    assertTrue(expected.size == actual.size, "Arrays have different sizes: ${expected.size} vs ${actual.size}")
    for (i in expected.indices) {
      assertTrue(expected[i].size == actual[i].size, "Row $i has different sizes: ${expected[i].size} vs ${actual[i].size}")
      for (j in expected[i].indices) {
        assertTrue(expected[i][j] == actual[i][j], "Element at [$i][$j] differs: expected ${expected[i][j]}, actual ${actual[i][j]}")
      }
    }
  }

  @Test
  fun testGameOfLifeBasicExample() {
    // Test case 1: Basic example from LeetCode
    val input = arrayOf(
      intArrayOf(0, 1, 0),
      intArrayOf(0, 0, 1),
      intArrayOf(1, 1, 1),
      intArrayOf(0, 0, 0)
    )
    val expected = arrayOf(
      intArrayOf(0, 0, 0),
      intArrayOf(1, 0, 1),
      intArrayOf(0, 1, 1),
      intArrayOf(0, 1, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeSingleCell() {
    // Test case 2: Single cell
    val input = arrayOf(
      intArrayOf(1)
    )
    val expected = arrayOf(
      intArrayOf(0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeAllDead() {
    // Test case 3: All dead cells
    val input = arrayOf(
      intArrayOf(0, 0),
      intArrayOf(0, 0)
    )
    val expected = arrayOf(
      intArrayOf(0, 0),
      intArrayOf(0, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeAllAlive() {
    // Test case 4: All alive cells (should die due to overpopulation)
    val input = arrayOf(
      intArrayOf(1, 1),
      intArrayOf(1, 1)
    )
    val expected = arrayOf(
      intArrayOf(1, 1),
      intArrayOf(1, 1)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeStablePattern() {
    // Test case 5: Stable pattern (block)
    val input = arrayOf(
      intArrayOf(1, 1),
      intArrayOf(1, 1)
    )
    val expected = arrayOf(
      intArrayOf(1, 1),
      intArrayOf(1, 1)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeOscillatorPattern() {
    // Test case 6: Blinker oscillator
    val input = arrayOf(
      intArrayOf(0, 1, 0),
      intArrayOf(0, 1, 0),
      intArrayOf(0, 1, 0)
    )
    val expected = arrayOf(
      intArrayOf(0, 0, 0),
      intArrayOf(1, 1, 1),
      intArrayOf(0, 0, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeBirthPattern() {
    // Test case 7: Birth pattern (3 neighbors create life)
    val input = arrayOf(
      intArrayOf(1, 1, 0),
      intArrayOf(1, 0, 0),
      intArrayOf(0, 0, 0)
    )
    val expected = arrayOf(
      intArrayOf(1, 1, 0),
      intArrayOf(1, 1, 0),
      intArrayOf(0, 0, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeUnderpopulation() {
    // Test case 8: Underpopulation (less than 2 neighbors die)
    val input = arrayOf(
      intArrayOf(0, 1, 0),
      intArrayOf(0, 0, 0),
      intArrayOf(0, 0, 0)
    )
    val expected = arrayOf(
      intArrayOf(0, 0, 0),
      intArrayOf(0, 0, 0),
      intArrayOf(0, 0, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeOverpopulation() {
    // Test case 9: Overpopulation (more than 3 neighbors die)
    val input = arrayOf(
      intArrayOf(1, 1, 1),
      intArrayOf(1, 1, 0),
      intArrayOf(0, 0, 0)
    )
    val expected = arrayOf(
      intArrayOf(1, 0, 1),
      intArrayOf(1, 0, 1),
      intArrayOf(0, 0, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeLargerGrid() {
    // Test case 10: Larger grid with mixed pattern
    val input = arrayOf(
      intArrayOf(0, 0, 0, 0, 0),
      intArrayOf(0, 1, 1, 0, 0),
      intArrayOf(0, 1, 0, 1, 0),
      intArrayOf(0, 0, 1, 0, 0),
      intArrayOf(0, 0, 0, 0, 0)
    )
    val expected = arrayOf(
      intArrayOf(0, 0, 0, 0, 0),
      intArrayOf(0, 1, 1, 0, 0),
      intArrayOf(0, 1, 0, 1, 0),
      intArrayOf(0, 0, 1, 0, 0),
      intArrayOf(0, 0, 0, 0, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }

  @Test
  fun testGameOfLifeEdgeCells() {
    // Test case 11: Edge cells behavior
    val input = arrayOf(
      intArrayOf(1, 0, 1),
      intArrayOf(0, 1, 0),
      intArrayOf(1, 0, 1)
    )
    val expected = arrayOf(
      intArrayOf(0, 1, 0),
      intArrayOf(1, 0, 1),
      intArrayOf(0, 1, 0)
    )

    gameOfLife(input)
    assert2DArrayContentEquals(expected, input)
  }
}
