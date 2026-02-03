package problems

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NumberOfSubstringsWithOnly1sTest {
  @Test
  fun testNumSub() {
    // Test case 1: Single '1'
    assertEquals(1, numberOfSubstrings("1"))

    // Test case 2: Multiple '1's together
    assertEquals(6, numberOfSubstrings("111"))  // 3 + 2 + 1 = 6

    // Test case 3: Mixed '0's and '1's
    assertEquals(14, numberOfSubstrings("10111"))

    // Test case 4: All '1's
    assertEquals(55, numberOfSubstrings("1111111111"))  // Sum of first 10 natural numbers

    // Test case 5: All '0's
    assertEquals(0, numberOfSubstrings("0000"))

    // Test case 6: Empty string
    assertEquals(0, numberOfSubstrings(""))

    // Test case 7: Large input
    val largeInput = "1".repeat(100000)
    assertEquals(705082704, numberOfSubstrings(largeInput))
  }
}
