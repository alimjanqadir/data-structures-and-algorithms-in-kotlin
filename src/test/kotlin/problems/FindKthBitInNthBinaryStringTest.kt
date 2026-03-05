import org.junit.jupiter.api.Test
import problems.findKthBit
import kotlin.test.assertEquals

class FindKthBitInNthBinaryStringTest {

  @Test
  fun `test example 1`() {
    // S1 = "0"
    assertEquals('0', findKthBit(1, 1))
  }

  @Test
  fun `test example 2`() {
    // S2 = "011"
    assertEquals('0', findKthBit(2, 1))
    assertEquals('1', findKthBit(2, 2))
    assertEquals('1', findKthBit(2, 3))
  }

  @Test
  fun `test example 3`() {
    // S3 = "0111001"
    assertEquals('0', findKthBit(3, 1))
    assertEquals('1', findKthBit(3, 2))
    assertEquals('1', findKthBit(3, 3))
    assertEquals('1', findKthBit(3, 4))
    assertEquals('0', findKthBit(3, 5))
    assertEquals('0', findKthBit(3, 6))
    assertEquals('1', findKthBit(3, 7))
  }

  @Test
  fun `test middle position`() {
    // Middle position should always be '1'
    assertEquals('1', findKthBit(2, 2))
    assertEquals('1', findKthBit(3, 4))
    assertEquals('1', findKthBit(4, 8))
  }

  @Test
  fun `test mirrored positions`() {
    // Test that mirrored positions are inverted
    // In S3 = "0111001", position 1 and 7 are mirrored
    assertEquals('0', findKthBit(3, 1))
    assertEquals('1', findKthBit(3, 7)) // inverted

    // In S3, position 2 and 6 are mirrored
    assertEquals('1', findKthBit(3, 2))
    assertEquals('0', findKthBit(3, 6)) // inverted
  }

  @Test
  fun `test larger n`() {
    // Test with n=4, S4 = "011100110110001"
    assertEquals('0', findKthBit(4, 1))
    assertEquals('1', findKthBit(4, 2))
    assertEquals('1', findKthBit(4, 3))
    assertEquals('1', findKthBit(4, 4))
    assertEquals('0', findKthBit(4, 5))
    assertEquals('0', findKthBit(4, 6))
    assertEquals('1', findKthBit(4, 7))
    assertEquals('1', findKthBit(4, 8)) // middle
    assertEquals('0', findKthBit(4, 9))
    assertEquals('1', findKthBit(4, 10))
    assertEquals('1', findKthBit(4, 11))
    assertEquals('0', findKthBit(4, 12))
    assertEquals('0', findKthBit(4, 13))
    assertEquals('0', findKthBit(4, 14))
    assertEquals('1', findKthBit(4, 15))
    assertEquals('1', findKthBit(4, 16))
  }

  @Test
  fun `test edge cases`() {
    // Test first and last positions for various n
    assertEquals('0', findKthBit(2, 1))
    assertEquals('1', findKthBit(2, 3))

    assertEquals('0', findKthBit(3, 1))
    assertEquals('1', findKthBit(3, 7))

    assertEquals('0', findKthBit(4, 1))
    assertEquals('1', findKthBit(4, 16))
  }
}
