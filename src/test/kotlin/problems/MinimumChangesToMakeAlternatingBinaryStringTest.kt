import org.junit.jupiter.api.Test
import problems.minOperations
import kotlin.test.assertEquals

class MinimumChangesToMakeAlternatingBinaryStringTest {

  @Test
  fun `test example 1`() {
    assertEquals(0, minOperations("010"))
  }

  @Test
  fun `test example 2`() {
    assertEquals(1, minOperations("0100"))
  }

  @Test
  fun `test example 3`() {
    assertEquals(0, minOperations("10"))
  }

  @Test
  fun `test all zeros`() {
    assertEquals(2, minOperations("0000"))
  }

  @Test
  fun `test all ones`() {
    assertEquals(2, minOperations("1111"))
  }

  @Test
  fun `test already alternating starting with 0`() {
    assertEquals(0, minOperations("010101"))
  }

  @Test
  fun `test already alternating starting with 1`() {
    assertEquals(0, minOperations("101010"))
  }

  @Test
  fun `test single character`() {
    assertEquals(0, minOperations("0"))
    assertEquals(0, minOperations("1"))
  }

  @Test
  fun `test mixed pattern`() {
    assertEquals(2, minOperations("111000"))
  }
}
