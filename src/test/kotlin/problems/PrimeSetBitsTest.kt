package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class PrimeSetBitsTest {

  @Test
  fun testCountPrimeSetBits() {
    // Test case 1: Example from LeetCode - left = 6, right = 10
    // Numbers: 6(110), 7(111), 8(1000), 9(1001), 10(1010)
    // Bit counts: 2, 3, 1, 2, 1
    // Prime counts: 3 (for 7), 2 (for 6, 9, 10), 2 (for 8, 10)
    // Total: 4 numbers (6, 7, 9, 10)
    assertEquals(4, countPrimeSetBits(6, 10))

    // Test case 2: Example from LeetCode - left = 10, right = 15
    // Numbers: 10(1010), 11(1011), 12(1100), 13(1101), 14(1110), 15(1111)
    // Bit counts: 2, 3, 2, 3, 3, 4
    // Prime counts: 2, 3, 2, 3, 3, 4
    // Total: 5 numbers (10, 11, 12, 13, 14)
    assertEquals(5, countPrimeSetBits(10, 15))

    // Test case 3: Single number - prime bit count
    assertEquals(1, countPrimeSetBits(7, 7)) // 7 has 3 set bits (prime)

    // Test case 4: Single number - non-prime bit count
    assertEquals(0, countPrimeSetBits(8, 8)) // 8 has 1 set bit (not prime)

    // Test case 5: Range with no prime bit counts
    assertEquals(0, countPrimeSetBits(1, 1)) // 1 has 1 set bit (not prime)

    // Test case 6: Small range
    // Numbers: 2(10), 3(11), 4(100), 5(101)
    // Bit counts: 1, 2, 1, 2
    // Prime counts: 1, 2, 1, 2
    // Total: 2 numbers (3, 5)
    assertEquals(2, countPrimeSetBits(2, 5))

    // Test case 7: Larger range
    assertEquals(14, countPrimeSetBits(1, 20))

    // Test case 8: Edge case - same start and end
    assertEquals(1, countPrimeSetBits(3, 3)) // 3 has 2 set bits (prime)

    // Test case 9: Range with maximum bit count
    // Test numbers with high bit counts
    assertEquals(1, countPrimeSetBits(31, 31)) // 31 has 5 set bits (prime)

    // Test case 10: Range with bit count 0 (shouldn't happen with positive integers)
    assertEquals(0, countPrimeSetBits(0, 0)) // 0 has 0 set bits (not prime)
  }

  @Test
  fun testPrimeMaskLogic() {
    // Test the prime mask logic directly
    // Prime numbers up to 20: 2, 3, 5, 7, 11, 13, 17, 19
    // Binary representation of mask should have 1s at these positions
    
    // Test known prime bit counts
    assertEquals(1, countPrimeSetBits(3, 3)) // 3 has 2 set bits
    assertEquals(1, countPrimeSetBits(7, 7)) // 7 has 3 set bits
    assertEquals(1, countPrimeSetBits(31, 31)) // 31 has 5 set bits
    
    // Test known non-prime bit counts
    assertEquals(0, countPrimeSetBits(1, 1)) // 1 has 1 set bit
    assertEquals(0, countPrimeSetBits(8, 8)) // 8 has 1 set bit
    assertEquals(0, countPrimeSetBits(15, 15)) // 15 has 4 set bits
  }
}
