package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MinimumOperationsToMakeAGCDGreaterThanOneTest {
    
  @Test
  fun testMinOperations() {
    val testCases = listOf(
      intArrayOf(2, 3, 6) to 3,
      intArrayOf(4, 6, 8) to -1,
      intArrayOf(1, 1, 1) to 0,
      intArrayOf(2, 2, 2) to -1,
      intArrayOf(1, 2, 3, 4, 5) to 4
    )
        
    for ((input, expected) in testCases) {
      assertEquals(expected, minOperationsToMakeGCDOne(input), 
        "Test failed for input: ${input.contentToString()}")
    }
  }
}
