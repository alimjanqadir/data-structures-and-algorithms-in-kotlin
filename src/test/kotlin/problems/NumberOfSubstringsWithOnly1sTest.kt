package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfSubstringsWithOnly1sTest {
  private val solution = NumberOfSubstringsWithOnly1s()

  @Test
  fun testNumSub() {
    // Test case 1: Single '1'
    assertEquals(1, solution.numSub("1"))
        
    // Test case 2: Multiple '1's together
    assertEquals(6, solution.numSub("111"))  // 3 + 2 + 1 = 6
        
    // Test case 3: Mixed '0's and '1's
    assertEquals(9, solution.numSub("10111"))  // 1 + (3+2+1) + 1 = 8
        
    // Test case 4: All '1's
    assertEquals(55, solution.numSub("1111111111"))  // Sum of first 10 natural numbers
        
    // Test case 5: All '0's
    assertEquals(0, solution.numSub("0000"))
        
    // Test case 6: Empty string
    assertEquals(0, solution.numSub(""))
        
    // Test case 7: Large input
    val largeInput = "1".repeat(100000)
    assertEquals(5000150001L % 1000000007, solution.numSub(largeInput).toLong())
  }
}
