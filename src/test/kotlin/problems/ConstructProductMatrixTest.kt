package problems

import kotlin.test.Test
import kotlin.test.assertContentEquals

class ConstructProductMatrixTest {

  @Test
  fun testConstructProductMatrixExample1() {
    // Example 1: grid = [[1,2],[3,4]]
    // Expected: [[24,12],[8,6]]
    val grid = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(3, 4)
    )
    val expected = arrayOf(
      intArrayOf(24, 12),
      intArrayOf(8, 6)
    )
    val result = constructProductMatrix(grid)
    assertContentEquals(expected[0], result[0])
    assertContentEquals(expected[1], result[1])
  }

  @Test
  fun testConstructProductMatrixExample2() {
    // Example 2: grid = [[12345],[2],[1]]
    // Expected: [[2],[0],[0]]
    val grid = arrayOf(
      intArrayOf(12345),
      intArrayOf(2),
      intArrayOf(1)
    )
    val expected = arrayOf(
      intArrayOf(2),
      intArrayOf(0),
      intArrayOf(0)
    )
    val result = constructProductMatrix(grid)
    assertContentEquals(expected[0], result[0])
    assertContentEquals(expected[1], result[1])
    assertContentEquals(expected[2], result[2])
  }

  @Test
  fun testConstructProductMatrixSingleElement() {
    // Single element: product of all except itself is 1 (empty product)
    // But since grid[0][0] % 12345 = 5, and we need product of all others
    // For single element, that means product of empty set = 1
    val grid = arrayOf(intArrayOf(5))
    val expected = arrayOf(intArrayOf(1))
    val result = constructProductMatrix(grid)
    assertContentEquals(expected[0], result[0])
  }

  @Test
  fun testConstructProductMatrixWithMultipleZeros() {
    // More than one zero: all results should be 0
    val grid = arrayOf(
      intArrayOf(0, 1),
      intArrayOf(2, 0)
    )
    val expected = arrayOf(
      intArrayOf(0, 0),
      intArrayOf(0, 0)
    )
    val result = constructProductMatrix(grid)
    assertContentEquals(expected[0], result[0])
    assertContentEquals(expected[1], result[1])
  }

  @Test
  fun testConstructProductMatrixWithOneZero() {
    // Exactly one zero: position with 0 gets product of non-zeros, others get 0
    val grid = arrayOf(
      intArrayOf(1, 2),
      intArrayOf(0, 4)
    )
    // Product of non-zeros: 1 * 2 * 4 = 8
    val expected = arrayOf(
      intArrayOf(0, 0),
      intArrayOf(8, 0)
    )
    val result = constructProductMatrix(grid)
    assertContentEquals(expected[0], result[0])
    assertContentEquals(expected[1], result[1])
  }

  @Test
  fun testConstructProductMatrixModulo() {
    // Test that modulo 12345 is applied correctly
    val grid = arrayOf(
      intArrayOf(12346, 1), // 12346 % 12345 = 1
      intArrayOf(1, 1)
    )
    // Products: p[0][0] = 1*1*1 = 1, p[0][1] = 1*1*1 = 1, etc.
    val expected = arrayOf(
      intArrayOf(1, 1),
      intArrayOf(1, 1)
    )
    val result = constructProductMatrix(grid)
    assertContentEquals(expected[0], result[0])
    assertContentEquals(expected[1], result[1])
  }
}
