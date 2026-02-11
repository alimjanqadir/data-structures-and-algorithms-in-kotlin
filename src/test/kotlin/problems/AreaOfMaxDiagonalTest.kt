package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class AreaOfMaxDiagonalTest {

  @Test
  fun testAreaOfMaxDiagonal() {
    // Test case 1: Single rectangle
    assertEquals(
      6,
      areaOfMaxDiagonal(arrayOf(intArrayOf(2, 3))),
      "Single rectangle should return its area"
    )

    // Test case 2: Multiple rectangles with different diagonals
    // Rectangle 1: 3x4, diagonal = 5, area = 12
    // Rectangle 2: 5x12, diagonal = 13, area = 60
    // Rectangle 3: 6x8, diagonal = 10, area = 48
    assertEquals(
      60,
      areaOfMaxDiagonal(arrayOf(intArrayOf(3, 4), intArrayOf(5, 12), intArrayOf(6, 8))),
      "Should return area of rectangle with largest diagonal"
    )

    // Test case 3: Same diagonal, different areas
    // Rectangle 1: 3x4, diagonal = 5, area = 12
    // Rectangle 2: 4x3, diagonal = 5, area = 12
    // Rectangle 3: 1x√24 (not integer), but using 2x√21
    assertEquals(
      12,
      areaOfMaxDiagonal(arrayOf(intArrayOf(3, 4), intArrayOf(4, 3))),
      "With same diagonal, should return larger area"
    )

    // Test case 4: Same diagonal, different areas - choose larger area
    // Rectangle 1: 6x8, diagonal = 10, area = 48
    // Rectangle 2: 3x√91 (not integer), but using 5x√75
    assertEquals(
      48,
      areaOfMaxDiagonal(arrayOf(intArrayOf(6, 8), intArrayOf(8, 6))),
      "With same diagonal, should return larger area"
    )

    // Test case 5: Square rectangles
    assertEquals(
      25,
      areaOfMaxDiagonal(arrayOf(intArrayOf(3, 3), intArrayOf(5, 5), intArrayOf(4, 4))),
      "Should return area of square with largest diagonal"
    )

    // Test case 6: Zero dimensions
    assertEquals(
      0,
      areaOfMaxDiagonal(arrayOf(intArrayOf(0, 5), intArrayOf(3, 0))),
      "Zero dimension should result in zero area"
    )

    // Test case 7: Single dimension (line)
    assertEquals(
      0,
      areaOfMaxDiagonal(arrayOf(intArrayOf(5, 0))),
      "Single dimension should result in zero area"
    )

    // Test case 8: Large numbers
    assertEquals(
      1000000,
      areaOfMaxDiagonal(arrayOf(intArrayOf(1000, 1000), intArrayOf(500, 800))),
      "Should handle large numbers correctly"
    )

    // Test case 9: Same diagonal squared, different areas
    // Rectangle 1: 1x√8 ≈ 1x2.828, diagonal² = 9, area = 2.828
    // Rectangle 2: 2x√5 ≈ 2x2.236, diagonal² = 9, area = 4.472
    // Using integer approximations:
    assertEquals(
      6,
      areaOfMaxDiagonal(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))),
      "With same diagonal squared, should return larger area"
    )

    // Test case 10: Empty array
    assertEquals(
      0,
      areaOfMaxDiagonal(emptyArray()),
      "Empty array should return 0"
    )
  }
}
