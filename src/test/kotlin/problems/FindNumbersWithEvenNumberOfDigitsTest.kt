import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindNumbersWithEvenNumberOfDigitsTest {
  @Test
  fun testExample1() {
    val nums = intArrayOf(12, 345, 2, 6, 7896)
    val result = findNumbersWithEvenNumberOfDigits(nums)
    assertEquals(2, result)
  }

  @Test
  fun testExample2() {
    val nums = intArrayOf(555, 901, 482, 1771)
    val result = findNumbersWithEvenNumberOfDigits(nums)
    assertEquals(1, result)
  }

  @Test
  fun testAllEvenDigits() {
    val nums = intArrayOf(22, 44, 66, 88)
    val result = findNumbersWithEvenNumberOfDigits(nums)
    assertEquals(4, result)
  }

  @Test
  fun testAllOddDigits() {
    val nums = intArrayOf(1, 123, 555, 777)
    val result = findNumbersWithEvenNumberOfDigits(nums)
    assertEquals(0, result)
  }

  @Test
  fun testEmptyArray() {
    val nums = intArrayOf()
    val result = findNumbersWithEvenNumberOfDigits(nums)
    assertEquals(0, result)
  }
}
