package problems

import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseBitsTest {

  @Test
  fun testReverseBits() {
    // Test case 1: Input 0 (binary: 00000000000000000000000000000000)
    // Expected: 0 (binary: 00000000000000000000000000000000)
    assertEquals(0, reverseBits(0))

    // Test case 2: Input 1 (binary: 00000000000000000000000000000001)
    // Expected: 2147483648 (binary: 10000000000000000000000000000000)
    assertEquals(2147483648.toInt(), reverseBits(1))

    // Test case 3: Input 43261596 (binary: 00000010100101000001111010011100)
    // Expected: 964176192 (binary: 00111001011110000010100101000000)
    assertEquals(964176192, reverseBits(43261596))

    // Test case 4: Input 4294967293 (binary: 11111111111111111111111111111101)
    // Expected: 3221225471 (binary: 10111111111111111111111111111111)
    assertEquals(3221225471.toInt(), reverseBits(4294967293.toInt()))

    // Test case 5: Input -1 (binary: 11111111111111111111111111111111 in two's complement)
    // Expected: -1 (binary: 11111111111111111111111111111111)
    assertEquals(-1, reverseBits(-1))

    // Test case 6: Input Int.MAX_VALUE (binary: 01111111111111111111111111111111)
    // Expected: -2 (binary: 11111111111111111111111111111110)
    assertEquals(-2, reverseBits(Int.MAX_VALUE))

    // Test case 7: Input Int.MIN_VALUE (binary: 10000000000000000000000000000000)
    // Expected: 1 (binary: 00000000000000000000000000000001)
    assertEquals(1, reverseBits(Int.MIN_VALUE))

    // Test case 8: Input 255 (binary: 00000000000000000000000011111111)
    // Expected: -16777216 (binary: 11111111000000000000000000000000)
    assertEquals(-16777216, reverseBits(255))

    // Test case 9: Input 16 (binary: 00000000000000000000000000010000)
    // Expected: 134217728 (binary: 00001000000000000000000000000000)
    assertEquals(134217728, reverseBits(16))

    // Test case 10: Input -2147483648 (binary: 10000000000000000000000000000000)
    // Expected: 1 (binary: 00000000000000000000000000000001)
    assertEquals(1, reverseBits(-2147483648))
  }
}
