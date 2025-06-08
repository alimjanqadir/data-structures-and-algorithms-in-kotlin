package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TriangleTypeTest {
  @Test
  fun testTriangleType() {
    // Test case 1: Scalene triangle
    assertEquals("scalene", triangleType(intArrayOf(3, 4, 5)))
        
    // Test case 2: Equilateral triangle
    assertEquals("equilateral", triangleType(intArrayOf(3, 3, 3)))
        
    // Test case 3: Isosceles triangle (first two sides equal)
    assertEquals("isosceles", triangleType(intArrayOf(3, 3, 4)))
        
    // Test case 4: Isosceles triangle (last two sides equal)
    assertEquals("isosceles", triangleType(intArrayOf(3, 4, 4)))
        
    // Test case 5: Not a triangle
    assertEquals("none", triangleType(intArrayOf(1, 1, 3)))
        
    // Test case 6: Not a triangle (sum of two sides equals the third)
    assertEquals("none", triangleType(intArrayOf(1, 2, 3)))
  }
}
